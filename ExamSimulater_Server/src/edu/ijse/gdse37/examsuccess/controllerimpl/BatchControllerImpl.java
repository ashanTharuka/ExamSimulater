/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.controllerimpl;

import edu.ijse.gdse37.examsuccess.model.Batch;
import edu.ijse.gdse37.examsuccess.controller.BatchController;
import edu.ijse.gdse37.examsuccess.dao.BatchDaoFile;
import edu.ijse.gdse37.examsuccess.observer.BatchObserver;
import edu.ijse.gdse37.examsuccess.observerble.BatchObserverble;
import edu.ijse.gdse37.examsuccess.reservation.BatchReserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public class BatchControllerImpl extends UnicastRemoteObject implements BatchController {

    private final BatchDaoFile BATCH_DAO = new BatchDaoFile();
    private final BatchObserverble BATCH_OBSERVERBLE = new BatchObserverble();
    private final BatchReserver BATCH_RESERVER = new BatchReserver();

    /**
     *
     * @throws RemoteException
     */
    public BatchControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addBatch(Batch batch) throws RemoteException, IOException {
        // return BATCH_DAO.addBatch(batch);
        if (BATCH_RESERVER.reserveBatch(batch.getId(), this)) {
            if (BATCH_DAO.addBatch(batch)) {
                BATCH_OBSERVERBLE.notifyBatchObservers(batch.getId() + " is added");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Batch> getAllBatch() throws FileNotFoundException, IOException, RemoteException {
        return BATCH_DAO.getAllBatch();
    }

    @Override
    public Batch SearchBatch(String type, String key) throws FileNotFoundException, IOException, RemoteException {
        return BATCH_DAO.SearchBatch(type, key);
    }

    @Override
    public boolean deleteBatch(String id) throws IOException, RemoteException {
        // return BATCH_DAO.deleteBatch(id);
        if (BATCH_RESERVER.reserveBatch(id, this)) {
            if (BATCH_DAO.deleteBatch(id)) {
                BATCH_OBSERVERBLE.notifyBatchObservers(id + " is deleted");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    @Override
    public boolean updateBatch(Batch batch) throws ClassNotFoundException, IOException, RemoteException {
        if (BATCH_RESERVER.reserveBatch(batch.getId(), this)) {
            if (BATCH_DAO.updateBatch(batch)) {
                BATCH_OBSERVERBLE.notifyBatchObservers(batch.getId() + " is Updated");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean searchId(String id) throws FileNotFoundException, IOException, RemoteException {
        return BATCH_DAO.searchId(id);
    }

    @Override
    public boolean addBatchObserver(BatchObserver batchObserver) throws RemoteException {
        return BATCH_OBSERVERBLE.addBatchObserver(batchObserver);
    }

    @Override
    public boolean removeObserver(BatchObserver batchObserver) throws RemoteException {
        return BATCH_OBSERVERBLE.removeBatchObserver(batchObserver);
    }

    @Override
    public boolean reserveBatch(String id) throws RemoteException {
        return BATCH_RESERVER.reserveBatch(id, this);
    }

    @Override
    public boolean releaseBatch(String id) throws RemoteException {
        return BATCH_RESERVER.releaseBatch(id, this);
    }
}
