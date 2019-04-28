package edu.ijse.gdse37.examsuccess.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import edu.ijse.gdse37.examsuccess.model.Student;
import edu.ijse.gdse37.examsuccess.observer.ExamSimulaterObserver;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;



/**
 *
 * @author Ashan Tharuka
 */
public interface LoginController extends Remote {

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public boolean registerIdIsAvaiable(String id) throws RemoteException;

    /**
     *
     * @param key
     * @param observer
     * @throws RemoteException
     */
    public void addStudentObserver(String key, ExamSimulaterObserver observer) throws RemoteException;

    /**
     *
     * @param key
     * @throws RemoteException
     */
    public void removeStudentObserver(String key) throws RemoteException;

    /**
     *
     * @param message
     * @throws RemoteException
     */
    public void notifyChatObservers(String message) throws RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public boolean AdminIdIsAvaiable(String id) throws RemoteException;

    /**
     *
     * @param key
     * @throws RemoteException
     */
    public void removeAdmin(String key)throws RemoteException;

    /**
     *
     * @param id
     * @throws RemoteException
     */
    public void addAdminOnlineList(String id)throws RemoteException;

    /**
     *
     * @param message
     * @throws RemoteException
     */
    public void sendMessage(String message) throws RemoteException;

    /**
     *
     * @param studentEmail
     * @param subject
     * @param msg
     * @param ownerEmail
     * @param ownerPassword
     * @return
     * @throws AddressException
     * @throws com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException
     * @throws MessagingException
     * @throws RemoteException
     */
    public boolean sendMailTo(String studentEmail, String subject, String msg, String ownerEmail, String ownerPassword)  throws AddressException, com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException, javax.mail.MessagingException,RemoteException;

    /**
     *
     * @param emailList
     * @param subject
     * @param msg
     * @param ownerEmail
     * @param ownerPassword
     * @return
     * @throws AddressException
     * @throws MessagingException
     * @throws RemoteException
     */
    public boolean generateAndSendEmail(ArrayList<Student> emailList, String subject, String msg, String ownerEmail, String ownerPassword) throws AddressException, javax.mail.MessagingException, RemoteException;

}
