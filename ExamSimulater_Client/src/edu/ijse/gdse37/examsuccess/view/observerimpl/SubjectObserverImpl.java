/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.observerimpl;

import edu.ijse.gdse37.examsuccess.observer.SubjectObserver;
import edu.ijse.gdse37.examsuccess.view.subject.View_Subject_Panal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Ashan Tharuka
 */
public class SubjectObserverImpl extends UnicastRemoteObject implements SubjectObserver {

    private View_Subject_Panal view;

    /**
     *
     * @throws RemoteException
     */
    public SubjectObserverImpl() throws RemoteException {
    }

    /**
     *
     * @param view
     * @throws RemoteException
     */
    public SubjectObserverImpl(View_Subject_Panal view) throws RemoteException {
        this.view = view;
    }

    @Override
    public void update(String message) throws RemoteException {
        view.updateMessage(message);
    }
}
