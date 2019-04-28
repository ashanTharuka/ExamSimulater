/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controller;

import edu.ijse.gdse37.examsuccess.model.Student;
import edu.ijse.gdse37.examsuccess.observer.StudentObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface StudentController extends Remote {

    /**
     *
     * @param student
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean addStudent(Student student) throws RemoteException, IOException;

    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public ArrayList<Student> getAllStudent() throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param type
     * @param key
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public Student SearchStudent(String type, String key) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws IOException
     * @throws RemoteException
     */
    public boolean deleteStudent(String id) throws IOException, RemoteException;

    /**
     *
     * @param student
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public boolean updateStudent(Student student) throws ClassNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public boolean searchId(String id) throws RemoteException, FileNotFoundException, IOException;

    /**
     *
     * @param id
     * @param pass
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public boolean checkPassword(String id, String pass) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public String getName(String id) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public String getEmail(String id) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public String getPasword(String id) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param batch
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public ArrayList<Student> getAllEmailofBatch(String batch) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public String getParentEmail(String id) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param batch
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public ArrayList<Student> getAllStudentsOfBatch(String batch) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param studentId
     * @param paperId
     * @throws RemoteException
     */
    public void startPracticeExam(String studentId, String paperId)throws RemoteException;

    /**
     *
     * @param studentId
     * @throws RemoteException
     */
    public void endPracticeExam(String studentId)throws RemoteException;

    /**
     *
     * @param studentId
     * @param paperId
     * @throws RemoteException
     */
    public void startFinalExam(String studentId, String paperId)throws RemoteException;

    /**
     *
     * @param studentId
     * @throws RemoteException
     */
    public void endFinalExam(String studentId)throws RemoteException;

    /**
     *
     * @param paperId
     * @return
     * @throws RemoteException
     */
    public boolean IsAvailablePracticeExam(String paperId)throws  RemoteException;

    /**
     *
     * @param paperId
     * @return
     * @throws RemoteException
     */
    public boolean IsAvailableFinalExam(String paperId)throws RemoteException;

    /**
     *
     * @param batch
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public ArrayList<Student> getAllBatchStudents(String batch) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param studentObserver
     * @return
     * @throws RemoteException
     */
    public boolean addStudentObserver(StudentObserver studentObserver)throws RemoteException;

    /**
     *
     * @param studentObserver
     * @return
     * @throws RemoteException
     */
    public boolean removeStudentObserver(StudentObserver studentObserver)throws RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public boolean reserveStudent(String id) throws RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public boolean releaseStudent(String id)throws RemoteException;

}
