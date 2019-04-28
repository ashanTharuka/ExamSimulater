/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.dao;

import edu.ijse.gdse37.examsuccess.daosuper.SuperDaoStudent;
import edu.ijse.gdse37.examsuccess.other.Encrypt;
import edu.ijse.gdse37.examsuccess.model.Student;
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
public class StudentDaoFile extends Encrypt implements SuperDaoStudent {

    //File Path
    private final File F1 = new File("./Database/Student/student.txt");
    private final static ReentrantReadWriteLock READWRITELOCK = new ReentrantReadWriteLock();
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    /**
     *
     * @param student
     * @return
     * @throws IOException
     */
    @Override
    public boolean addStudent(Student student) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();
            fileWriter = new FileWriter(F1, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            String row = student.getId() + "~" + student.getName() + "~" + student.getBatch() + "~" + student.getEmail() + "~" + student.getPhoneNumber() + "~" + student.getPassword() + "~" + student.getParentEmail() + "~" + student.getImagePath() + "~";
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
    public boolean deleteStudent(String id) throws IOException {
        try {
            READWRITELOCK.writeLock().lock();
            String[] studentList = null;
            if (F1.exists()) {
                FileReader fileReader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    studentList = line.split("~");
                }
            }
            String[] newStudentList = new String[studentList.length - 8];// what we want to delete line substract from list//model has 8 item
            for (int i = 0, x = 0; i < studentList.length; i++) {
                if (studentList[i].equals(id)) {
                    i += 7;//miss 8 item//
                } else {
                    newStudentList[x] = studentList[i];//store other vlues in array for write
                    x++;
                }
            }
            FileWriter writer = new FileWriter(F1, false);
            for (int i = 0; i < newStudentList.length; i++) {
                writer.write(cipher(newStudentList[i] + "~"));
                writer.flush();
            }

            FileReader reader = new FileReader(F1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            try {
                newStudentList = line.split("~");
            } catch (NullPointerException ex) {
            }
            if (studentList.length != newStudentList.length) {
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
    public Student SearchStudent(String type, String key) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Student student = null;

            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] StudentList = line.split("~");

                    if ("id".equals(type)) {
                        for (int i = 0; i < StudentList.length; i++) {
                            if (StudentList[i].equals(key)) {
                                student = new Student(StudentList[i], StudentList[i + 1], StudentList[i + 2], StudentList[i + 3], StudentList[i + 4], StudentList[i + 5], StudentList[i + 6], StudentList[i + 7]);
                            }
                        }
                    }

                    if ("email".equals(type)) {
                        for (int i = 0; i < StudentList.length - 3; i++) {
                            if (StudentList[i + 3].equals(key)) {
                                student = new Student(StudentList[i], StudentList[i + 1], StudentList[i + 2], StudentList[i + 3], StudentList[i + 4], StudentList[i + 5], StudentList[i + 6], StudentList[i + 7]);
                            }
                        }
                    }
                    if ("phoneNumber".equals(type)) {
                        for (int i = 0; i < StudentList.length - 4; i++) {
                            if (StudentList[i + 4].equals(key)) {
                                student = new Student(StudentList[i], StudentList[i + 1], StudentList[i + 2], StudentList[i + 3], StudentList[i + 4], StudentList[i + 5], StudentList[i + 6], StudentList[i + 7]);
                            }
                        }
                    }
                }
            }

            return student;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param student
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @Override
    public boolean updateStudent(Student student) throws ClassNotFoundException, IOException {
        try {
            READWRITELOCK.writeLock().lock();
            String[] studentList = null;
            //first : read all data of file
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    studentList = line.split("~");
                }
            }

            //update 
            int updated = 0;
            for (int i = 0; i < studentList.length; i++) {
                if (studentList[i].equals(student.getId())) {
                    updated = i;
                    studentList[i] = student.getId();
                    studentList[i + 1] = student.getName();
                    studentList[i + 2] = student.getBatch();
                    studentList[i + 3] = student.getEmail();
                    studentList[i + 4] = student.getPhoneNumber();
                    studentList[i + 5] = student.getPassword();
                    studentList[i + 6] = student.getParentEmail();
                    studentList[i + 7] = student.getImagePath();
                    i += 7;
                }
            }
            //write update data
            FileWriter fileWriter = new FileWriter(F1, false);
            for (int i = 0; i < studentList.length; i++) {
                fileWriter.write(cipher(studentList[i] + "~"));
                fileWriter.flush();
            }
            //read all data again and check wheather update or not
            FileReader reader = new FileReader(F1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            String[] newStudentList = line.split("~");
            if (studentList.length == newStudentList.length) {//check array list size eual or not

                if (newStudentList[updated].equals(student.getId())) {
                    if (newStudentList[updated + 1].equals(student.getName())) {
                        if (newStudentList[updated + 2].equals(student.getBatch())) {
                            if (newStudentList[updated + 3].equals(student.getEmail())) {
                                if (newStudentList[updated + 4].equals(student.getPhoneNumber())) {
                                    if (newStudentList[updated + 5].equals(student.getPassword())) {
                                        if (newStudentList[updated + 6].equals(student.getParentEmail())) {
                                            if (newStudentList[updated + 7].equals(student.getImagePath())) {
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
    public ArrayList<Student> getAllStudent() throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Student student = null;
            FileReader reader = new FileReader(F1);
            ArrayList<Student> studentList = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(reader);
            String readLine = bufferedReader.readLine();
            String line = decipher(readLine);
            if (line != null) {
                String[] split = line.split("~");
                for (int i = 0; i < split.length; i++) {
                    if (i % 8 == 0) {
                        student = new Student(split[i], split[i + 1], split[i + 2], split[i + 3], split[i + 4], split[i + 5], split[i + 6], split[i + 7]);
                        studentList.add(student);
                    }
                }
            }
            return studentList;
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
                    String[] StudentList = line.split("~");

                    for (int i = 0; i < StudentList.length; i++) {
                        if (StudentList[i].equals(id)) {
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

    /**
     *
     * @param id
     * @param pass
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public boolean checkPassword(String id, String pass) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            boolean ans = false;
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] StudentList = line.split("~");

                    for (int i = 0; i < StudentList.length; i++) {
                        if (StudentList[i].equals(id)) {
                            if (StudentList[i + 5].equals(pass)) {
                                ans = true;
                            } else {
                                ans = false;
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
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public String getName(String id) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            String name = null;
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] StudentList = line.split("~");

                    for (int i = 0; i < StudentList.length; i++) {
                        if (StudentList[i].equals(id)) {
                            name = StudentList[i + 1];
                        }
                    }
                }

            }

            return name;
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
    public String getEmail(String id) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            String email = null;
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {

                    String[] StudentList = line.split("~");

                    for (int i = 0; i < StudentList.length; i++) {
                        if (StudentList[i].equals(id)) {
                            email = StudentList[i + 3];
                        }
                    }
                }

            }

            return email;
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
    public String getPasword(String id) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            String password = null;
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] StudentList = line.split("~");

                    for (int i = 0; i < StudentList.length; i++) {
                        if (StudentList[i].equals(id)) {
                            password = StudentList[i + 5];
                        }
                    }
                }

            }

            return password;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param batch
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public ArrayList<Student> getAllEmailofBatch(String batch) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Student stu = new Student();
            ArrayList<Student> list = new ArrayList<>();
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] StudentList = line.split("~");

                    for (int i = 0; i < StudentList.length - 2; i++) {
                        if (StudentList[i + 2].equals(batch)) {
                            stu.setEmail(StudentList[i + 3]);
                            System.out.println(StudentList[i + 3]);
                            list.add(stu);
                        }
                    }
                }

            }

            return list;
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
    public String getParentEmail(String id) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            String email = null;
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {

                    String[] StudentList = line.split("~");

                    for (int i = 0; i < StudentList.length; i++) {
                        if (StudentList[i].equals(id)) {
                            email = StudentList[i + 6];
                        }
                    }
                }

            }

            return email;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param batch
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public ArrayList<Student> getAllStudentsOfBatch(String batch) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Student stu = new Student();
            ArrayList<Student> list = new ArrayList<>();
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] StudentList = line.split("~");

                    for (int i = 0; i < StudentList.length - 2; i++) {
                        if (StudentList[i + 2].equals(batch)) {
                            System.out.println("Student ID : " + StudentList[i]);
                            stu.setId(StudentList[i]);
                            list.add(stu);
                        }
                    }
                }

            }

            return list;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param batch
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public ArrayList<Student> getAllBatchStudents(String batch) throws FileNotFoundException, IOException {
        try {
            READWRITELOCK.readLock().lock();
            Student stu = new Student();
            ArrayList<Student> list = new ArrayList<>();
            if (F1.exists()) {
                FileReader reader = new FileReader(F1);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String readLine = bufferedReader.readLine();
                String line = decipher(readLine);
                if (line != null) {
                    String[] StudentList = line.split("~");

                    for (int i = 0; i < StudentList.length - 2; i++) {
                        if (StudentList[i + 2].equals(batch)) {
                            stu = new Student(StudentList[i], StudentList[i + 1], StudentList[i + 2], StudentList[i + 3], StudentList[i + 4], StudentList[i + 5], StudentList[i + 6], StudentList[i + 7]);
                            list.add(stu);
                        }
                    }
                }

            }

            return list;
        } finally {
            READWRITELOCK.readLock().unlock();
        }
    }
}
