/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controllerimpl;

import edu.ijse.gdse37.examsuccess.model.Student;
import edu.ijse.gdse37.examsuccess.observerble.StudentObserverble;
import edu.ijse.gdse37.examsuccess.controller.StudentController;
import edu.ijse.gdse37.examsuccess.dao.StudentDaoFile;
import edu.ijse.gdse37.examsuccess.observer.StudentObserver;
import edu.ijse.gdse37.examsuccess.observerble.Student_Observerble;
import edu.ijse.gdse37.examsuccess.reservation.StudentReserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public class StudentControllerImpl extends UnicastRemoteObject implements StudentController {

    private final StudentDaoFile STUDENT_DAO = new StudentDaoFile();
    private final StudentObserverble STUDENT_OBSERVERBLE = new StudentObserverble();
    private final Student_Observerble STUDENTOBSERVERBLE = new Student_Observerble();
    private final StudentReserver STUDENT_RESERVER = new StudentReserver();

    /**
     *
     * @throws RemoteException
     */
    public StudentControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addStudent(Student student) throws RemoteException, IOException {
        // return STUDENT_DAO.addStudent(student);
        if (STUDENT_RESERVER.reserveStudent(student.getId(), this)) {
            if (STUDENT_DAO.addStudent(student)) {
                STUDENTOBSERVERBLE.notifyStudentObservers(student.getId() + " is added");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Student> getAllStudent() throws FileNotFoundException, IOException, RemoteException {
        return STUDENT_DAO.getAllStudent();
    }

    @Override
    public Student SearchStudent(String type, String key) throws FileNotFoundException, IOException, RemoteException {
        return STUDENT_DAO.SearchStudent(type, key);
    }

    @Override
    public boolean deleteStudent(String id) throws IOException, RemoteException {
        //return STUDENT_DAO.deleteStudent(id);
        if (STUDENT_RESERVER.reserveStudent(id, this)) {
            if (STUDENT_DAO.deleteStudent(id)) {
                STUDENTOBSERVERBLE.notifyStudentObservers(id + " is added");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean updateStudent(Student student) throws ClassNotFoundException, IOException, RemoteException {
        // return STUDENT_DAO.updateStudent(student);
        if (STUDENT_RESERVER.reserveStudent(student.getId(), this)) {
            if (STUDENT_DAO.updateStudent(student)) {
                STUDENTOBSERVERBLE.notifyStudentObservers(student.getId() + " is Updated");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean searchId(String id) throws RemoteException, FileNotFoundException, IOException {
        return STUDENT_DAO.searchId(id);
    }

    @Override
    public boolean checkPassword(String id, String pass) throws FileNotFoundException, IOException, RemoteException {
        return STUDENT_DAO.checkPassword(id, pass);
    }

    @Override
    public String getName(String id) throws FileNotFoundException, IOException, RemoteException {
        return STUDENT_DAO.getName(id);
    }

    @Override
    public String getEmail(String id) throws FileNotFoundException, IOException, RemoteException {
        return STUDENT_DAO.getEmail(id);
    }

    @Override
    public String getPasword(String id) throws FileNotFoundException, IOException, RemoteException {
        return STUDENT_DAO.getPasword(id);
    }

    @Override
    public ArrayList<Student> getAllEmailofBatch(String batch) throws FileNotFoundException, IOException, RemoteException {
        return STUDENT_DAO.getAllEmailofBatch(batch);
    }

    @Override
    public String getParentEmail(String id) throws FileNotFoundException, IOException, RemoteException {
        return STUDENT_DAO.getParentEmail(id);
    }

    @Override
    public ArrayList<Student> getAllStudentsOfBatch(String batch) throws FileNotFoundException, IOException, RemoteException {
        return STUDENT_DAO.getAllStudentsOfBatch(batch);
    }

    @Override
    public void startPracticeExam(String studentId, String paperId) throws RemoteException {
        STUDENT_OBSERVERBLE.startPracticeExam(studentId, paperId);
    }

    @Override
    public void endPracticeExam(String studentId) throws RemoteException {
        STUDENT_OBSERVERBLE.endPracticeExam(studentId);
    }

    @Override
    public void startFinalExam(String studentId, String paperId) throws RemoteException {
        STUDENT_OBSERVERBLE.startFinalExam(studentId, paperId);
    }

    @Override
    public void endFinalExam(String studentId) throws RemoteException {
        STUDENT_OBSERVERBLE.endFinalExam(studentId);
    }

    @Override
    public boolean IsAvailablePracticeExam(String paperId) throws RemoteException {
        return STUDENT_OBSERVERBLE.IsAvailablePracticeExam(paperId);
    }

    @Override
    public boolean IsAvailableFinalExam(String paperId) throws RemoteException {
        return STUDENT_OBSERVERBLE.IsAvailableFinalExam(paperId);
    }

    @Override
    public ArrayList<Student> getAllBatchStudents(String batch) throws FileNotFoundException, IOException, RemoteException {
        return STUDENT_DAO.getAllBatchStudents(batch);
    }

    @Override
    public boolean addStudentObserver(StudentObserver studentObserver) throws RemoteException {
        return STUDENTOBSERVERBLE.addStudentObserver(studentObserver);
    }

    @Override
    public boolean removeStudentObserver(StudentObserver studentObserver) throws RemoteException {
        return STUDENTOBSERVERBLE.removeStudentObserver(studentObserver);
    }

    @Override
    public boolean reserveStudent(String id) throws RemoteException {
        return STUDENT_RESERVER.reserveStudent(id, this);
    }

    @Override
    public boolean releaseStudent(String id) throws RemoteException {
        return STUDENT_RESERVER.releaseStudent(id, this);
    }

}
