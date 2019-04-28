/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Ashan Tharuka
 */
public interface ExamFactory extends Remote {

    /**
     *
     * @return
     * @throws RemoteException
     */
    public AdminController getUserController() throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public StudentController getStudentController() throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public BatchController getBatchController() throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public SubjectController getSubjectController() throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public SemesterController getCemesterController() throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public QuestionController getQuestionController() throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public ExamController getExamController() throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public LoginController getLoginController() throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public PracticeExamController getPracticeExamController()throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public ResultController getResultController()throws RemoteException;
}

