/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.reservation;

import edu.ijse.gdse37.examsuccess.controller.BatchController;
import java.util.HashMap;

/**
 *
 * @author Ashan Tharuka
 */
public class BatchReserver {

    private static  HashMap<String, BatchController> reserveData = new HashMap<>();

    /**
     *
     * @param id
     * @param batchController
     * @return
     */
    public boolean reserveBatch(String id, BatchController batchController) {
        if (reserveData.containsKey(id)) {
            if (reserveData.get(id) == batchController) {
                return true;
            } else {
                return false;
            }

        } else {
            reserveData.put(id, batchController);
            return true;
        }

    }

    /**
     *
     * @param id
     * @param batchController
     * @return
     */
    public boolean releaseBatch(String id, BatchController batchController) {
        if (reserveData.get(id) == batchController) {
            reserveData.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
