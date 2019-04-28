/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.reservation;

import edu.ijse.gdse37.examsuccess.controller.SemesterController;
import java.util.HashMap;

/**
 *
 * @author Ashan Tharuka
 */
public class SemestertReserver {

    private static HashMap<String, SemesterController> reserveData = new HashMap<>();

    /**
     *
     * @param id
     * @param semesterController
     * @return
     */
    public boolean reserveSemester(String id, SemesterController semesterController) {
        if (reserveData.containsKey(id)) {
            if (reserveData.get(id) == semesterController) {
                return true;
            } else {
                return false;
            }

        } else {
            reserveData.put(id, semesterController);
            return true;
        }

    }

    /**
     *
     * @param id
     * @param semesterController
     * @return
     */
    public boolean releaseSemester(String id, SemesterController semesterController) {
        if (reserveData.get(id) == semesterController) {
            reserveData.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
