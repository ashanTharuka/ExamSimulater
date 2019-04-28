/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controller;

import edu.ijse.gdse37.examsuccess.model.Subject;
import edu.ijse.gdse37.examsuccess.observer.SubjectObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface SubjectController extends Remote {

    /**
     *
     * @param subject
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean addSubject(Subject subject) throws RemoteException, IOException;

    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public ArrayList<Subject> getAllSubject() throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param type
     * @param key
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public Subject SearchSubject(String type, String key) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws IOException
     * @throws RemoteException
     */
    public boolean deleteSubject(String id) throws IOException,RemoteException;

    /**
     *
     * @param subject
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public boolean updateSubject(Subject subject) throws ClassNotFoundException, IOException,RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public boolean searchId(String id) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param subjectObserver
     * @return
     * @throws RemoteException
     */
    public boolean addSubjectObserver(SubjectObserver subjectObserver)throws RemoteException;

    /**
     *
     * @param subjectObserver
     * @return
     * @throws RemoteException
     */
    public boolean removeSubjectObserver(SubjectObserver subjectObserver)throws RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public boolean releaseSubject(String id)throws RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public boolean reserveSubject(String id)throws RemoteException;


}
