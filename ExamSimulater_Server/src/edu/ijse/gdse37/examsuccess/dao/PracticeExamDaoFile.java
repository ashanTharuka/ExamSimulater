/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.dao;

import edu.ijse.gdse37.examsuccess.daosuper.SuperDaoPracticeExam;
import edu.ijse.gdse37.examsuccess.model.Question;
import edu.ijse.gdse37.examsuccess.other.Encrypt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Ashan Tharuka
 */
public class PracticeExamDaoFile extends Encrypt implements SuperDaoPracticeExam {

    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String readLine = null;
    private final static ReentrantReadWriteLock READWRITELOCK = new ReentrantReadWriteLock();

    /**
     *
     * @param type
     * @param key
     * @param path
     * @param fileName
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    @Override
     public Question SearchQuestion(String type, String key, String path, String fileName) throws FileNotFoundException, IOException, RemoteException {
        try {
            READWRITELOCK.readLock().lock();
            Question q = null;
            File f3 = new File(path + "/" + fileName);
            if (f3.exists()) {

                FileReader reader = new FileReader(f3);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] QuestionList = line.split(":");

                    if ("Q".equals(type)) {
                        for (int i = 0; i < QuestionList.length; i++) {
                            if (i % 13 == 0) {
                                if (QuestionList[i].equals(key)) {
                                    q = new Question(QuestionList[i], QuestionList[i + 1], QuestionList[i + 2], QuestionList[i + 3], QuestionList[i + 4], QuestionList[i + 5], QuestionList[i + 6], QuestionList[i + 7], QuestionList[i + 8], QuestionList[i + 9], QuestionList[i + 10], QuestionList[i + 11], QuestionList[i + 12]);
                                }
                            }

                        }
                    }

                }
            }

            return q;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }
}
