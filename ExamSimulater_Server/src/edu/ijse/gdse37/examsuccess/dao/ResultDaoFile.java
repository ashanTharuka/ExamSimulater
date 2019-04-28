/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.dao;

import edu.ijse.gdse37.examsuccess.daosuper.SuperDaoResult;
import edu.ijse.gdse37.examsuccess.model.Result;
import edu.ijse.gdse37.examsuccess.other.Encrypt;
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
public class ResultDaoFile extends Encrypt implements SuperDaoResult {

    //File Path
    private final File F1 = new File("./Database/Result/Result.txt");

    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String readLine = null;
    private final static ReentrantReadWriteLock READWRITELOCK = new ReentrantReadWriteLock();

    /**
     *
     * @param result
     * @return
     * @throws IOException
     */
    @Override
    public boolean addResult(Result result) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();
            fileWriter = new FileWriter(F1, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            String row = result.getExamId() + "~" + result.getStudentId() + "~" + result.getPath() + "~" + result.getStudentAns() + "~" + result.getStartQ() + "~" + result.getEndQ() + "~" + result.getMarks() + "~" + result.getGrade() + "~" + result.getResultPath() + "~" + result.getPaperName() + "~";
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
     * @param resultPath
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public Result SearchStudentResult(String id, String resultPath) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Result result = null;

            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] resultList = line.split("~");

                    for (int i = 0; i < resultList.length - 1; i++) {
                        if (resultList[i + 1].equals(id)) {
                            if (resultList[i + 8].equals(resultPath)) {
                                result = new Result(resultList[i], resultList[i + 1], resultList[i + 2], resultList[i + 3], resultList[i + 4], resultList[i + 5], resultList[i + 6], resultList[i + 7], resultList[i + 8], resultList[i + 9]);

                            }

                        }
                    }

                }
            }

            return result;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param resultPath
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public ArrayList<Result> SearchAllStudentResult(String resultPath) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Result result = null;
            ArrayList<Result> resultList = new ArrayList<Result>();
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] allList = line.split("~");

                    for (int i = 0; i < allList.length - 8; i++) {
                        if (allList[i + 8].equals(resultPath)) {
                            result = new Result(allList[i], allList[i + 1], allList[i + 2], allList[i + 3], allList[i + 4], allList[i + 5], allList[i + 6], allList[i + 7], allList[i + 8], allList[i + 9]);
                            resultList.add(result);
                            System.out.println("All studentId: " + allList[i + 1]);
                        }
                    }

                }
            }

            return resultList;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param id
     * @param resultPath
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public boolean IsDoExam(String id, String resultPath) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            boolean ans = false;

            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] resultList = line.split("~");

                    for (int i = 0; i < resultList.length - 1; i++) {
                        if (resultList[i + 1].equals(id)) {
                            if (resultList[i + 8].equals(resultPath)) {
                                ans = true;

                            }

                        }
                    }

                }
            }

            return ans;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    @Override
    public ArrayList<Result> getStudentAllResult(String id) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Result result = null;
            ArrayList<Result> resltList = new ArrayList<>();
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] resultList = line.split("~");

                    for (int i = 0; i < resultList.length - 1; i++) {
                        if (resultList[i + 1].equals(id)) {
                            result = new Result(resultList[i], resultList[i + 1], resultList[i + 2], resultList[i + 3], resultList[i + 4], resultList[i + 5], resultList[i + 6], resultList[i + 7], resultList[i + 8], resultList[i + 9]);
                            resltList.add(result);
                        }
                    }

                }
            }

            return resltList;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }
}
