/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controllerimpl;

import edu.ijse.gdse37.examsuccess.controller.ExamFactory;
import edu.ijse.gdse37.examsuccess.controller.AdminController;
import edu.ijse.gdse37.examsuccess.controller.BatchController;
import edu.ijse.gdse37.examsuccess.controller.SemesterController;
import edu.ijse.gdse37.examsuccess.controller.ExamController;
import edu.ijse.gdse37.examsuccess.controller.LoginController;
import edu.ijse.gdse37.examsuccess.controller.PracticeExamController;
import edu.ijse.gdse37.examsuccess.controller.QuestionController;
import edu.ijse.gdse37.examsuccess.controller.ResultController;
import edu.ijse.gdse37.examsuccess.controller.StudentController;
import edu.ijse.gdse37.examsuccess.controller.SubjectController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Ashan Tharuka
 */
public class ExamFactoryImpl extends UnicastRemoteObject implements ExamFactory {

    /**
     *
     * @throws RemoteException
     */
    public ExamFactoryImpl() throws RemoteException {
    }

    @Override
    public AdminController getUserController() throws RemoteException {
        return new AdminControllerImpl();
    }

    @Override
    public StudentController getStudentController() throws RemoteException {
        return new StudentControllerImpl();
    }

    @Override
    public BatchController getBatchController() throws RemoteException {
        return new BatchControllerImpl();
    }

    @Override
    public SubjectController getSubjectController() throws RemoteException {
        return new SubjectObserverbleImpl();
    }

    @Override
    public SemesterController getCemesterController() throws RemoteException {
        return new CemesterControllerImpl();
    }

    @Override
    public QuestionController getQuestionController() throws RemoteException {
        return new QuestionControllerImpl();
    }

    @Override
    public ExamController getExamController() throws RemoteException {
        return new ExamControllerImpl();
    }

    @Override
    public LoginController getLoginController() throws RemoteException {
        return new LoginControllerImpl();

    }

    @Override
    public PracticeExamController getPracticeExamController() throws RemoteException {
        return new PracticeExamControllerImpl();
    }

    @Override
    public ResultController getResultController() throws RemoteException {
        return new ResultControllerImpl();
    }
}
