/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.observerimpl;

import edu.ijse.gdse37.examsuccess.observer.AdminObserver;
import edu.ijse.gdse37.examsuccess.view.admin.View_Admin_Panal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Ashan Tharuka
 */
public class AdminObserverImpl extends UnicastRemoteObject implements AdminObserver{

    private View_Admin_Panal view;

    /**
     *
     * @throws RemoteException
     */
    public AdminObserverImpl() throws RemoteException {
    }

    /**
     *
     * @param view
     * @throws RemoteException
     */
    public AdminObserverImpl(View_Admin_Panal view) throws RemoteException {
        this.view = view;
    }

    @Override
    public void update(String message) throws RemoteException {
        view.updateMessage(message);
    }
}
