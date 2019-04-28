/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.observerble;

import edu.ijse.gdse37.examsuccess.model.Student;
import edu.ijse.gdse37.examsuccess.observer.ExamSimulaterObserver;
import edu.ijse.gdse37.examsuccess.other.Email;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.mail.internet.AddressException;

/**
 *
 * @author Ashan Tharuka
 */
public class LoginObserverble {

    private static ArrayList<String> studentOnlineList = new ArrayList<>();
    private static ArrayList<String> adminOnlineList = new ArrayList<>();
    private static HashMap<String, ExamSimulaterObserver> studentList = new HashMap<>();

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public boolean registerIdIsAvaiable(String id) throws RemoteException {
        boolean toReturn = false;
        for (String name : studentOnlineList) {
            if (name.equalsIgnoreCase(id)) {
                toReturn = true;
            }
        }
        return toReturn;
    }

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    public boolean AdminIdIsAvaiable(String id) throws RemoteException {
        boolean toReturn = false;
        for (String name : adminOnlineList) {
            if (name.equalsIgnoreCase(id)) {
                toReturn = true;
            }
        }
        return toReturn;
    }

    /**
     *
     * @param key
     * @param observer
     */
    public void addStudentObserver(String key, ExamSimulaterObserver observer) {
        studentList.put(key, observer);
        studentOnlineList.add(key);
    }

    /**
     *
     * @param key
     */
    public void removeStudentObserver(String key) {
        studentList.remove(key);
        studentOnlineList.remove(key);
    }

    /**
     *
     * @param key
     */
    public void removeAdmin(String key) {
        adminOnlineList.remove(key);

    }

    /**
     *
     * @param id
     */
    public void addAdminOnlineList(String id) {
        adminOnlineList.add(id);
    }

    /**
     *
     * @param message
     * @throws RemoteException
     */
    public void notifyChatObservers(String message) throws RemoteException {
        Collection<ExamSimulaterObserver> e = studentList.values();
        for (ExamSimulaterObserver exam : e) {
            new Thread() {
                public void run() {
                    try {
                        exam.update(message);
                    } catch (RemoteException ex) {

                    }
                }
            }.start();
        }

    }

    /**
     *
     * @param studentEmail
     * @param subject
     * @param msg
     * @param ownerEmail
     * @param ownerPassword
     * @return
     * @throws AddressException
     * @throws MessagingException
     * @throws javax.mail.MessagingException
     */
    public boolean sendMailTo(String studentEmail, String subject, String msg, String ownerEmail, String ownerPassword) throws AddressException, MessagingException, javax.mail.MessagingException {
        return Email.generateAndSendEmail(studentEmail, subject, msg, ownerEmail, ownerPassword);

    }

    /**
     *
     * @param emailList
     * @param subject
     * @param msg
     * @param ownerEmail
     * @param ownerPassword
     * @return
     * @throws AddressException
     * @throws javax.mail.MessagingException
     */
    public static boolean generateAndSendEmail(ArrayList<Student> emailList, String subject, String msg, String ownerEmail, String ownerPassword) throws AddressException, javax.mail.MessagingException {
        System.out.println(emailList.toArray());
        return Email.generateAndSendEmail(emailList, subject, msg, ownerEmail, ownerPassword);
    }
}
