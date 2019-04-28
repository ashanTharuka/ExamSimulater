/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.reservation;

import edu.ijse.gdse37.examsuccess.controller.SubjectController;
import java.util.HashMap;

/**
 *
 * @author Ashan Tharuka
 */
public class SubjectReserver {

    private static HashMap<String, SubjectController> reserveData = new HashMap<>();

    /**
     *
     * @param id
     * @param subjectController
     * @return
     */
    public boolean reserveSubject(String id, SubjectController subjectController) {
        if (reserveData.containsKey(id)) {
            if (reserveData.get(id) == subjectController) {
                return true;
            } else {
                return false;
            }

        } else {
            reserveData.put(id, subjectController);
            return true;
        }

    }

    /**
     *
     * @param id
     * @param subjectController
     * @return
     */
    public boolean releaseSubject(String id, SubjectController subjectController) {
        if (reserveData.get(id) == subjectController) {
            reserveData.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
