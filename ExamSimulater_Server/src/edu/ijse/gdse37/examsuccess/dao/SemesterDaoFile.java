/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.dao;

import edu.ijse.gdse37.examsuccess.daosuper.SuperDaoSemester;
import edu.ijse.gdse37.examsuccess.other.Encrypt;
import edu.ijse.gdse37.examsuccess.model.Cemester;
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
public class SemesterDaoFile extends Encrypt implements SuperDaoSemester{

    //File Path
    private final File F1 = new File("./Database/Cemester/Cemester.txt");
    private final static ReentrantReadWriteLock READWRITELOCK = new ReentrantReadWriteLock();
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String readLine = null;

    /**
     *
     * @param cemester
     * @return
     * @throws IOException
     */
    @Override
    public boolean addCemester(Cemester cemester) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();
            fileWriter = new FileWriter(F1, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            String row = cemester.getId() + ":" + cemester.getCemesterName() + ":";
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
    public boolean deleteCemester(String id) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();
            String[] cemesterList = null;
            if (F1.exists()) {
                FileReader fileReader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    cemesterList = line.split(":");
                }
            }
            String[] newCemesterList = new String[cemesterList.length - 2];// what we want to delete line substract from list//model has 2 item
            for (int i = 0, x = 0; i < cemesterList.length; i++) {
                if (cemesterList[i].equals(id)) {
                    i += 1;//miss 2 item//
                } else {
                    newCemesterList[x] = cemesterList[i];//store other vlues in array for write
                    x++;
                }
            }
            FileWriter writer = new FileWriter(F1, false);
            for (int i = 0; i < newCemesterList.length; i++) {
                writer.write(cipher(newCemesterList[i] + ":"));
                writer.flush();
            }

            FileReader reader = new FileReader(F1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            try {
                newCemesterList = line.split(":");
            } catch (NullPointerException ex) {
            }
            if (cemesterList.length != newCemesterList.length) {
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
    public Cemester SearchCemester(String type, String key) throws FileNotFoundException, IOException {

        try {
            READWRITELOCK.readLock().lock();
            Cemester cemester = null;

            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] cemesterList = line.split(":");

                    if ("id".equals(type)) {
                        for (int i = 0; i < cemesterList.length; i++) {
                            if (cemesterList[i].equals(key)) {
                                cemester = new Cemester(cemesterList[i], cemesterList[i + 1]);
                            }
                        }
                    }

                    if ("cemesterName".equals(type)) {
                        for (int i = 0; i < cemesterList.length - 1; i++) {
                            if (cemesterList[i + 1].equals(key)) {
                                cemester = new Cemester(cemesterList[i], cemesterList[i + 1]);
                            }
                        }
                    }

                }
            }

            return cemester;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param cemester
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @Override
    public boolean updateCemester(Cemester cemester) throws ClassNotFoundException, IOException {
        try {
            READWRITELOCK.writeLock().lock();
            String[] cemesterList = null;
            //first : read all data of file
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    cemesterList = line.split(":");
                }
            }

            //update 
            int updated = 0;
            for (int i = 0; i < cemesterList.length; i++) {
                if (cemesterList[i].equals(cemester.getId())) {
                    updated = i;
                    cemesterList[i] = cemester.getId();
                    cemesterList[i + 1] = cemester.getCemesterName();

                    i += 1;
                }
            }
            //write update data
            FileWriter fileWriter = new FileWriter(F1, false);
            for (int i = 0; i < cemesterList.length; i++) {
                fileWriter.write(cipher(cemesterList[i] + ":"));
                fileWriter.flush();
            }
            //read all data again and check wheather update or not
            FileReader reader = new FileReader(F1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            String[] newCemesterList = line.split(":");
            if (cemesterList.length == newCemesterList.length) {//check array list size eual or not

                if (newCemesterList[updated].equals(cemester.getId())) {
                    if (newCemesterList[updated + 1].equals(cemester.getCemesterName())) {
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
    public ArrayList<Cemester> getAllCemester() throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Cemester cemester = null;
            FileReader reader = new FileReader(F1);
            ArrayList<Cemester> cemesterList = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            if (line != null) {
                String[] split = line.split(":");
                for (int i = 0; i < split.length; i++) {
                    if (i % 2 == 0) {
                        cemester = new Cemester(split[i], split[i + 1]);
                        cemesterList.add(cemester);
                    }
                }
            }
            return cemesterList;
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
