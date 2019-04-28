/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.daosuper;

import edu.ijse.gdse37.examsuccess.model.Result;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface SuperDaoResult {

    public boolean addResult(Result result) throws RemoteException, IOException;

    public ArrayList<Result> SearchAllStudentResult(String resultPath) throws FileNotFoundException, IOException, RemoteException;

    public Result SearchStudentResult(String id, String resultPath) throws FileNotFoundException, IOException, RemoteException;

    public boolean IsDoExam(String id, String resultPath) throws FileNotFoundException, IOException, RemoteException;

     public ArrayList<Result> getStudentAllResult(String id) throws FileNotFoundException, IOException;
}
