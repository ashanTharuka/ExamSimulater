/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controllerimpl;

import edu.ijse.gdse37.examsuccess.controller.ResultController;
import edu.ijse.gdse37.examsuccess.dao.ResultDaoFile;
import edu.ijse.gdse37.examsuccess.model.Result;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public class ResultControllerImpl extends UnicastRemoteObject implements ResultController {

    private final ResultDaoFile RESULT_DAO = new ResultDaoFile();

    /**
     *
     * @throws RemoteException
     */
    public ResultControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addResult(Result result) throws RemoteException, IOException {
        return RESULT_DAO.addResult(result);
    }

    @Override
    public Result SearchStudentResult(String id, String resultPath) throws FileNotFoundException, IOException, RemoteException {
        return RESULT_DAO.SearchStudentResult(id, resultPath);
    }

    @Override
    public ArrayList<Result> SearchAllStudentResult(String resultPath) throws FileNotFoundException, IOException, RemoteException {
        return RESULT_DAO.SearchAllStudentResult(resultPath);
    }

    @Override
    public boolean IsDoExam(String id, String resultPath) throws FileNotFoundException, IOException, RemoteException {
        return RESULT_DAO.IsDoExam(id, resultPath);
    }

    @Override
    public ArrayList<Result> getStudentAllResult(String id) throws FileNotFoundException, IOException, RemoteException {
        return RESULT_DAO.getStudentAllResult(id);
    }

}
