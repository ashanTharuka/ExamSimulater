/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.observerble;

import edu.ijse.gdse37.examsuccess.observer.AdminObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ashan Tharuka
 */
public class AdminObserverble {

    private ArrayList<AdminObserver> adminObserverList = new ArrayList<>();

    /**
     *
     * @param adminObserver
     * @return
     */
    public boolean addAdminObserver(AdminObserver adminObserver) {
        return adminObserverList.add(adminObserver);
    }

    /**
     *
     * @param adminObserver
     * @return
     */
    public boolean removeAdminObserver(AdminObserver adminObserver) {
        return adminObserverList.remove(adminObserver);
    }

    /**
     *
     * @param message
     * @throws RemoteException
     */
    public void notifyAdminObservers(String message) throws RemoteException {
        for (AdminObserver adminObserver : adminObserverList) {
            new Thread() {
                public void run() {
                    try {
                        adminObserver.update(message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(AdminObserverble.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }

}
