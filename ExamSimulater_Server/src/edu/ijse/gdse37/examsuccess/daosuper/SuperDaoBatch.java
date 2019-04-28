/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.daosuper;

import edu.ijse.gdse37.examsuccess.model.Batch;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface SuperDaoBatch {
    public boolean addBatch(Batch batch) throws RemoteException, IOException;
    public ArrayList<Batch> getAllBatch() throws FileNotFoundException, IOException, RemoteException;
    public Batch SearchBatch(String type, String key) throws FileNotFoundException, IOException, RemoteException;
    public boolean deleteBatch(String id) throws IOException,RemoteException;
    public boolean updateBatch(Batch batch) throws ClassNotFoundException, IOException,RemoteException;
    public boolean searchId(String id) throws FileNotFoundException, IOException ,RemoteException;
}
