/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.daosuper;

import edu.ijse.gdse37.examsuccess.model.Question;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 *
 * @author Ashan Tharuka
 */
public interface SuperDaoPracticeExam {
    public Question SearchQuestion(String type, String key, String path, String fileName) throws FileNotFoundException, IOException, RemoteException;
}