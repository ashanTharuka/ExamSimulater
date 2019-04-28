/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controller;

import edu.ijse.gdse37.examsuccess.model.Admin;
import edu.ijse.gdse37.examsuccess.observer.AdminObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface AdminController extends Remote {

    /**
     *
     * @param admin
     * @return
     * @throws RemoteException
     * @throws IOException
     * AddAdmin
     */
    public boolean addAdmin(Admin admin) throws RemoteException, IOException;

    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     * getAllAdmin
     */
    public ArrayList<Admin> getAllAdmin() throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param type
     * @param key
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     * searchAdmin
     */
    public Admin SearchAdmin(String type, String key) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws IOException
     * @throws RemoteException
     * deleteAdmin
     */
    public boolean deleteAdmin(String id) throws IOException, RemoteException;

    /**
     *
     * @param admin
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws RemoteException
     * updateAdmin
     */
    public boolean updateAdmin(Admin admin) throws ClassNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     * @throws FileNotFoundException
     * @throws IOException
     * searchId
     */
    public boolean searchId(String id) throws RemoteException, FileNotFoundException, IOException;

    /**
     *
     * @param id
     * @param pass
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     * checkPassword
     */
    public boolean checkPassword(String id, String pass) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     * getName
     */
    public String getName(String id) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     * getEmail
     */
    public String getEmail(String id) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param email
     * @param password
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws RemoteException
     * updateInstituteEmail
     */
    public boolean updateInstituteEmail(String email, String password) throws ClassNotFoundException, IOException, RemoteException;

    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     * getInstitueEmailPassword
     */
    public String getInstitueEmailPassword() throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws RemoteException
     * getPasword
     */
    public String getPasword(String id) throws FileNotFoundException, IOException, RemoteException;

    /**
     *
     * @param adminObserver
     * @return
     * @throws RemoteException
     * addAdminObserver
     */
    public boolean addAdminObserver(AdminObserver adminObserver)throws RemoteException;

    /**
     *
     * @param customerObserver
     * @return
     * @throws RemoteException
     * removeAdminObserver
     */
    public boolean removeAdminObserver(AdminObserver customerObserver)throws RemoteException;
  
    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     * reserveAdmin
     */
    public boolean reserveAdmin(String id)throws RemoteException;

    /**
     *
     * @param id
     * @return
     * @throws RemoteException
     * releaseAdmin
     */
    public boolean releaseAdmin(String id)throws RemoteException;
}
