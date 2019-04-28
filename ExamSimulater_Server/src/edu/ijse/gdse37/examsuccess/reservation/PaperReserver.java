/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.reservation;

import edu.ijse.gdse37.examsuccess.controller.QuestionController;
import java.util.HashMap;

/**
 *
 * @author Ashan Tharuka
 */
public class PaperReserver {

    private static HashMap<String, QuestionController> reserveData = new HashMap<>();

    /**
     *
     * @param id
     * @param questionController
     * @return
     */
    public boolean reservePaper(String id, QuestionController questionController) {
        System.out.println("RESERVE: " + id);
        System.out.println(questionController);
        if (reserveData.containsKey(id)) {
            System.out.println("contain: " + id);
            if (reserveData.get(id) == questionController) {
                System.out.println("==: "+(reserveData.get(id) == questionController));
                return true;
            } else {
                return false;
            }

        } else {
            reserveData.put(id, questionController);
            return true;
        }

    }

    /**
     *
     * @param id
     * @param questionController
     * @return
     */
    public boolean releasePaper(String id, QuestionController questionController) {
        System.out.println("RELESE: " + id);
        System.out.println(questionController);
        if (reserveData.get(id) == questionController) {
            reserveData.remove(id);
            return true;
        } else {
            return false;
        }
    }

}
