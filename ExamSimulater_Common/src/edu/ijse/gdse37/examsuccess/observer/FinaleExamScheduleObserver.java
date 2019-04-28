/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Ashan Tharuka
 */
public interface FinaleExamScheduleObserver extends Remote{

    /**
     *
     * @param message
     * @throws RemoteException
     */
    public void update(String message) throws RemoteException;
    
}
