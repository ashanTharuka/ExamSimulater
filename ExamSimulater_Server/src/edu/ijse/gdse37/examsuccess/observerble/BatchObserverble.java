/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.observerble;

import edu.ijse.gdse37.examsuccess.observer.BatchObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ashan Tharuka
 */
public class BatchObserverble {

    private ArrayList<BatchObserver> batchObserverList = new ArrayList<>();

    /**
     *
     * @param batchObserver
     * @return
     */
    public boolean addBatchObserver(BatchObserver batchObserver) {
        return batchObserverList.add(batchObserver);
    }

    /**
     *
     * @param batchObserver
     * @return
     */
    public boolean removeBatchObserver(BatchObserver batchObserver) {
        return batchObserverList.remove(batchObserver);
    }

    /**
     *
     * @param message
     * @throws RemoteException
     */
    public void notifyBatchObservers(String message) throws RemoteException {
        for (BatchObserver batchObserver : batchObserverList) {
            new Thread() {
                public void run() {
                    try {
                        batchObserver.update(message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(AdminObserverble.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }

}
