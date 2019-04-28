/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.dao;

import edu.ijse.gdse37.examsuccess.daosuper.SuperDaoQuestion;
import edu.ijse.gdse37.examsuccess.model.Exam;
import edu.ijse.gdse37.examsuccess.other.Encrypt;
import edu.ijse.gdse37.examsuccess.model.Question;
import static edu.ijse.gdse37.examsuccess.other.Encrypt.decipher;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Ashan Tharuka
 */
public class QuestionDaoFile extends Encrypt implements SuperDaoQuestion {

    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String readLine = null;
    private final static ReentrantReadWriteLock READWRITELOCK = new ReentrantReadWriteLock();

    /**
     *
     * @param q
     * @return
     * @throws IOException
     */
    @Override
    public boolean addQuestion(Question q) throws IOException {//make paper and write paper details on paper detail text
        try {
            READWRITELOCK.writeLock().lock();
            File f2 = new File(q.getPath());
            boolean isTrue = paperDetail(q.getPaperId(), q.getPath(), q.getFileName());
            if (isTrue) {

            }
            if (f2.exists()) {
                File f3 = new File(q.getPath() + "/" + q.getFileName());
                fileWriter = new FileWriter(f3, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                String row = q.getqNumber() + ":" + q.getPaperId() + ":" + q.getMainQ() + ":" + q.getQ1() + ":" + q.getQ2() + ":" + q.getQ3() + ":" + q.getQ4() + ":" + q.getQa() + ":" + q.getQb() + ":" + q.getQc() + ":" + q.getQd() + ":" + q.getPath() + ":" + q.getFileName() + ":";
                String line = cipher(row);
                if (bufferedWriter.append(line) != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    return true;
                } else {
                    return false;
                }
            } else {
                boolean ff = f2.mkdirs();
                File f3 = new File(q.getPath() + "/" + q.getFileName());
                fileWriter = new FileWriter(f3, true);
                bufferedWriter = new BufferedWriter(fileWriter);

                String row = q.getqNumber() + ":" + q.getPaperId() + ":" + q.getMainQ() + ":" + q.getQ1() + ":" + q.getQ2() + ":" + q.getQ3() + ":" + q.getQ4() + ":" + q.getQa() + ":" + q.getQb() + ":" + q.getQc() + ":" + q.getQd() + ":" + q.getPath() + ":" + q.getFileName() + ":";
                String line = cipher(row);
                if (bufferedWriter.append(line) != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    return true;
                } else {
                    return false;
                }
            }
        } finally {
            READWRITELOCK.writeLock().unlock();
        }

    }

    /**
     *
     * @param path
     * @param qNumber
     * @return
     * @throws IOException
     */
    @Override
    public boolean deleteQuestion(String path, String qNumber) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();
            String[] QuestionList = null;
            File f3 = new File(path);
            System.out.println("delte Q path: " + path);
            if (f3.exists()) {
                FileReader fileReader = new FileReader(f3);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    QuestionList = line.split(":");
                }
            }
            System.out.println("QuestionList size: " + QuestionList.length);
            String[] newQuestionList = new String[QuestionList.length - 13];
            int x = 0;
            for (int i = 0; i < QuestionList.length; i++) {
                if (i % 13 == 0) {
                    if (QuestionList[i].equals(qNumber)) {
                        System.out.println("Q: " + QuestionList[i]);
                        i += 12;
                    } else {
                        int c = i;
                        for (int j = i; j <= c + 12; j++) {
                            newQuestionList[x] = QuestionList[j];
                            ++x;
                        }

                    }
                }
            }
            FileWriter writer = new FileWriter(f3, false);
            for (int i = 0; i < newQuestionList.length; i++) {
                writer.write(cipher(newQuestionList[i] + ":"));
                writer.flush();
            }

            FileReader reader = new FileReader(f3);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            try {
                newQuestionList = line.split(":");
            } catch (NullPointerException ex) {
            }
            if (QuestionList.length != newQuestionList.length) {
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

    /**
     *
     * @param q
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @Override
    public boolean updateQuestion(Question q) throws ClassNotFoundException, IOException {
        try {
            READWRITELOCK.writeLock().lock();
            String[] questionList = null;
            //first : read all data of file
            File f3 = new File(q.getPath() + "/" + q.getFileName());
            if (f3.exists()) {
                FileReader reader = new FileReader(f3);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    questionList = line.split(":");
                }
            }

            //update 
            int updated = 0;
            for (int i = 0; i < questionList.length; i++) {
                if (i % 13 == 0) {
                    if (questionList[i].equals(q.getqNumber())) {
                        updated = i;
                        questionList[i] = q.getqNumber();
                        questionList[i + 1] = q.getPaperId();
                        questionList[i + 2] = q.getMainQ();
                        questionList[i + 3] = q.getQ1();
                        questionList[i + 4] = q.getQ2();
                        questionList[i + 5] = q.getQ4();
                        questionList[i + 6] = q.getQ4();
                        questionList[i + 7] = q.getQa();
                        questionList[i + 8] = q.getQb();
                        questionList[i + 9] = q.getQc();
                        questionList[i + 10] = q.getQd();
                        questionList[i + 11] = q.getPath();
                        questionList[i + 12] = q.getFileName();

                        i += 12;
                    }
                }
            }
            //write update data
            FileWriter fileWriter = new FileWriter(f3, false);
            for (int i = 0; i < questionList.length; i++) {
                fileWriter.write(cipher(questionList[i] + ":"));
                fileWriter.flush();
            }
            //read all data again and check wheather update or not
            FileReader reader = new FileReader(f3);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            System.out.println("Line: " + line);
            String[] newQuestionList = line.split(":");
            if (questionList.length == newQuestionList.length) {//check array list size eual or not
                if (newQuestionList[updated].equals(q.getqNumber())) {
                    System.out.println("1");
                    if (newQuestionList[updated + 1].equals(q.getPaperId())) {
                        System.out.println("2");
                        if (newQuestionList[updated + 2].equals(q.getMainQ())) {
                            System.out.println("3");
                            if (newQuestionList[updated + 3].equals(q.getQ1())) {
                                System.out.println("4");
                                if (newQuestionList[updated + 4].equals(q.getQ2())) {
                                    System.out.println("5");
                                    System.out.println(updated + 5 + " _ " + q.getQ3());
                                    if (newQuestionList[updated + 5].equals(q.getQ3())) {
                                        System.out.println("6");
                                        if (newQuestionList[updated + 6].equals(q.getQ4())) {
                                            System.out.println("7");
                                            if (newQuestionList[updated + 7].equals(q.getQa())) {
                                                System.out.println("8");
                                                if (newQuestionList[updated + 8].equals(q.getQb())) {
                                                    System.out.println("9");
                                                    if (newQuestionList[updated + 9].equals(q.getQc())) {
                                                        System.out.println("10");
                                                        if (newQuestionList[updated + 10].equals(q.getQd())) {
                                                            System.out.println("11");
                                                            if (newQuestionList[updated + 11].equals(q.getPath())) {
                                                                System.out.println("12");
                                                                if (newQuestionList[updated + 12].equals(q.getFileName())) {
                                                                    System.out.println("13");

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
                                                    } else {
                                                        return false;
                                                    }
                                                } else {
                                                    return false;
                                                }
                                            } else {
                                                return false;
                                            }
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
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
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public ArrayList<Question> getAllQuestion(String path) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();

            Question question = null;
            File f1 = new File(path);
            FileReader reader = new FileReader(f1);
            ArrayList<Question> questionList = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            if (line != null) {
                String[] split = line.split(":");
                for (int i = 0; i < split.length; i++) {
                    if (i % 13 == 0) {
                        question = new Question(split[i], split[i + 1], split[i + 2], split[i + 3], split[i + 4], split[i + 5], split[i + 6], split[i + 7], split[i + 8], split[i + 9], split[i + 10], split[i + 11], split[i + 12]);
                        questionList.add(question);
                    }
                }
            }
            return questionList;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param paperId
     * @param path
     * @param fileName
     * @return
     * @throws IOException
     */
    @Override
    public boolean publishPaper(String paperId, String path, String fileName) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();
            File f1 = new File("./Database/Publish/publish.txt");
            fileWriter = new FileWriter(f1, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            String row = paperId + ":" + path + ":" + fileName + ":";
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
     * @param paperId
     * @param path
     * @param fileName
     * @return
     * @throws IOException
     */
    @Override
    public boolean unPublishPaper(String paperId, String path, String fileName) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();

            File f1 = new File("./Database/Publish/publish.txt");
            String[] publishList = null;
            if (f1.exists()) {
                FileReader fileReader = new FileReader(f1);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    publishList = line.split(":");
                }
            }
            String[] newpublishList = new String[publishList.length];
            for (int i = 0, x = 0; i < publishList.length; i++) {
                if (publishList[i].equals(paperId)) {
                    i += 2;//miss 3 item//
                } else {
                    newpublishList[x] = publishList[i];
                    x++;

                }
            }
            FileWriter writer = new FileWriter(f1, false);

            for (int i = 0; i < newpublishList.length - 3; i++) {
                writer.write(cipher(newpublishList[i] + ":"));
                writer.flush();
            }

            FileReader reader = new FileReader(f1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            if (line == null) {
                return true;
            }
            newpublishList = line.split(":");
            if (publishList.length != newpublishList.length) {
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
     * @param paperId
     * @param path
     * @param fileName
     * @return
     * @throws IOException
     */
    public boolean paperDetail(String paperId, String path, String fileName) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();
            File f1 = new File("./Database/PaperDetail/PaperDetail.txt");

            FileReader reader = new FileReader(f1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            if (line != null) {
                String[] paperDetailList = line.split(":");

                for (int i = 0; i < paperDetailList.length; i++) {
                    if (paperDetailList[i].equals(paperId)) {
                        return false;
                    }
                }
            }

            fileWriter = new FileWriter(f1, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            String row = paperId + ":" + path + ":" + fileName + ":";
            String line1 = cipher(row);
            if (bufferedWriter.append(line1) != null) {
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
     * @param paperId
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public boolean checkPublshORunPublished(String paperId) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();

            File f1 = new File("./Database/Publish/publish.txt");
            String[] p;
            FileReader reader = new FileReader(f1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            if (line != null) {
                p = line.split(":");

                for (int i = 0; i < p.length; i++) {
                    if (p[i].equals(paperId)) {
                        return true;
                    }

                }

                return false;
            }
            return false;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public ArrayList<String> getPapersName(String path) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            File f1 = new File("./Database/PaperDetail/PaperDetail.txt");

            FileReader reader = new FileReader(f1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            ArrayList<String> nameList = new ArrayList<>();

            if (line != null) {
                String[] pathList = line.split(":");

                for (int i = 0; i < pathList.length - 1; i++) {
                    if (pathList[i + 1].equals(path)) {

                        nameList.add(pathList[i + 2]);

                    }
                }
                return nameList;

            }
            return nameList;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @return @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public String getNewPaperId() throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.writeLock().lock();
            File f1 = new File("./Database/Papers/paperId.txt");

            FileReader reader = new FileReader(f1);
            LinkedList<String> idList = new LinkedList<>();
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            System.out.println("Read line Question Dao paperId: " + readLine);
            String line = decipher(readLine);
            System.out.println("Question Dao paperId: " + line);
            if (line != null) {
                String[] split = line.split(":");
                for (int i = 0; i < split.length; i++) {
                    idList.add(split[i]);
                }
            }

            String[] s = idList.getLast().split("-");
            int o = Integer.parseInt(s[1]) + 1;
            String i = s[0] + "-" + Integer.toString(o);
            boolean isTrue = addPaperId(i);
            if (isTrue) {
                return "" + i;
            } else {
                return "";
            }
        } finally {
            READWRITELOCK.writeLock().unlock();
        }

    }

    /**
     *
     * @param paperId
     * @return
     * @throws IOException
     */
    public boolean addPaperId(String paperId) throws IOException {
        File f1 = new File("./Database/Papers/paperId.txt");
        fileWriter = new FileWriter(f1, true);
        bufferedWriter = new BufferedWriter(fileWriter);
        String row = paperId + ":";
        String line = cipher(row);
        if (bufferedWriter.append(line) != null) {
            bufferedWriter.flush();
            bufferedWriter.close();
            return true;
        } else {
            return false;
        }

    }

    /**
     *
     * @param path
     * @param fileName
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public String getNumberOfQuestion(String path, String fileName) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            File f3 = new File(path + "/" + fileName);
            Question q = null;
            if (f3.exists()) {
                FileReader reader = new FileReader(f3);
                ArrayList<Question> questionList = new ArrayList<>();
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] split = line.split(":");
                    for (int i = 0; i < split.length; i++) {
                        if (i % 13 == 0) {
                            q = new Question(split[i], split[i + 1], split[i + 2], split[i + 3], split[i + 4], split[i + 5], split[i + 6], split[i + 7], split[i + 8], split[i + 9], split[i + 10], split[i + 11], split[i + 12]);
                            questionList.add(q);
                        }
                    }
                }
                System.out.println(questionList.size());
                return "" + questionList.size();

            } else {
                return "" + 0;
            }
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param qNumber
     * @param path
     * @param fileName
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public boolean searchQNumberIsAvailable(String qNumber, String path, String fileName) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            boolean ans = false;
            File f3 = new File(path + "/" + fileName);
            if (f3.exists()) {
                FileReader reader = new FileReader(f3);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] qNumberList = line.split(":");

                    for (int i = 0; i < qNumberList.length; i++) {
                        if (i % 13 == 0) {
                            if (qNumberList[i].equals(qNumber)) {
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

    ////////////////////////view Publish Papers////////////////////////////////////////////////////////////////// 
    /**
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public ArrayList<String> getPublishPapers(String path) throws FileNotFoundException, IOException {
        System.out.println("path: " + path);
        try {
            READWRITELOCK.readLock().lock();
            ArrayList<String> list = new ArrayList<>();

            File f1 = new File("./Database/Publish/publish.txt");
            FileReader reader1 = new FileReader(f1);
            BufferedReader bufferedReader = new BufferedReader(reader1);
            String line = null;
            String readLine = bufferedReader.readLine();
            if (readLine == null) {

            } else {
                line = decipher(readLine);
            }
            System.out.println("");
            if (line != null) {
                String[] split = line.split(":");
                for (int i = 0; i < split.length; i++) {
                    if (i % 3 == 0) {

                        if (split[i + 1].equals(path)) {
                            list.add(split[i] + ":" + split[i + 2]);
                            System.out.println(split[i] + ":" + split[i + 2]);
                        }

                    }
                }
            }

            return list;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

//Check Paper Name is Exists
    /**
     *
     * @param fileName
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public boolean isExistsFileName(String fileName) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            boolean ans = false;
            File f1 = new File("./Database/PaperDetail/PaperDetail.txt");
            if (f1.exists()) {
                FileReader reader = new FileReader(f1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = null;
                if (readLine == null) {
                    return false;
                } else {
                    line = decipher(readLine);
                }

                if (line != null) {
                    String[] qNameList = line.split(":");
                    for (int i = 0; i < qNameList.length; i++) {
                        if (i % 3 == 0) {
//                        System.out.println("work 111111");
                            if (qNameList[i + 2].equals(fileName + ".txt")) {
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

    /**
     *
     * @param path
     * @param fileName
     * @param qNumber
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public String getAnswers(String path, String fileName, int qNumber) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            String ans = null;
            File f1 = new File(path + "/" + fileName);
            System.out.println("path: " + f1.getPath());
            System.out.println("path is Exist :" + f1.exists());
            FileReader reader = new FileReader(f1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            if (line != null) {
                String[] split = line.split(":");
                for (int i = 0; i < split.length; i++) {
                    if (i % 13 == 0) {

                        if (split[i].equals(Integer.toString(qNumber))) {

                            ans = split[i + 7] + ":" + split[i + 8] + ":" + split[i + 9] + ":" + split[i + 10];

                        }
                    }
                }

            }

            return ans;
        } finally {
            READWRITELOCK.readLock().unlock();
        }

    }

    /**
     *
     * @param paperId
     * @return
     * @throws IOException
     */
    @Override
    public boolean deletePaperDetail(String paperId) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();
            String[] paperList = null;
            File f1 = new File("./Database/PaperDetail/PaperDetail.txt");
            if (f1.exists()) {
                FileReader fileReader = new FileReader(f1);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    paperList = line.split(":");
                }
            }
            String[] newPaperList = new String[paperList.length - 3];
            for (int i = 0, x = 0; i < paperList.length; i++) {
                if (paperList[i].equals(paperId)) {
                    i += 2;
                } else {
                    try {
                        newPaperList[x] = paperList[i];
                    } catch (ArrayIndexOutOfBoundsException ex) {
                    }
                    x++;
                }
            }
            FileWriter writer = new FileWriter(f1, false);
            for (int i = 0; i < newPaperList.length; i++) {
                writer.write(cipher(newPaperList[i] + ":"));
                writer.flush();
            }

            FileReader reader = new FileReader(f1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            try {
                newPaperList = line.split(":");
            } catch (NullPointerException ex) {
            }
            if (paperList.length != newPaperList.length) {
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
     * @param paperId
     * @return
     * @throws IOException
     */
    @Override
    public boolean deletepublishUnpublish(String paperId) throws IOException {
        try {
            boolean ans = false;
            READWRITELOCK.writeLock().lock();
            String[] paperList = null;
            File f1 = new File("./Database/Publish/publish.txt");
            if (f1.exists()) {
                FileReader fileReader = new FileReader(f1);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    paperList = line.split(":");
                }
            }
            for (String s : paperList) {
                if (s.equals(paperId)) {
                    String[] newPaperList = new String[paperList.length - 3];
                    for (int i = 0, x = 0; i < paperList.length; i++) {

                        if (paperList[i].equals(paperId)) {

                            i += 2;
                        } else {
                            newPaperList[x] = paperList[i];
                            x++;
                        }
                    }
                    FileWriter writer = new FileWriter(f1, false);
                    for (int i = 0; i < newPaperList.length; i++) {
                        writer.write(cipher(newPaperList[i] + ":"));
                        writer.flush();
                    }

                    FileReader reader = new FileReader(f1);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String readLine = bufferedReader.readLine();
                    String line = decipher(readLine);
                    try {
                        newPaperList = line.split(":");
                    } catch (NullPointerException ex) {
                    }
                    if (paperList.length != newPaperList.length) {
                        ans = true;
                    } else {
                        ans = false;
                    }
                } else {
                    ans = true;
                    return true;
                }
            }

            return ans;
        } finally {
            READWRITELOCK.writeLock().unlock();
        }
    }

    /**
     *
     * @param path
     * @return
     */
    @Override
    public boolean deletePaperFile(String path) {
        try {
            //READWRITELOCK.().lock();
            System.out.println("paper Delete path: " + path);
            File f1 = new File(path);
            f1.delete();
            System.out.println("paper delete Or Not :" + f1.exists());
           
           
          
            System.out.println("paper delete Or Not :" + f1.exists());
             return f1.exists();
        } finally {
//            READWRITELOCK.writeLock().unlock();
        }
    }

    /**
     *
     * @param path
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public void ResetQuestionNumbers(String path) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.writeLock().lock();
            Exam exam = null;
            String[] questionList = null;
            File f3 = new File(path);
            System.out.println("Reset Q path: " + path);
            if (f3.exists()) {
                FileReader reader = new FileReader(f3);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    questionList = line.split(":");
                }
            }

            //update 
            int updated = 0;
            int x = 1;
            for (int i = 0; i < questionList.length; i++) {
                if (i % 13 == 0) {
                    questionList[i] = Integer.toString(x);
                    ++x;

                }

            }
            //write update data
            FileWriter fileWriter = new FileWriter(f3, false);
            for (int i = 0; i < questionList.length; i++) {
                fileWriter.write(cipher(questionList[i] + ":"));
                fileWriter.flush();
            }

        } finally {
            READWRITELOCK.writeLock().unlock();
        }
    }

}
