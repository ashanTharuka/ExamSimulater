/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.observerimpl;

import edu.ijse.gdse37.examsuccess.observer.FinaleExamScheduleObserver;
import edu.ijse.gdse37.examsuccess.view.manage.ViewSchedule;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Ashan Tharuka
 */
public class FinalExamScheduleObserverImpl extends UnicastRemoteObject implements FinaleExamScheduleObserver {

    private ViewSchedule view;

    /**
     *
     * @throws RemoteException
     */
    public FinalExamScheduleObserverImpl() throws RemoteException {
    }

    /**
     *
     * @param view
     * @throws RemoteException
     */
    public FinalExamScheduleObserverImpl(ViewSchedule view) throws RemoteException {
        this.view = view;
    }

    @Override
    public void update(String message) throws RemoteException {
        view.updateMessage(message);
    }
}
