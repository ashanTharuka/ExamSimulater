/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.observerble;

import edu.ijse.gdse37.examsuccess.observer.SemesterObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ashan Tharuka
 */
public class SemesterObserverble {

    private ArrayList<SemesterObserver> semesterObserverList = new ArrayList<>();

    /**
     *
     * @param semesterObserver
     * @return
     */
    public boolean addSemesterObserver(SemesterObserver semesterObserver) {
        return semesterObserverList.add(semesterObserver);
    }

    /**
     *
     * @param semesterObserver
     * @return
     */
    public boolean removeSemesterObserver(SemesterObserver semesterObserver) {
        return semesterObserverList.remove(semesterObserver);
    }

    /**
     *
     * @param message
     * @throws RemoteException
     */
    public void notifySemesterObservers(String message) throws RemoteException {
        for (SemesterObserver semesterObserver : semesterObserverList) {
            new Thread() {
                public void run() {
                    try {
                        semesterObserver.update(message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(AdminObserverble.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
}
