/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.observerimpl;

import edu.ijse.gdse37.examsuccess.observer.ExamSimulaterObserver;
import edu.ijse.gdse37.examsuccess.view.student.Student;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Ashan Tharuka
 */
public class ExamSimulaterObserverImpl extends UnicastRemoteObject implements ExamSimulaterObserver {

    private Student student;
  
    /**
     *
     * @throws RemoteException
     */
    public ExamSimulaterObserverImpl() throws RemoteException {
    }

    /**
     *
     * @param student
     * @throws RemoteException
     */
    public ExamSimulaterObserverImpl(Student student) throws RemoteException {
        this.student = student;
    }

  

    @Override
    public void update(String message) throws RemoteException {
        student.setMessage(message);
    }
}
