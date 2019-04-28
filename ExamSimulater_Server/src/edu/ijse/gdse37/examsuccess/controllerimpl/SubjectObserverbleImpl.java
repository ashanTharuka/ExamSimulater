/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controllerimpl;

import edu.ijse.gdse37.examsuccess.model.Subject;
import edu.ijse.gdse37.examsuccess.controller.SubjectController;
import edu.ijse.gdse37.examsuccess.dao.SubjectDaoFile;
import edu.ijse.gdse37.examsuccess.observer.SubjectObserver;
import edu.ijse.gdse37.examsuccess.observerble.SubjectObserverble;
import edu.ijse.gdse37.examsuccess.reservation.SubjectReserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public class SubjectObserverbleImpl extends UnicastRemoteObject implements SubjectController {

    private final SubjectDaoFile SUBJECT_DAO = new SubjectDaoFile();
    private final SubjectObserverble SUBJECT_OBSERVERBLE = new SubjectObserverble();
    private final SubjectReserver SUBJECT_RESERVER = new SubjectReserver();

    /**
     *
     * @throws RemoteException
     */
    public SubjectObserverbleImpl() throws RemoteException {
    }

    @Override
    public boolean addSubject(Subject subject) throws RemoteException, IOException {
        // return SUBJECT_DAO.addSubject(subject);
        if (SUBJECT_RESERVER.reserveSubject(subject.getId(), this)) {
            if (SUBJECT_DAO.addSubject(subject)) {
                SUBJECT_OBSERVERBLE.notifySubjectObservers(subject.getId() + " is added");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Subject> getAllSubject() throws FileNotFoundException, IOException, RemoteException {
        return SUBJECT_DAO.getAllSubject();
    }

    @Override
    public Subject SearchSubject(String type, String key) throws FileNotFoundException, IOException, RemoteException {
        return SUBJECT_DAO.SearchSubject(type, key);
    }

    @Override
    public boolean deleteSubject(String id) throws IOException, RemoteException {
        //return SUBJECT_DAO.deleteSubject(id);
        if (SUBJECT_RESERVER.reserveSubject(id, this)) {
            if (SUBJECT_DAO.deleteSubject(id)) {
                SUBJECT_OBSERVERBLE.notifySubjectObservers(id + " is deleted");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean updateSubject(Subject subject) throws ClassNotFoundException, IOException, RemoteException {
        // return SUBJECT_DAO.updateSubject(subject);
        if (SUBJECT_RESERVER.reserveSubject(subject.getId(), this)) {
            if (SUBJECT_DAO.updateSubject(subject)) {
                SUBJECT_OBSERVERBLE.notifySubjectObservers(subject.getId() + " is Updated");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean searchId(String id) throws FileNotFoundException, IOException, RemoteException {
        return SUBJECT_DAO.searchId(id);
    }

    @Override
    public boolean addSubjectObserver(SubjectObserver subjectObserver) throws RemoteException {
        return SUBJECT_OBSERVERBLE.addSubjectObserver(subjectObserver);
    }

    @Override
    public boolean removeSubjectObserver(SubjectObserver subjectObserver) throws RemoteException {
        return SUBJECT_OBSERVERBLE.removeSubjectObserver(subjectObserver);
    }

    @Override
    public boolean releaseSubject(String id) throws RemoteException {
        return SUBJECT_RESERVER.releaseSubject(id, this);
    }

    @Override
    public boolean reserveSubject(String id) throws RemoteException {
        return SUBJECT_RESERVER.reserveSubject(id, this);
    }

}
