/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controllerimpl;

import edu.ijse.gdse37.examsuccess.model.Question;
import edu.ijse.gdse37.examsuccess.controller.PracticeExamController;
import edu.ijse.gdse37.examsuccess.dao.PracticeExamDaoFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Ashan Tharuka
 */
public class PracticeExamControllerImpl extends UnicastRemoteObject implements PracticeExamController {

    private final PracticeExamDaoFile PRACTICEEXAM_DAO = new PracticeExamDaoFile();

    /**
     *
     * @throws RemoteException
     */
    public PracticeExamControllerImpl() throws RemoteException {
    }

    @Override
    public Question SearchQuestion(String type, String key, String path, String fileName) throws FileNotFoundException, IOException, RemoteException {
        return PRACTICEEXAM_DAO.SearchQuestion(type, key, path, fileName);
    }
}
