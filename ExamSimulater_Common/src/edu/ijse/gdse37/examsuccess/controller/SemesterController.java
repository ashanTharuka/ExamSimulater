/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controller;

import edu.ijse.gdse37.examsuccess.model.Cemester;
import edu.ijse.gdse37.examsuccess.observer.SemesterObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface SemesterController extends Remote {

    /**
     *
     * @param cemester
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean addCemester(Cemester cemester) throws RemoteException, IOException;

    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public ArrayList<Cemester> getAllCemester() throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param type
     * @param key
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public Cemester SearchCemester(String type, String key) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws IOException
     * @throws RemoteException
     */
    public boolean deleteCemester(String id) throws IOException,RemoteException;

    /**
     *
     * @param cemester
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public boolean updateCemester(Cemester cemester) throws ClassNotFoundException, IOException,RemoteException;

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
     * @param semesterObserver
     * @return
     * @throws RemoteException
     */
    public boolean addSemesterObserver(SemesterObserver semesterObserver)throws RemoteException;

    /**
     *
     * @param semesterObserver
     * @return
     * @throws RemoteException
     */
    public boolean removeSemesterObserver(SemesterObserver semesterObserver)throws RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public boolean reserveSemester(String id)throws RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public boolean releaseSemester(String id)throws RemoteException;


}
