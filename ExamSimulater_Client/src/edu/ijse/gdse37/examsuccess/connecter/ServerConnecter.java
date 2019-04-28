/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.connecter;

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
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Ashan Tharuka
 */
public class ServerConnecter {

    private static ServerConnecter serverConnecter;
    private ExamFactory examFactory;
    private AdminController adminController;
    private StudentController studentController;
    private BatchController batchController;
    private SemesterController semesterController;
    private SubjectController subjectController;
    private QuestionController questionController;
    private ExamController examController;
    private LoginController loginController;
    private PracticeExamController practiceExamController;
    private ResultController resultController;

    private ServerConnecter() throws NotBoundException, MalformedURLException, RemoteException {
        examFactory = (ExamFactory) Naming.lookup("rmi://localhost:5050/Exam_Server");
    }
    
    

    /**
     *
     * @return
     * @throws NotBoundException
     * @throws MalformedURLException
     * @throws RemoteException
     */
    public static ServerConnecter getServerConnecter() throws NotBoundException, MalformedURLException, RemoteException {
        if (serverConnecter == null) {
            serverConnecter = new ServerConnecter();
        }
        return serverConnecter;
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    public AdminController getAdminController() throws RemoteException {
        if (adminController == null) {
            adminController = examFactory.getUserController();

        }
        return adminController;
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    public StudentController getStudentController() throws RemoteException {
        if (studentController == null) {
            studentController = examFactory.getStudentController();

        }
        return studentController;
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    public BatchController getBatchController() throws RemoteException {
        if (batchController == null) {
            batchController = examFactory.getBatchController();

        }
        return batchController;
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    public SubjectController getSubjectController() throws RemoteException {
        if (subjectController == null) {
            subjectController = examFactory.getSubjectController();

        }
        return subjectController;
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    public SemesterController getCemesterController() throws RemoteException {
        if (semesterController == null) {
            semesterController = examFactory.getCemesterController();

        }
        return semesterController;
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    public QuestionController getQuestionController() throws RemoteException {
        if (questionController == null) {
            questionController = examFactory.getQuestionController();

        }
        return questionController;
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    public ExamController getExamController() throws RemoteException {
        if (examController == null) {
            examController = examFactory.getExamController();

        }
        return examController;
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    public LoginController getLoginController() throws RemoteException {
        if (loginController == null) {
            loginController = examFactory.getLoginController();

        }
        return loginController;
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    public PracticeExamController getPracticeExamController() throws RemoteException {
        if (practiceExamController == null) {
            practiceExamController = examFactory.getPracticeExamController();

        }
        return practiceExamController;
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    public ResultController getResultController() throws RemoteException {
        if (resultController == null) {
            resultController = examFactory.getResultController();

        }
        return resultController;
    }
}
