/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.daosuper;

import edu.ijse.gdse37.examsuccess.model.Cemester;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface SuperDaoSemester {
    public boolean addCemester(Cemester cemester) throws RemoteException, IOException;
    public ArrayList<Cemester> getAllCemester() throws FileNotFoundException, IOException, RemoteException;
    public Cemester SearchCemester(String type, String key) throws FileNotFoundException, IOException, RemoteException;
    public boolean deleteCemester(String id) throws IOException,RemoteException;
    public boolean updateCemester(Cemester cemester) throws ClassNotFoundException, IOException,RemoteException;
    public boolean searchId(String id) throws FileNotFoundException, IOException,RemoteException; 
}
