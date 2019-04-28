/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controllerimpl;

import edu.ijse.gdse37.examsuccess.model.Admin;
import edu.ijse.gdse37.examsuccess.controller.AdminController;
import edu.ijse.gdse37.examsuccess.dao.AdminDaoFile;
import edu.ijse.gdse37.examsuccess.observer.AdminObserver;
import edu.ijse.gdse37.examsuccess.observerble.AdminObserverble;
import edu.ijse.gdse37.examsuccess.reservation.AdminReserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public class AdminControllerImpl extends UnicastRemoteObject implements AdminController {

    private final AdminDaoFile ADMIN_DAO = new AdminDaoFile();
    private final AdminObserverble ADMIN_OBSERVERBLE = new AdminObserverble();
    private final AdminReserver ADMIN_RESERVER = new AdminReserver();

    /**
     *
     * @throws RemoteException
     */
    public AdminControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addAdmin(Admin admin) throws RemoteException, IOException {

        if (ADMIN_RESERVER.reserveAdmin(admin.getId(), this)) {
            if (ADMIN_DAO.addAdmin(admin)) {
                ADMIN_OBSERVERBLE.notifyAdminObservers(admin.getId() + " is added");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Admin> getAllAdmin() throws FileNotFoundException, IOException, RemoteException {
        return ADMIN_DAO.getAllAdmin();
    }

    @Override
    public Admin SearchAdmin(String type, String key) throws FileNotFoundException, IOException, RemoteException {
        return ADMIN_DAO.SearchAdmin(type, key);
    }

    @Override
    public boolean deleteAdmin(String id) throws IOException, RemoteException {
        // return ADMIN_DAO.deleteAdmin(id);
        if (ADMIN_RESERVER.reserveAdmin(id, this)) {
            if (ADMIN_DAO.deleteAdmin(id)) {
                ADMIN_OBSERVERBLE.notifyAdminObservers(id + " is deleted");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean updateAdmin(Admin admin) throws ClassNotFoundException, IOException, RemoteException {
        // return ADMIN_DAO.updateAdmin(admin);
        if (ADMIN_RESERVER.reserveAdmin(admin.getId(), this)) {
            if (ADMIN_DAO.updateAdmin(admin)) {
                ADMIN_OBSERVERBLE.notifyAdminObservers(admin.getId() + " is Updated");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    @Override
    public boolean searchId(String id) throws RemoteException, FileNotFoundException, IOException {
        return ADMIN_DAO.searchId(id);

    }

    @Override
    public boolean checkPassword(String id, String pass) throws FileNotFoundException, IOException, RemoteException {
        return ADMIN_DAO.checkPassword(id, pass);
    }

    @Override
    public String getName(String id) throws FileNotFoundException, IOException, RemoteException {
        return ADMIN_DAO.getName(id);
    }

    @Override
    public String getEmail(String id) throws FileNotFoundException, IOException, RemoteException {
        return ADMIN_DAO.getEmail(id);
    }

    @Override
    public boolean updateInstituteEmail(String email, String password) throws ClassNotFoundException, IOException, RemoteException {
        return ADMIN_DAO.updateInstituteEmail(email, password);
    }

    @Override
    public String getInstitueEmailPassword() throws FileNotFoundException, IOException, RemoteException {
        return ADMIN_DAO.getInstitueEmailPassword();
    }

    @Override
    public String getPasword(String id) throws FileNotFoundException, IOException, RemoteException {
        return ADMIN_DAO.getPasword(id);
    }

    @Override
    public boolean addAdminObserver(AdminObserver adminObserver) throws RemoteException {
        return ADMIN_OBSERVERBLE.addAdminObserver(adminObserver);
    }

    @Override
    public boolean removeAdminObserver(AdminObserver adminObserver) throws RemoteException {
        return ADMIN_OBSERVERBLE.removeAdminObserver(adminObserver);
    }

    @Override
    public boolean reserveAdmin(String id) throws RemoteException {
       return ADMIN_RESERVER.reserveAdmin(id, this);
    }

    @Override
    public boolean releaseAdmin(String id) throws RemoteException {
        return ADMIN_RESERVER.releaseAdmin(id, this);
    }

}
