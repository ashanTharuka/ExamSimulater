/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controller;

import edu.ijse.gdse37.examsuccess.model.Question;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface QuestionController extends Remote {

    /**
     *
     * @param question
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean addQuestion(Question question) throws RemoteException, IOException;

    /**
     *
     * @param type
     * @param key
     * @param path
     * @param fileName
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public Question SearchQuestion(String type,String key,String path,String fileName) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param question
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public boolean updateQuestion(Question question) throws ClassNotFoundException, IOException,RemoteException;

    /**
     *
     * @param paperId
     * @param path
     * @param fileName
     * @return
     * @throws IOException
     * @throws RemoteException
     */
    public boolean publishPaper(String paperId,String path,String fileName) throws IOException,RemoteException;

    /**
     *
     * @param paperId
     * @param path
     * @param fileName
     * @return
     * @throws IOException
     * @throws RemoteException
     */
    public boolean unPublishPaper(String paperId, String path, String fileName) throws IOException,RemoteException;

    /**
     *
     * @param paperId
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public boolean checkPublshORunPublished(String paperId) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public ArrayList<String> getPapersName(String path) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public String getNewPaperId() throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param path
     * @param fileName
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public String getNumberOfQuestion(String path,String fileName) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param qNumber
     * @param path
     * @param fileName
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public boolean searchQNumberIsAvailable(String qNumber,String path,String fileName) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public ArrayList<String> getPublishPapers(String path) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public ArrayList<Question> getAllQuestion(String path) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param fileName
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public boolean isExistsFileName(String fileName) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param path
     * @param fileName
     * @param qNumber
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public String getAnswers(String path, String fileName, int qNumber) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param paperId
     * @return
     * @throws IOException
     * @throws RemoteException
     */
    public boolean deletePaperDetail(String paperId) throws IOException,RemoteException;

    /**
     *
     * @param paperId
     * @return
     * @throws IOException
     * @throws RemoteException
     */
    public boolean deletepublishUnpublish(String paperId) throws IOException,RemoteException;

    /**
     *
     * @param path
     * @return
     * @throws RemoteException
     */
    public boolean deletePaperFile(String path)throws RemoteException;

    /**
     *
     * @param path
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     */
    public void ResetQuestionNumbers(String path) throws FileNotFoundException, IOException,RemoteException;

    /**
     *
     * @param path
     * @param qNumber
     * @return
     * @throws IOException
     * @throws RemoteException
     */
    public boolean deleteQuestion(String path, String qNumber) throws IOException,RemoteException;  

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public boolean reservePaper(String id)throws RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public boolean releasePaper(String id)throws RemoteException;
}
