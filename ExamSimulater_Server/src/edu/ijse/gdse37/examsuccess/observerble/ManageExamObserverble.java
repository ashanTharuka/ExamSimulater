/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.observerble;

import edu.ijse.gdse37.examsuccess.observer.ManageExamObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ashan Tharuka
 */
public class ManageExamObserverble {

    private ArrayList<ManageExamObserver> manageExamObserverList = new ArrayList<>();

    /**
     *
     * @param manageExamObserver
     * @return
     */
    public boolean addManageExamObserver(ManageExamObserver manageExamObserver) {
        return manageExamObserverList.add(manageExamObserver);
    }

    /**
     *
     * @param manageExamObserver
     * @return
     */
    public boolean removeManageExamObserver(ManageExamObserver manageExamObserver) {
        return manageExamObserverList.remove(manageExamObserver);
    }

    /**
     *
     * @param message
     * @throws RemoteException
     */
    public void notifyManageExamObservers(String message) throws RemoteException {
        for (ManageExamObserver manageExamObserver : manageExamObserverList) {
            new Thread() {
                public void run() {
                    try {
                        manageExamObserver.update(message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(AdminObserverble.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }

}
