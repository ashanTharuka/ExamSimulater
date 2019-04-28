/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.observerble;

import edu.ijse.gdse37.examsuccess.observer.SubjectObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ashan Tharuka
 */
public class SubjectObserverble {
    

    private ArrayList<SubjectObserver> subjectObserverList = new ArrayList<>();

    /**
     *
     * @param subjectObserver
     * @return
     */
    public boolean addSubjectObserver(SubjectObserver subjectObserver) {
        return subjectObserverList.add(subjectObserver);
    }

    /**
     *
     * @param subjectObserver
     * @return
     */
    public boolean removeSubjectObserver(SubjectObserver subjectObserver) {
        return subjectObserverList.remove(subjectObserver);
    }

    /**
     *
     * @param message
     * @throws RemoteException
     */
    public void notifySubjectObservers(String message) throws RemoteException {
        for (SubjectObserver subjectObserver : subjectObserverList) {
            new Thread() {
                public void run() {
                    try {
                        subjectObserver.update(message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(AdminObserverble.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
}
