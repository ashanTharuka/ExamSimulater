/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.startserver;

import edu.ijse.gdse37.examsuccess.controllerimpl.ExamFactoryImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 *
 * @author Ashan Tharuka
 */
public class StartServer {
    public static void main(String[] args) {
        try {
            Registry examRegistry=LocateRegistry.createRegistry(5050);
            System.out.println("**** Start Exam Server ****");
            examRegistry.rebind("Exam_Server", new ExamFactoryImpl());
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Restart Server", "Warning!", 2);
        }
    }
}
