/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.reservation;

import edu.ijse.gdse37.examsuccess.controller.AdminController;
import java.util.HashMap;

/**
 *
 * @author Ashan Tharuka
 */
public class AdminReserver {

    private static HashMap<String, AdminController> reserveData = new HashMap<>();

    /**
     *
     * @param id
     * @param adminController
     * @return
     */
    public boolean reserveAdmin(String id, AdminController adminController) {
     
        if (reserveData.containsKey(id)) {
            if (reserveData.get(id) == adminController) {
                return true;
            } else {
                return false;
            }

        } else {
            reserveData.put(id, adminController);
            return true;
        }

    }

    /**
     *
     * @param id
     * @param adminController
     * @return
     */
    public boolean releaseAdmin(String id, AdminController adminController) {
      
        if (reserveData.get(id) == adminController) {
            reserveData.remove(id);
            return true;
        } else {
            return false;
        }
    }

//    public static void main(String[] args) {
//        if (reserveData.get("962763413v")==reserveData.get("965678455v")) {
//            System.out.println("yes");
//        }else{System.out.println("no");}
//    }
}
