/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.dao;

import edu.ijse.gdse37.examsuccess.daosuper.SuperDaoBatch;
import edu.ijse.gdse37.examsuccess.other.Encrypt;
import edu.ijse.gdse37.examsuccess.model.Batch;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Ashan Tharuka
 */
public class BatchDaoFile extends Encrypt implements SuperDaoBatch {

    //File Path
    private final File F1 = new File("./Database/Batch/batch.txt");

    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String readLine = null;
    private final static ReentrantReadWriteLock READWRITELOCK = new ReentrantReadWriteLock();

    /**
     *
     * @param batch
     * @return
     * @throws IOException
     */
    @Override
    public boolean addBatch(Batch batch) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();
            fileWriter = new FileWriter(F1, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            String row = batch.getId() + ":" + batch.getBatchName() + ":";
            String line = cipher(row);
            if (bufferedWriter.append(line) != null) {
                bufferedWriter.flush();
                bufferedWriter.close();
                return true;
            } else {
                return false;
            }
        } finally {
            READWRITELOCK.writeLock().unlock();
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws IOException
     */
    @Override
    public boolean deleteBatch(String id) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();
            String[] batchList = null;
            if (F1.exists()) {
                FileReader fileReader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    batchList = line.split(":");
                }
            }
            String[] newBatchList = new String[batchList.length - 2];// what we want to delete line substract from list//model has 2 item
            for (int i = 0, x = 0; i < batchList.length; i++) {
                if (batchList[i].equals(id)) {
                    i += 1;//miss 2 item//
                } else {
                    newBatchList[x] = batchList[i];//store other vlues in array for write
                    x++;
                }
            }
            FileWriter writer = new FileWriter(F1, false);
            for (int i = 0; i < newBatchList.length; i++) {
                writer.write(cipher(newBatchList[i] + ":"));
                writer.flush();
            }

            FileReader reader = new FileReader(F1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            try {
                newBatchList = line.split(":");
            } catch (NullPointerException ex) {
            }
            if (batchList.length != newBatchList.length) {
                return true;
            } else {
                return false;
            }
        } finally {
            READWRITELOCK.writeLock().unlock();
        }

    }

    /**
     *
     * @param type
     * @param key
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public Batch SearchBatch(String type, String key) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Batch batch = null;
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] batchList = line.split(":");

                    if ("id".equals(type)) {
                        for (int i = 0; i < batchList.length; i++) {
                            if (batchList[i].equals(key)) {
                                batch = new Batch(batchList[i], batchList[i + 1]);
                            }
                        }
                    }

                    if ("batchName".equals(type)) {
                        for (int i = 0; i < batchList.length - 1; i++) {
                            if (batchList[i + 3].equals(key)) {
                                batch = new Batch(batchList[i], batchList[i + 1]);
                            }
                        }
                    }

                }
            }

            return batch;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param batch
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @Override
    public boolean updateBatch(Batch batch) throws ClassNotFoundException, IOException {
        try {
            READWRITELOCK.writeLock().lock();
            String[] batchList = null;
            //first : read all data of file
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    batchList = line.split(":");
                }
            }

            //update 
            int updated = 0;
            for (int i = 0; i < batchList.length; i++) {
                if (batchList[i].equals(batch.getId())) {
                    updated = i;
                    batchList[i] = batch.getId();
                    batchList[i + 1] = batch.getBatchName();

                    i += 1;
                }
            }
            //write update data
            FileWriter fileWriter = new FileWriter(F1, false);
            for (int i = 0; i < batchList.length; i++) {
                fileWriter.write(cipher(batchList[i] + ":"));
                fileWriter.flush();
            }
            //read all data again and check wheather update or not
            FileReader reader = new FileReader(F1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            String[] newBatchList = line.split(":");
            if (batchList.length == newBatchList.length) {//check array list size eual or not

                if (newBatchList[updated].equals(batch.getId())) {
                    if (newBatchList[updated + 1].equals(batch.getBatchName())) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } finally {
            READWRITELOCK.writeLock().unlock();
        }
    }

    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public ArrayList<Batch> getAllBatch() throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Batch batch = null;
            FileReader reader = new FileReader(F1);
            ArrayList<Batch> batchList = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            if (line != null) {
                String[] split = line.split(":");
                for (int i = 0; i < split.length; i++) {
                    if (i % 2 == 0) {
                        batch = new Batch(split[i], split[i + 1]);
                        batchList.add(batch);
                    }
                }
            }
            return batchList;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public boolean searchId(String id) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            boolean ans = false;

            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] AdminList = line.split(":");

                    for (int i = 0; i < AdminList.length; i++) {
                        if (AdminList[i].equals(id)) {
                            ans = true;
                        }
                    }

                }
            }

            return ans;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }
}
