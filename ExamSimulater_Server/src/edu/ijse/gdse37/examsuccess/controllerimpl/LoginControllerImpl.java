/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controllerimpl;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import edu.ijse.gdse37.examsuccess.controller.LoginController;
import edu.ijse.gdse37.examsuccess.model.Student;
import edu.ijse.gdse37.examsuccess.observer.ExamSimulaterObserver;
import edu.ijse.gdse37.examsuccess.observerble.LoginObserverble;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import javax.mail.internet.AddressException;

/**
 *
 * @author Ashan Tharuka
 */
public class LoginControllerImpl extends UnicastRemoteObject implements LoginController {

    private final LoginObserverble LOGINOBSERVERBLE = new LoginObserverble();

    /**
     *
     * @throws RemoteException
     */
    public LoginControllerImpl() throws RemoteException {
    }

    @Override
    public boolean registerIdIsAvaiable(String id) throws RemoteException {
        return LOGINOBSERVERBLE.registerIdIsAvaiable(id);
    }

    @Override
    public void removeStudentObserver(String key) throws RemoteException {
        LOGINOBSERVERBLE.removeStudentObserver(key);
    }

    @Override
    public void notifyChatObservers(String message) throws RemoteException {
        LOGINOBSERVERBLE.notifyChatObservers(message);
    }

    @Override
    public boolean AdminIdIsAvaiable(String id) throws RemoteException {
        return LOGINOBSERVERBLE.AdminIdIsAvaiable(id);
    }

    @Override
    public void removeAdmin(String key) throws RemoteException {
        LOGINOBSERVERBLE.removeAdmin(key);
    }

    @Override
    public void addAdminOnlineList(String id) throws RemoteException {
        LOGINOBSERVERBLE.addAdminOnlineList(id);
    }

    @Override
    public void sendMessage(String message) throws RemoteException {
        LOGINOBSERVERBLE.notifyChatObservers(message);
    }

    @Override
    public boolean generateAndSendEmail(ArrayList<Student> emailList, String subject, String msg, String ownerEmail, String ownerPassword) throws AddressException, javax.mail.MessagingException, RemoteException {
        return LOGINOBSERVERBLE.generateAndSendEmail(emailList, subject, msg, ownerEmail, ownerPassword);
    }

    @Override
    public void addStudentObserver(String key, ExamSimulaterObserver observer) throws RemoteException {
        LOGINOBSERVERBLE.addStudentObserver(key, observer);
    }

    @Override
    public boolean sendMailTo(String studentEmail, String subject, String msg, String ownerEmail, String ownerPassword) throws AddressException, MessagingException, javax.mail.MessagingException {
        return LOGINOBSERVERBLE.sendMailTo(studentEmail, subject, msg, ownerEmail, ownerPassword);
    }

}
