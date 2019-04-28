/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controller;

import edu.ijse.gdse37.examsuccess.model.Exam;
import edu.ijse.gdse37.examsuccess.model.Result;
import edu.ijse.gdse37.examsuccess.observer.FinaleExamScheduleObserver;
import edu.ijse.gdse37.examsuccess.observer.ManageExamObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface ExamController extends Remote {

    /**
     *
     * @param exam
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean addExam(Exam exam) throws RemoteException, IOException;

    /**
     *
     * @param examId
     * @return
     * @throws IOException
     * @throws RemoteException
     */
    public boolean deleteExam(String examId) throws IOException, RemoteException;

    /**
     *
     * @param examid
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public Exam SearchExam(String examid) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public String getNewExamId() throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public ArrayList<Exam> getAllExam() throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param examId
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public boolean searchExamIdIsAvailable(String examId) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param exam
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public boolean updateExam(Exam exam) throws ClassNotFoundException, IOException,RemoteException; 

    /**
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     * @throws RemoteException
     */
    public ArrayList<Exam> getUpcomingExam(String path) throws FileNotFoundException, IOException,ParseException,RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public String getServerDate() throws RemoteException;
    
    /**
     *
     * @param examId
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public Exam getPassRate(String examId) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param paperId
     * @return
     * @throws IOException
     * @throws RemoteException
     */
    public boolean writeExamId(String paperId) throws IOException,RemoteException;

    /**
     *
     * @param paperId
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public boolean IsPaperIdAvailable(String paperId) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public ArrayList<Exam> getExams(String path) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public ArrayList<Exam> geAlltExams() throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param finalExam
     * @return
     * @throws RemoteException
     */
    public boolean addExamObserver(FinaleExamScheduleObserver finalExam) throws RemoteException;

    /**
     *
     * @param finalExam
     * @return
     * @throws RemoteException
     */
    public boolean removeExamObserver(FinaleExamScheduleObserver finalExam) throws RemoteException;

    /**
     *
     * @param manageExamObserver
     * @return
     * @throws RemoteException
     */
    public boolean addManageExamObserver(ManageExamObserver manageExamObserver)throws RemoteException;

    /**
     *
     * @param manageExamObserver
     * @return
     * @throws RemoteException
     */
    public boolean removeManageExamObserver(ManageExamObserver manageExamObserver)throws RemoteException;

    /**
     *
     * @param date
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public boolean IsExamAvailable(String date,String id) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public boolean reserveManageExam(String id)throws RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public boolean releaseManageExam(String id)throws RemoteException;
   

}
