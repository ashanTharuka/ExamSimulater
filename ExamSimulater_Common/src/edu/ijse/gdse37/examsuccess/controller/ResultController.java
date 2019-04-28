/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controller;

import edu.ijse.gdse37.examsuccess.model.Result;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface ResultController extends Remote {

    /**
     *
     * @param result
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean addResult(Result result) throws RemoteException, IOException;

    /**
     *
     * @param resultPath
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public ArrayList<Result> SearchAllStudentResult(String resultPath) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @param resultPath
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public Result SearchStudentResult(String id, String resultPath) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @param resultPath
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public boolean IsDoExam(String id, String resultPath) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public ArrayList<Result> getStudentAllResult(String id) throws FileNotFoundException, IOException, RemoteException;
}
