/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controller;

import edu.ijse.gdse37.examsuccess.model.Batch;
import edu.ijse.gdse37.examsuccess.observer.BatchObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface BatchController extends Remote {

    /**
     *
     * @param batch
     * @return
     * @throws RemoteException
     * @throws IOException
     * addBatch
     */
    public boolean addBatch(Batch batch) throws RemoteException, IOException;

    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     * getAllBatch
     */
    public ArrayList<Batch> getAllBatch() throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param type
     * @param key
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     * SearchBatch
     */
    public Batch SearchBatch(String type, String key) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws IOException
     * @throws RemoteException
     * deleteBatch
     */
    public boolean deleteBatch(String id) throws IOException, RemoteException;

    /**
     *
     * @param batch
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws RemoteException
     * updateBatch
     */
    public boolean updateBatch(Batch batch) throws ClassNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     * searchId
     */
    public boolean searchId(String id) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param batchObserver
     * @return
     * @throws RemoteException
     * addBatchObserver
     */
    public boolean addBatchObserver(BatchObserver batchObserver) throws RemoteException;

    /**
     *
     * @param batchObserver
     * @return
     * @throws RemoteException
     * removeObserver
     */
    public boolean removeObserver(BatchObserver batchObserver) throws RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     * reserveBatch
     */
    public boolean reserveBatch(String id) throws RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     * releaseBatch
     */
    public boolean releaseBatch(String id) throws RemoteException;
}
