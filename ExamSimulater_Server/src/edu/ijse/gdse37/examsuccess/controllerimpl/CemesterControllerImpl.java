/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controllerimpl;

import edu.ijse.gdse37.examsuccess.model.Cemester;
import edu.ijse.gdse37.examsuccess.controller.SemesterController;
import edu.ijse.gdse37.examsuccess.dao.SemesterDaoFile;
import edu.ijse.gdse37.examsuccess.observer.SemesterObserver;
import edu.ijse.gdse37.examsuccess.observerble.SemesterObserverble;
import edu.ijse.gdse37.examsuccess.reservation.SemestertReserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public class CemesterControllerImpl extends UnicastRemoteObject implements SemesterController {

    private final SemesterDaoFile SEMESTER_DAO = new SemesterDaoFile();
    private final SemesterObserverble SEMESTER_OBSERVERBLE = new SemesterObserverble();
    private final SemestertReserver SEMESTER_RESERVER = new SemestertReserver();

    /**
     *
     * @throws RemoteException
     */
    public CemesterControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addCemester(Cemester cemester) throws RemoteException, IOException {
        //  return SEMESTER_DAO.addCemester(cemester);
        if (SEMESTER_RESERVER.reserveSemester(cemester.getId(), this)) {
            if (SEMESTER_DAO.addCemester(cemester)) {
                SEMESTER_OBSERVERBLE.notifySemesterObservers(cemester.getId() + " is added");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Cemester> getAllCemester() throws FileNotFoundException, IOException, RemoteException {
        return SEMESTER_DAO.getAllCemester();
    }

    @Override
    public Cemester SearchCemester(String type, String key) throws FileNotFoundException, IOException, RemoteException {
        return SEMESTER_DAO.SearchCemester(type, key);
    }

    @Override
    public boolean deleteCemester(String id) throws IOException, RemoteException {
        // return SEMESTER_DAO.deleteCemester(id);
        if (SEMESTER_RESERVER.reserveSemester(id, this)) {
            if (SEMESTER_DAO.deleteCemester(id)) {
                SEMESTER_OBSERVERBLE.notifySemesterObservers(id + " is deleted");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean updateCemester(Cemester cemester) throws ClassNotFoundException, IOException, RemoteException {
        // return SEMESTER_DAO.updateCemester(cemester);
        if (SEMESTER_RESERVER.reserveSemester(cemester.getId(), this)) {
            if (SEMESTER_DAO.updateCemester(cemester)) {
                SEMESTER_OBSERVERBLE.notifySemesterObservers(cemester.getId() + " is Updated");
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
        return SEMESTER_DAO.searchId(id);
    }

    @Override
    public boolean addSemesterObserver(SemesterObserver semesterObserver) throws RemoteException {
        return SEMESTER_OBSERVERBLE.addSemesterObserver(semesterObserver);
    }

    @Override
    public boolean removeSemesterObserver(SemesterObserver semesterObserver) throws RemoteException {
        return SEMESTER_OBSERVERBLE.removeSemesterObserver(semesterObserver);
    }

    @Override
    public boolean reserveSemester(String id) throws RemoteException {
        return SEMESTER_RESERVER.reserveSemester(id, this);
    }

    @Override
    public boolean releaseSemester(String id) throws RemoteException {
        return SEMESTER_RESERVER.releaseSemester(id, this);
    }

}
