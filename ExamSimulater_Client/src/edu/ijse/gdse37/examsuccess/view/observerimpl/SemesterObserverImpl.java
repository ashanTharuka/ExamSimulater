/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.observerimpl;

import edu.ijse.gdse37.examsuccess.observer.SemesterObserver;
import edu.ijse.gdse37.examsuccess.view.cemester.View_Cemester_Panal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Ashan Tharuka
 */
public class SemesterObserverImpl extends UnicastRemoteObject implements SemesterObserver {

    private View_Cemester_Panal view;

    /**
     *
     * @throws RemoteException
     */
    public SemesterObserverImpl() throws RemoteException {
    }

    /**
     *
     * @param view
     * @throws RemoteException
     */
    public SemesterObserverImpl(View_Cemester_Panal view) throws RemoteException {
        this.view = view;
    }

    @Override
    public void update(String message) throws RemoteException {
        view.updateMessage(message);
    }
}
