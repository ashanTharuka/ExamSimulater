/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.observerimpl;

import edu.ijse.gdse37.examsuccess.observer.BatchObserver;
import edu.ijse.gdse37.examsuccess.view.batch.View_Batch_Panal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Ashan Tharuka
 */
public class BatchObserverImpl extends UnicastRemoteObject implements BatchObserver{

    private View_Batch_Panal view;

    /**
     *
     * @throws RemoteException
     */
    public BatchObserverImpl() throws RemoteException {
    }

    /**
     *
     * @param view
     * @throws RemoteException
     */
    public BatchObserverImpl(View_Batch_Panal view) throws RemoteException {
        this.view = view;
    }

    @Override
    public void update(String message) throws RemoteException {
        view.updateMessage(message);
    }
}
