/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.dao;

import edu.ijse.gdse37.examsuccess.daosuper.SuperDaoExam;
import edu.ijse.gdse37.examsuccess.model.Exam;
import edu.ijse.gdse37.examsuccess.other.Encrypt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Ashan Tharuka
 */
public class ExamDaoFile extends Encrypt implements SuperDaoExam {

    //File Path
    File F1 = new File("./Database/ManageExam/Exam.txt");
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String readLine = null;
    private final static ReentrantReadWriteLock READWRITELOCK = new ReentrantReadWriteLock();

    /**
     *
     * @param exam
     * @return
     * @throws IOException
     */
    @Override
    public boolean addExam(Exam exam) throws IOException {//make paper and write paper details on paper detail text
        try {
            READWRITELOCK.writeLock().lock();
            fileWriter = new FileWriter(F1, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            String row = exam.getExamId() + ":" + exam.getPath() + ":" + exam.getFileName() + ":" + exam.getStartQ() + ":" + exam.getEndQ() + ":" + exam.getaMarks() + ":" + exam.getbMarks() + ":" + exam.getcMarks() + ":" + exam.getwMarks() + ":" + exam.getDate() + ":" + exam.getStartTime() + ":" + exam.getTimeLimit() + ":" + exam.getSendMail() + ":" + exam.getMarkForOneQuestion() + ":" + exam.getQuizCount() + ":" + exam.getPaperId() + ":";
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
     * @param examId
     * @return
     * @throws IOException
     */
    @Override
    public boolean deleteExam(String examId) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();
            String[] examList = null;
            if (F1.exists()) {
                FileReader fileReader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    examList = line.split(":");
                }
            }
            String[] newExamList = new String[examList.length - 16];// what we want to delete line substract from list//model has 16 item
            for (int i = 0, x = 0; i < examList.length; i++) {
                if (examList[i].equals(examId)) {
                    i += 15;//miss 16 item//
                } else {
                    newExamList[x] = examList[i];//store other vlues in array for write
                    x++;
                }
            }
            FileWriter writer = new FileWriter(F1, false);
            for (int i = 0; i < newExamList.length; i++) {
                writer.write(cipher(newExamList[i] + ":"));
                writer.flush();
            }
            try {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);

                newExamList = line.split(":");
            } catch (NullPointerException ex) {
            }
            if (examList.length != newExamList.length) {
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
     * @param examid
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public Exam SearchExam(String examid) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Exam exam = null;

            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] examList = line.split(":");

                    for (int i = 0; i < examList.length; i++) {
                        if (examList[i].equals(examid)) {
                            exam = new Exam(examList[i], examList[i + 1], examList[i + 2], examList[i + 3], examList[i + 4], examList[i + 5], examList[i + 6], examList[i + 7], examList[i + 8], examList[i + 9], examList[i + 10], examList[i + 11], examList[i + 12], examList[i + 13], examList[i + 14], examList[i + 15]);
                        }
                    }

                }
            }

            return exam;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param exam
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @Override
    public boolean updateExam(Exam exam) throws ClassNotFoundException, IOException {
        try {
            READWRITELOCK.writeLock().lock();

            String[] examList = null;
            //first : read all data of file

            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    examList = line.split(":");
                }
            }

            //update 
            int updated = 0;
            for (int i = 0; i < examList.length; i++) {
                if (examList[i].equals(exam.getExamId())) {
                    updated = i;
                    examList[i] = exam.getExamId();
                    examList[i + 1] = exam.getPath();
                    examList[i + 2] = exam.getFileName();
                    examList[i + 3] = exam.getStartQ();
                    examList[i + 4] = exam.getEndQ();
                    examList[i + 5] = exam.getaMarks();
                    examList[i + 6] = exam.getbMarks();
                    examList[i + 7] = exam.getcMarks();
                    examList[i + 8] = exam.getwMarks();
                    examList[i + 9] = exam.getDate();
                    examList[i + 10] = exam.getStartTime();
                    examList[i + 11] = exam.getTimeLimit();
                    examList[i + 12] = exam.getSendMail();
                    examList[i + 13] = exam.getMarkForOneQuestion();
                    examList[i + 14] = exam.getQuizCount();
                    examList[i + 15] = exam.getPaperId();
                    i += 15;
                }
            }
            //write update data
            FileWriter fileWriter = new FileWriter(F1, false);
            for (int i = 0; i < examList.length; i++) {
                fileWriter.write(cipher(examList[i] + ":"));
                fileWriter.flush();
            }
            //read all data again and check wheather update or not
            FileReader reader = new FileReader(F1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            String[] newExamList = line.split(":");

            if (examList.length == newExamList.length) {//check array list size eual or not

                if (newExamList[updated].equals(exam.getExamId())) {

                    if (newExamList[updated + 1].equals(exam.getPath())) {

                        if (newExamList[updated + 2].equals(exam.getFileName())) {

                            if (newExamList[updated + 3].equals(exam.getStartQ())) {

                                if (newExamList[updated + 4].equals(exam.getEndQ())) {

                                    if (newExamList[updated + 5].equals(exam.getaMarks())) {

                                        if (newExamList[updated + 6].equals(exam.getbMarks())) {

                                            if (newExamList[updated + 7].equals(exam.getcMarks())) {

                                                if (newExamList[updated + 8].equals(exam.getwMarks())) {

                                                    if (newExamList[updated + 9].equals(exam.getDate())) {

                                                        if (newExamList[updated + 10].equals(exam.getStartTime())) {

                                                            if (newExamList[updated + 11].equals(exam.getTimeLimit())) {

                                                                if (newExamList[updated + 12].equals(exam.getSendMail())) {

                                                                    if (newExamList[updated + 13].equals(exam.getMarkForOneQuestion())) {

                                                                        if (newExamList[updated + 14].equals(exam.getQuizCount())) {

                                                                            if (newExamList[updated + 15].equals(exam.getPaperId())) {

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
    public String getNewExamId() throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            File f1 = new File("./Database/ManageExam/ExamId.txt");

            FileReader reader = new FileReader(f1);
            LinkedList<String> idList = new LinkedList<>();
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            System.out.println("dechiper examid list: " + line);
            if (line != null) {
                String[] split = line.split(":");
                for (int i = 0; i < split.length; i++) {
                    idList.add(split[i]);
                }
            }

            String[] s = idList.getLast().split("-");
            System.out.println("Id Gen: " + s[0]);
            System.out.println("Id Gen: " + s[1]);
            int o = Integer.parseInt(s[1]) + 1;
            String i = s[0] + "-" + Integer.toString(o);

            return "" + i;
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
    public boolean writeExamId(String paperId) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();
            File f1 = new File("./Database/ManageExam/ExamId.txt");
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
    public ArrayList<Exam> getAllExam() throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Exam exam = null;
            FileReader reader = new FileReader(F1);
            ArrayList<Exam> examList = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = null;
            if (readLine == null) {

            } else {
                line = decipher(readLine);
            }
            if (line != null) {
                String[] split = line.split(":");
                for (int i = 0; i < split.length; i++) {
                    if (i % 16 == 0) {
                        exam = new Exam(split[i], split[i + 1], split[i + 2], split[i + 3], split[i + 4], split[i + 5], split[i + 6], split[i + 7], split[i + 8], split[i + 9], split[i + 10], split[i + 11], split[i + 12], split[i + 13], split[i + 14], split[i + 15]);
                        examList.add(exam);
                    }
                }
            }
            return examList;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param examId
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public boolean searchExamIdIsAvailable(String examId) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            boolean ans = false;
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] examList = line.split(":");

                    for (int i = 0; i < examList.length; i++) {
                        if (examList[i].equals(examId)) {
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
/////////////////////return upcoming exam///////////////////////////////

    /**
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    @Override
    public ArrayList<Exam> getUpcomingExam(String path) throws FileNotFoundException, IOException, ParseException {
        try {
            READWRITELOCK.readLock().lock();
            Exam exam = new Exam();
            ArrayList<Exam> examList = new ArrayList<>();
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = null;
                if (readLine == null) {

                } else {
                    line = decipher(readLine);
                }

                if (line != null) {
                    String[] split = line.split(":");

                    for (int i = 0; i < split.length; i++) {
                        if (i % 16 == 0) {
                            try {
                                exam = new Exam(split[i], split[i + 1], split[i + 2], split[i + 3], split[i + 4], split[i + 5], split[i + 6], split[i + 7], split[i + 8], split[i + 9], split[i + 10], split[i + 11], split[i + 12], split[i + 13], split[i + 14], split[i + 15]);
                            } catch (NullPointerException ex) {
                            }
                            if (split[i + 1].equals(path)) {
                                String ans = chekdate(split[i + 9]);
                                if (ans.equals("After")) {
                                    examList.add(exam);
                                } else if (ans.equals("Equals")) {
                                   // examList.add(exam);
                                    String answer = checkTime(split[i + 10]);

                                    if (answer.equals("After")) {
                                        examList.add(exam);
                                    } else if (answer.equals("Equals")) {
                                        examList.add(exam);
                                    } else {
                                    }
                                } else {

                                }
                            }
                        }
                    }

                }
            }
            return examList;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param examDate
     * @return
     * @throws ParseException
     */
    public String chekdate(String examDate) throws ParseException {
        try {
            READWRITELOCK.readLock().lock();
            String ans = "Passed";

            Date date = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            String currnutDate = sf.format(date);
            Date examD = sf.parse(examDate);
            Date userD = sf.parse(currnutDate);

            if (examD.after(userD)) {
                ans = "After";
            } else if (examD.equals(userD)) {
                ans = "Equals";
            } else {
                ans = "Passed";
            }

            return ans;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param examTime
     * @return
     * @throws ParseException
     */
    public String checkTime(String examTime) throws ParseException {

        String ans = "Passed";

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss a");
        Date d1 = new Date();
        String date1 = sdf.format(d1);
        Date start = sdf.parse(date1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        cal.add(Calendar.MINUTE, -30);
        Date end = cal.getTime();
        String curruntTime = sdf.format(end);
        Date examT = sdf.parse(examTime.replace("-", ":"));
        System.out.println("cu:" + curruntTime);
        System.out.println("examT: " + examTime.replace("-", ":"));
        Date userT = sdf.parse(curruntTime);

        if (examT.after(userT)) {
            ans = "After";
        } else if (examT.equals(userT)) {
            ans = "Equals";
        } else {
            ans = "Passed";
        }

        return ans;
    }

    /**
     *
     * @return
     */
    @Override
    public String getServerDate() {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String curruntDate = sf.format(date);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss a");
        String curruntTime = sdf.format(date);

        return curruntDate + "#" + curruntTime;
    }

    /**
     *
     * @param examId
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public Exam getPassRate(String examId) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Exam exam = new Exam();

            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] examList = line.split(":");

                    for (int i = 0; i < examList.length; i++) {
                        if (examList[i].equals(examId)) {
                            exam.setaMarks(examList[i + 5]);
                            exam.setbMarks(examList[i + 6]);
                            exam.setcMarks(examList[i + 7]);
                            exam.setwMarks(examList[i + 8]);
                            exam.setSendMail(examList[i + 12]);
                            exam.setMarkForOneQuestion(examList[13]);

                        }
                    }

                }
            }

            return exam;
        } finally {
            READWRITELOCK.readLock().unlock();
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
    public boolean IsPaperIdAvailable(String paperId) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            boolean ans = false;

            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] examList = line.split(":");

                    for (int i = 0; i < examList.length; i++) {
                        if (examList[i].equals(paperId)) {
                            return true;
                        } else {
                            ans = false;
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
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public ArrayList<Exam> getExams(String path) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Exam exam = null;
            FileReader reader = new FileReader(F1);
            ArrayList<Exam> examList = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = null;
            if (readLine == null) {

            } else {
                line = decipher(readLine);
            }
            if (line != null) {
                String[] split = line.split(":");
                for (int i = 0; i < split.length; i++) {
                    if (i % 16 == 0) {
                        if (split[i + 1].equals(path)) {
                            exam = new Exam(split[i], split[i + 1], split[i + 2], split[i + 3], split[i + 4], split[i + 5], split[i + 6], split[i + 7], split[i + 8], split[i + 9], split[i + 10], split[i + 11], split[i + 12], split[i + 13], split[i + 14], split[i + 15]);
                            examList.add(exam);
                        } else {
                        }

                    }
                }
            }
            return examList;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public ArrayList<Exam> geAlltExams() throws FileNotFoundException, IOException {
        System.out.println("getAllExams Work");
        try {
            READWRITELOCK.readLock().lock();
            Exam exam = null;
            FileReader reader = new FileReader(F1);
            ArrayList<Exam> examList = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = null;
            if (readLine == null) {

            } else {
                line = decipher(readLine);
            }
            if (line != null) {
                String[] split = line.split(":");
                for (int i = 0; i < split.length; i++) {
                    if (i % 16 == 0) {

                        exam = new Exam(split[i], split[i + 1], split[i + 2], split[i + 3], split[i + 4], split[i + 5], split[i + 6], split[i + 7], split[i + 8], split[i + 9], split[i + 10], split[i + 11], split[i + 12], split[i + 13], split[i + 14], split[i + 15]);
                        System.out.println("GetAllExam: " + split[i]);
                        examList.add(exam);

                    }
                }
            }
            return examList;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param date
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public boolean IsExamAvailable(String date, String id) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            boolean ans = false;

            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] examList = line.split(":");

                    for (int i = 0; i < examList.length - 9; i++) {
                        if (examList[i + 9].equals(date)) {
                            System.out.println("exam Date: " + examList[i + 9]);
                            System.out.println("Our Date: " + date);
                            if (examList[i].equals(id)) {
                                return false;
                            }

                            return true;
                        } else {
                            ans = false;
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
