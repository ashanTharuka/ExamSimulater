/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.reservation;

import edu.ijse.gdse37.examsuccess.controller.ExamController;
import java.util.HashMap;

/**
 *
 * @author Ashan Tharuka
 */
public class ManageExamReserver {

    private static  HashMap<String, ExamController> reserveData = new HashMap<>();

    /**
     *
     * @param id
     * @param examController
     * @return
     */
    public boolean reserveManageExam(String id, ExamController examController) {
        if (reserveData.containsKey(id)) {
            if (reserveData.get(id) == examController) {
                return true;
            } else {
                return false;
            }

        } else {
            reserveData.put(id, examController);
            return true;
        }

    }

    /**
     *
     * @param id
     * @param examController
     * @return
     */
    public boolean releaseManageExam(String id, ExamController examController) {
        if (reserveData.get(id) == examController) {
            reserveData.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
