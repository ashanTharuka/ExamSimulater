/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.reservation;

import edu.ijse.gdse37.examsuccess.controller.StudentController;
import java.util.HashMap;

/**
 *
 * @author Ashan Tharuka
 */
public class StudentReserver {

    private static HashMap<String, StudentController> reserveData = new HashMap<>();

    /**
     *
     * @param id
     * @param studentController
     * @return
     */
    public boolean reserveStudent(String id, StudentController studentController) {
        if (reserveData.containsKey(id)) {
            if (reserveData.get(id) == studentController) {
                return true;
            } else {
                return false;
            }

        } else {
            reserveData.put(id, studentController);
            return true;
        }

    }

    /**
     *
     * @param id
     * @param studentController
     * @return
     */
    public boolean releaseStudent(String id, StudentController studentController) {
        if (reserveData.get(id) == studentController) {
            reserveData.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
