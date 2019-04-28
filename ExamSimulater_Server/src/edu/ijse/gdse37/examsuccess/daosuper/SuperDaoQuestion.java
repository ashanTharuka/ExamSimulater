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
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface SuperDaoQuestion {
    public boolean addQuestion(Question question) throws RemoteException, IOException;
    public Question SearchQuestion(String type,String key,String path,String fileName) throws FileNotFoundException, IOException, RemoteException;
    public boolean updateQuestion(Question question) throws ClassNotFoundException, IOException,RemoteException;

    public boolean publishPaper(String paperId,String path,String fileName) throws IOException,RemoteException;
    public boolean unPublishPaper(String paperId, String path, String fileName) throws IOException,RemoteException;
    public boolean checkPublshORunPublished(String paperId) throws FileNotFoundException, IOException,RemoteException;
    public ArrayList<String> getPapersName(String path) throws FileNotFoundException, IOException,RemoteException;
    public String getNewPaperId() throws FileNotFoundException, IOException,RemoteException;
    public String getNumberOfQuestion(String path,String fileName) throws FileNotFoundException, IOException,RemoteException;

    public boolean searchQNumberIsAvailable(String qNumber,String path,String fileName) throws FileNotFoundException, IOException,RemoteException;
    public ArrayList<String> getPublishPapers(String path) throws FileNotFoundException, IOException,RemoteException;
    public ArrayList<Question> getAllQuestion(String path) throws FileNotFoundException, IOException,RemoteException;

    public boolean isExistsFileName(String fileName) throws FileNotFoundException, IOException,RemoteException;
    public String getAnswers(String path, String fileName, int qNumber) throws FileNotFoundException, IOException,RemoteException;
    public boolean deletePaperDetail(String paperId) throws IOException;
    public boolean deletepublishUnpublish(String paperId) throws IOException;
    public boolean deletePaperFile(String path);
    public void ResetQuestionNumbers(String path) throws FileNotFoundException, IOException;
    public boolean deleteQuestion(String path, String qNumber) throws IOException;
}
