/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.other;

import edu.ijse.gdse37.examsuccess.connecter.ServerConnecter;
import edu.ijse.gdse37.examsuccess.controller.AdminController;
import edu.ijse.gdse37.examsuccess.controller.BatchController;
import edu.ijse.gdse37.examsuccess.controller.ExamController;
import edu.ijse.gdse37.examsuccess.controller.QuestionController;
import edu.ijse.gdse37.examsuccess.controller.SemesterController;
import edu.ijse.gdse37.examsuccess.controller.StudentController;
import edu.ijse.gdse37.examsuccess.controller.SubjectController;
import edu.ijse.gdse37.examsuccess.view.observerimpl.AdminObserverImpl;
import edu.ijse.gdse37.examsuccess.view.observerimpl.BatchObserverImpl;
import edu.ijse.gdse37.examsuccess.view.observerimpl.FinalExamScheduleObserverImpl;
import edu.ijse.gdse37.examsuccess.view.observerimpl.ManageExamObserverImpl;
import edu.ijse.gdse37.examsuccess.view.observerimpl.SemesterObserverImpl;
import edu.ijse.gdse37.examsuccess.view.observerimpl.StudentObserverImpl;
import edu.ijse.gdse37.examsuccess.view.observerimpl.SubjectObserverImpl;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ashan Tharuka
 */
public class Relese {

    /**
     *
     */
    public Object observerImplOb;

    /**
     *
     */
    public String code;

    /**
     *
     */
    public String code2;

    /**
     *
     */
    public void release() {
        releseId();
        removeObserver();
    }

    /**
     *
     * @param code1
     */
    public void releseManual(String code1) {
        try {
            AdminController adminController = ServerConnecter.getServerConnecter().getAdminController();
            StudentController studentController = ServerConnecter.getServerConnecter().getStudentController();
            BatchController batchController = ServerConnecter.getServerConnecter().getBatchController();
            SemesterController semesterController = ServerConnecter.getServerConnecter().getCemesterController();
            SubjectController subjectController = ServerConnecter.getServerConnecter().getSubjectController();
            ExamController examController = ServerConnecter.getServerConnecter().getExamController();
            QuestionController questionController = ServerConnecter.getServerConnecter().getQuestionController();

            questionController.releasePaper(code1);
            adminController.releaseAdmin(code1);
            studentController.releaseStudent(code1);
            batchController.releaseBatch(code1);
            semesterController.releaseSemester(code1);
            subjectController.releaseSubject(code1);
            examController.releaseManageExam(code1);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Relese.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     */
    public void releseId() {
        try {
            AdminController adminController = ServerConnecter.getServerConnecter().getAdminController();
            StudentController studentController = ServerConnecter.getServerConnecter().getStudentController();
            BatchController batchController = ServerConnecter.getServerConnecter().getBatchController();
            SemesterController semesterController = ServerConnecter.getServerConnecter().getCemesterController();
            SubjectController subjectController = ServerConnecter.getServerConnecter().getSubjectController();
            ExamController examController = ServerConnecter.getServerConnecter().getExamController();
            QuestionController questionController = ServerConnecter.getServerConnecter().getQuestionController();

            adminController.releaseAdmin(code);
            studentController.releaseStudent(code);
            batchController.releaseBatch(code);
            semesterController.releaseSemester(code);
            subjectController.releaseSubject(code);
            examController.releaseManageExam(code);
            questionController.releasePaper(code);
            questionController.releasePaper(code2);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Relese.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     */
    public void removeObserver() {
        if (observerImplOb != null) {
            if (observerImplOb instanceof AdminObserverImpl) {

                try {
                    AdminController adminController = ServerConnecter.getServerConnecter().getAdminController();
                    boolean b = adminController.removeAdminObserver((AdminObserverImpl) observerImplOb);
                } catch (RemoteException | NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(Relese.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (observerImplOb instanceof BatchObserverImpl) {
                try {
                    BatchController batchController = ServerConnecter.getServerConnecter().getBatchController();
                    boolean b = batchController.removeObserver((BatchObserverImpl) observerImplOb);
                } catch (RemoteException | NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(Relese.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (observerImplOb instanceof FinalExamScheduleObserverImpl) {
                try {
                    ExamController examController = ServerConnecter.getServerConnecter().getExamController();
                    boolean b = examController.removeExamObserver((FinalExamScheduleObserverImpl) observerImplOb);
                } catch (RemoteException | NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(Relese.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (observerImplOb instanceof ManageExamObserverImpl) {
                try {
                    ExamController examController = ServerConnecter.getServerConnecter().getExamController();
                    boolean b = examController.removeManageExamObserver((ManageExamObserverImpl) observerImplOb);
                } catch (RemoteException | NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(Relese.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (observerImplOb instanceof SemesterObserverImpl) {
                try {
                    SemesterController semesterController = ServerConnecter.getServerConnecter().getCemesterController();
                    boolean b = semesterController.removeSemesterObserver((SemesterObserverImpl) observerImplOb);
                } catch (RemoteException | NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(Relese.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (observerImplOb instanceof StudentObserverImpl) {
                try {
                    StudentController studentController = ServerConnecter.getServerConnecter().getStudentController();
                    boolean b = studentController.removeStudentObserver((StudentObserverImpl) observerImplOb);
                } catch (RemoteException | NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(Relese.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (observerImplOb instanceof SubjectObserverImpl) {
                try {
                    SubjectController subjectController = ServerConnecter.getServerConnecter().getSubjectController();
                    boolean b = subjectController.removeSubjectObserver((SubjectObserverImpl) observerImplOb);
                } catch (RemoteException | NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(Relese.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
