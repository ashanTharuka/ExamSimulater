/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.observerble;

import edu.ijse.gdse37.examsuccess.observer.FinaleExamScheduleObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ashan Tharuka
 */
public class FinaleExamScheduleObserverble {

    private ArrayList<FinaleExamScheduleObserver> finaleExamScheduleObserverList = new ArrayList<>();

    /**
     *
     * @param finalExam
     * @return
     */
    public boolean addExamObserver(FinaleExamScheduleObserver finalExam) {
        return finaleExamScheduleObserverList.add(finalExam);
    }

    /**
     *
     * @param finalExam
     * @return
     */
    public boolean removeExamObserver(FinaleExamScheduleObserver finalExam) {
        return finaleExamScheduleObserverList.remove(finalExam);
    }

    /**
     *
     * @param message
     * @throws RemoteException
     */
    public void notifyExamObservers(String message) throws RemoteException {
        for (FinaleExamScheduleObserver finalExam : finaleExamScheduleObserverList) {
            new Thread() {
                public void run() {
                    try {
                        finalExam.update(message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(AdminObserverble.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
}
