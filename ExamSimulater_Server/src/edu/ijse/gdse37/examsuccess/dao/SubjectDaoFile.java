/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.dao;

import edu.ijse.gdse37.examsuccess.daosuper.SuperDaoSubject;
import edu.ijse.gdse37.examsuccess.other.Encrypt;
import edu.ijse.gdse37.examsuccess.model.Subject;
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
public class SubjectDaoFile extends Encrypt implements SuperDaoSubject{

    //File Path
    private final File F1 = new File("./Database/Subject/subject.txt");
    private final static ReentrantReadWriteLock READWRITELOCK = new ReentrantReadWriteLock();
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String readLine = null;
 
    /**
     *
     * @param subject
     * @return
     * @throws IOException
     */
    @Override
    public boolean addSubject(Subject subject) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();
            fileWriter = new FileWriter(F1, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            String row = subject.getId() + ":" + subject.getSubjectName() + ":";
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
    public boolean deleteSubject(String id) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();

            String[] subjectList = null;
            if (F1.exists()) {
                FileReader fileReader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    subjectList = line.split(":");
                }
            }
            String[] newSubjectList = new String[subjectList.length - 2];// what we want to delete line substract from list//model has 2 item
            for (int i = 0, x = 0; i < subjectList.length; i++) {
                if (subjectList[i].equals(id)) {
                    i += 1;//miss 2 item//
                } else {
                    newSubjectList[x] = subjectList[i];//store other vlues in array for write
                    x++;
                }
            }
            FileWriter writer = new FileWriter(F1, false);
            for (int i = 0; i < newSubjectList.length; i++) {
                writer.write(cipher(newSubjectList[i] + ":"));
                writer.flush();
            }

            FileReader reader = new FileReader(F1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            try {
                newSubjectList = line.split(":");
            } catch (NullPointerException ex) {
            }
            if (subjectList.length != newSubjectList.length) {
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
    public Subject SearchSubject(String type, String key) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Subject subject = null;

            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] subjectList = line.split(":");

                    if ("id".equals(type)) {
                        for (int i = 0; i < subjectList.length; i++) {
                            if (subjectList[i].equals(key)) {
                                subject = new Subject(subjectList[i], subjectList[i + 1]);
                            }
                        }
                    }

                    if ("subjectName".equals(type)) {
                        for (int i = 0; i < subjectList.length - 1; i++) {
                            if (subjectList[i + 1].equals(key)) {
                                subject = new Subject(subjectList[i], subjectList[i + 1]);
                            }
                        }
                    }

                }
            }

            return subject;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param subject
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @Override
    public boolean updateSubject(Subject subject) throws ClassNotFoundException, IOException {

        try {
            READWRITELOCK.writeLock().lock();
            String[] subjectList = null;
            //first : read all data of file
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    subjectList = line.split(":");
                }
            }

            //update 
            int updated = 0;
            for (int i = 0; i < subjectList.length; i++) {
                if (subjectList[i].equals(subject.getId())) {
                    updated = i;
                    subjectList[i] = subject.getId();
                    subjectList[i + 1] = subject.getSubjectName();

                    i += 1;
                }
            }
            //write update data
            FileWriter fileWriter = new FileWriter(F1, false);
            for (int i = 0; i < subjectList.length; i++) {
                fileWriter.write(cipher(subjectList[i] + ":"));
                fileWriter.flush();
            }
            //read all data again and check wheather update or not
            FileReader reader = new FileReader(F1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            String[] newSubjectList = line.split(":");
            if (subjectList.length == newSubjectList.length) {//check array list size eual or not

                if (newSubjectList[updated].equals(subject.getId())) {
                    if (newSubjectList[updated + 1].equals(subject.getSubjectName())) {
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
    public ArrayList<Subject> getAllSubject() throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Subject subject = null;
            FileReader reader = new FileReader(F1);
            ArrayList<Subject> subjectList = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            if (line != null) {
                String[] split = line.split(":");
                for (int i = 0; i < split.length; i++) {
                    if (i % 2 == 0) {
                        subject = new Subject(split[i], split[i + 1]);
                        subjectList.add(subject);
                    }
                }
            }
            return subjectList;
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
