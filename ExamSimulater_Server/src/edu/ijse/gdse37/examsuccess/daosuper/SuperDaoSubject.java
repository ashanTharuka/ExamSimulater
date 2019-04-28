/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.daosuper;

import edu.ijse.gdse37.examsuccess.model.Subject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface SuperDaoSubject {
    public boolean addSubject(Subject subject) throws RemoteException, IOException;
    public ArrayList<Subject> getAllSubject() throws FileNotFoundException, IOException, RemoteException;
    public Subject SearchSubject(String type, String key) throws FileNotFoundException, IOException, RemoteException;
    public boolean deleteSubject(String id) throws IOException,RemoteException;
    public boolean updateSubject(Subject subject) throws ClassNotFoundException, IOException,RemoteException;
    public boolean searchId(String id) throws FileNotFoundException, IOException,RemoteException;
}
