/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controllerimpl;

import edu.ijse.gdse37.examsuccess.model.Question;
import edu.ijse.gdse37.examsuccess.controller.QuestionController;
import edu.ijse.gdse37.examsuccess.dao.QuestionDaoFile;
import edu.ijse.gdse37.examsuccess.reservation.PaperReserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public class QuestionControllerImpl extends UnicastRemoteObject implements QuestionController {

    private final QuestionDaoFile QUESTION_DAO = new QuestionDaoFile();
    private final PaperReserver PAPER_RESERVER = new PaperReserver();

    /**
     *
     * @throws RemoteException
     */
    public QuestionControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addQuestion(Question question) throws RemoteException, IOException {
        return QUESTION_DAO.addQuestion(question);
    }

    @Override
    public boolean updateQuestion(Question question) throws ClassNotFoundException, IOException, RemoteException {
        return QUESTION_DAO.updateQuestion(question);
    }

    @Override
    public Question SearchQuestion(String type, String key, String path, String fileName) throws FileNotFoundException, IOException, RemoteException {
        return QUESTION_DAO.SearchQuestion(type, key, path, fileName);
    }

    @Override
    public boolean publishPaper(String paperId, String path, String fileName) throws IOException, RemoteException {
        return QUESTION_DAO.publishPaper(paperId, path, fileName);
    }

    @Override
    public boolean unPublishPaper(String paperId, String path, String fileName) throws IOException, RemoteException {
        return QUESTION_DAO.unPublishPaper(paperId, path, fileName);
    }

    @Override
    public boolean checkPublshORunPublished(String paperId) throws FileNotFoundException, IOException, RemoteException {
        return QUESTION_DAO.checkPublshORunPublished(paperId);
    }

    @Override
    public ArrayList<String> getPapersName(String path) throws FileNotFoundException, IOException, RemoteException {
        return QUESTION_DAO.getPapersName(path);
    }

    @Override
    public String getNewPaperId() throws FileNotFoundException, IOException, RemoteException {
        return QUESTION_DAO.getNewPaperId();
    }

    @Override
    public String getNumberOfQuestion(String path, String fileName) throws FileNotFoundException, IOException, RemoteException {
        return QUESTION_DAO.getNumberOfQuestion(path, fileName);
    }

    @Override
    public boolean searchQNumberIsAvailable(String qNumber, String path, String fileName) throws FileNotFoundException, IOException, RemoteException {
        return QUESTION_DAO.searchQNumberIsAvailable(qNumber, path, fileName);
    }

    @Override
    public ArrayList<String> getPublishPapers(String path) throws FileNotFoundException, IOException, RemoteException {
        return QUESTION_DAO.getPublishPapers(path);
    }

    @Override
    public ArrayList<Question> getAllQuestion(String path) throws FileNotFoundException, IOException, RemoteException {
        return QUESTION_DAO.getAllQuestion(path);
    }

    @Override
    public boolean isExistsFileName(String fileName) throws FileNotFoundException, IOException, RemoteException {
        return QUESTION_DAO.isExistsFileName(fileName);
    }

    @Override
    public String getAnswers(String path, String fileName, int qNumber) throws FileNotFoundException, IOException, RemoteException {
        return QUESTION_DAO.getAnswers(path, fileName, qNumber);
    }

    @Override
    public boolean deletePaperDetail(String paperId) throws IOException, RemoteException {
        return QUESTION_DAO.deletePaperDetail(paperId);
    }

    @Override
    public boolean deletepublishUnpublish(String paperId) throws IOException, RemoteException {
        return QUESTION_DAO.deletepublishUnpublish(paperId);
    }

    @Override
    public boolean deletePaperFile(String path) throws RemoteException {
        return QUESTION_DAO.deletePaperFile(path);
    }

    @Override
    public void ResetQuestionNumbers(String path) throws FileNotFoundException, IOException, RemoteException {
        QUESTION_DAO.ResetQuestionNumbers(path);
    }

    @Override
    public boolean deleteQuestion(String path, String qNumber) throws IOException, RemoteException {
        return QUESTION_DAO.deleteQuestion(path, qNumber);
    }

    @Override
    public boolean reservePaper(String id) throws RemoteException {
        System.out.println("lock");
        return PAPER_RESERVER.reservePaper(id, this);
    }

    @Override
    public boolean releasePaper(String id) throws RemoteException {
        System.out.println("unlock");
        return PAPER_RESERVER.releasePaper(id, this);
    }

}
