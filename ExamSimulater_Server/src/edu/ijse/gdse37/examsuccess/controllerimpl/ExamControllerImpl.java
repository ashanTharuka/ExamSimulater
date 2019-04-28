/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controllerimpl;

import edu.ijse.gdse37.examsuccess.model.Exam;
import edu.ijse.gdse37.examsuccess.controller.ExamController;
import edu.ijse.gdse37.examsuccess.dao.ExamDaoFile;
import edu.ijse.gdse37.examsuccess.observer.FinaleExamScheduleObserver;
import edu.ijse.gdse37.examsuccess.observer.ManageExamObserver;
import edu.ijse.gdse37.examsuccess.observerble.FinaleExamScheduleObserverble;
import edu.ijse.gdse37.examsuccess.observerble.ManageExamObserverble;
import edu.ijse.gdse37.examsuccess.reservation.ManageExamReserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public class ExamControllerImpl extends UnicastRemoteObject implements ExamController {

    private final ExamDaoFile EXAM_DAO = new ExamDaoFile();
    private final FinaleExamScheduleObserverble FES_OBSERVERBLE = new FinaleExamScheduleObserverble();
    private final ManageExamObserverble MANAGEEXAM_OBSERVERBLE = new ManageExamObserverble();
    private final ManageExamReserver EXAM_RESERVER = new ManageExamReserver();

    /**
     *
     * @throws RemoteException
     */
    public ExamControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addExam(Exam exam) throws RemoteException, IOException {
        // return EXAM_DAO.addExam(exam);
        if (EXAM_RESERVER.reserveManageExam(exam.getExamId(), this)) {
            if (EXAM_DAO.addExam(exam)) {
                MANAGEEXAM_OBSERVERBLE.notifyManageExamObservers(exam.getExamId() + " is added");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteExam(String examId) throws IOException, RemoteException {
        //return EXAM_DAO.deleteExam(examId);
        if (EXAM_RESERVER.reserveManageExam(examId, this)) {
            if (EXAM_DAO.deleteExam(examId)) {
                MANAGEEXAM_OBSERVERBLE.notifyManageExamObservers(examId + " is deleted");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Exam SearchExam(String examid) throws FileNotFoundException, IOException, RemoteException {
        return EXAM_DAO.SearchExam(examid);
    }

    @Override
    public String getNewExamId() throws FileNotFoundException, IOException, RemoteException {
        return EXAM_DAO.getNewExamId();
    }

    @Override
    public ArrayList<Exam> getAllExam() throws FileNotFoundException, IOException, RemoteException {
        return EXAM_DAO.getAllExam();
    }

    @Override
    public boolean searchExamIdIsAvailable(String examId) throws FileNotFoundException, IOException, RemoteException {
        return EXAM_DAO.searchExamIdIsAvailable(examId);
    }

    @Override
    public boolean updateExam(Exam exam) throws ClassNotFoundException, IOException, RemoteException {
        //return EXAM_DAO.updateExam(exam);
        if (EXAM_RESERVER.reserveManageExam(exam.getExamId(), this)) {
            if (EXAM_DAO.updateExam(exam)) {
                MANAGEEXAM_OBSERVERBLE.notifyManageExamObservers(exam.getExamId() + " is Updated");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Exam> getUpcomingExam(String path) throws FileNotFoundException, IOException, ParseException, RemoteException {
        return EXAM_DAO.getUpcomingExam(path);
    }

    @Override
    public String getServerDate() throws RemoteException {
        return EXAM_DAO.getServerDate();
    }

    @Override
    public Exam getPassRate(String examId) throws FileNotFoundException, IOException, RemoteException {
        return EXAM_DAO.getPassRate(examId);
    }

    @Override
    public boolean writeExamId(String paperId) throws IOException, RemoteException {
        return EXAM_DAO.writeExamId(paperId);
    }

    @Override
    public boolean IsPaperIdAvailable(String paperId) throws FileNotFoundException, IOException, RemoteException {
        return EXAM_DAO.IsPaperIdAvailable(paperId);
    }

    @Override
    public ArrayList<Exam> getExams(String path) throws FileNotFoundException, IOException, RemoteException {
        return EXAM_DAO.getExams(path);
    }

    @Override
    public ArrayList<Exam> geAlltExams() throws FileNotFoundException, IOException, RemoteException {
        return EXAM_DAO.geAlltExams();
    }

    @Override
    public boolean addExamObserver(FinaleExamScheduleObserver finalExam) throws RemoteException {
        return FES_OBSERVERBLE.addExamObserver(finalExam);
    }

    @Override
    public boolean removeExamObserver(FinaleExamScheduleObserver finalExam) throws RemoteException {
        return FES_OBSERVERBLE.removeExamObserver(finalExam);
    }

    @Override
    public boolean addManageExamObserver(ManageExamObserver manageExamObserver) throws RemoteException {
        return MANAGEEXAM_OBSERVERBLE.addManageExamObserver(manageExamObserver);
    }

    @Override
    public boolean removeManageExamObserver(ManageExamObserver manageExamObserver) throws RemoteException {
        return MANAGEEXAM_OBSERVERBLE.removeManageExamObserver(manageExamObserver);
    }

    @Override
    public boolean reserveManageExam(String id) throws RemoteException {
        return EXAM_RESERVER.reserveManageExam(id, this);
    }

    @Override
    public boolean releaseManageExam(String id) throws RemoteException {
        return EXAM_RESERVER.releaseManageExam(id, this);
    }

    @Override
    public boolean IsExamAvailable(String date, String id) throws FileNotFoundException, IOException, RemoteException {
        return EXAM_DAO.IsExamAvailable(date, id);
    }
}
