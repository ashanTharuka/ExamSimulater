/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.observerimpl;

import edu.ijse.gdse37.examsuccess.observer.StudentObserver;
import edu.ijse.gdse37.examsuccess.view.student.View_Student_Panal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Ashan Tharuka
 */
public class StudentObserverImpl extends UnicastRemoteObject implements StudentObserver{

    private View_Student_Panal view;

    /**
     *
     * @throws RemoteException
     */
    public StudentObserverImpl() throws RemoteException {
    }

    /**
     *
     * @param view
     * @throws RemoteException
     */
    public StudentObserverImpl(View_Student_Panal view) throws RemoteException {
        this.view = view;
    }

    @Override
    public void update(String message) throws RemoteException {
        view.updateMessage(message);
    }
}
