/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.observerble;

import edu.ijse.gdse37.examsuccess.observer.StudentObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ashan Tharuka
 */
public class Student_Observerble {

    private ArrayList<StudentObserver> studentbserverList = new ArrayList<>();

    /**
     *
     * @param studentObserver
     * @return
     */
    public boolean addStudentObserver(StudentObserver studentObserver) {
        return studentbserverList.add(studentObserver);
    }

    /**
     *
     * @param studentObserver
     * @return
     */
    public boolean removeStudentObserver(StudentObserver studentObserver) {
        return studentbserverList.remove(studentObserver);
    }

    /**
     *
     * @param message
     * @throws RemoteException
     */
    public void notifyStudentObservers(String message) throws RemoteException {
        for (StudentObserver studentObserver : studentbserverList) {
            new Thread() {
                public void run() {
                    try {
                        studentObserver.update(message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(AdminObserverble.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
}
