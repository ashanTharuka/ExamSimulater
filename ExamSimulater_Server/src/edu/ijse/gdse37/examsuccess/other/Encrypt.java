package edu.ijse.gdse37.examsuccess.other;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ashan Tharuka
 */
public class Encrypt {

//    public static void main(String[] args) {
//        Encrypt a = new Encrypt();
//        String cipher = a.cipher("12");
//        a.decipher(cipher);
//
//    }

    /**
     *
     * @param strToEncrypt
     * @return
     * cipher method
     */
        public static String cipher(String strToEncrypt) {
        StringBuffer sf = new StringBuffer();
        try {
            char[] ar = strToEncrypt.toCharArray();
            for (char s : ar) {
                sf.append(Integer.toString((int) s) + ",");
            }
           

        } catch (NullPointerException ex) {

        }
        return sf.toString();

    }

    /**
     *
     * @param strToDecrypt
     * @return
     * decipher method
     */
    public static String decipher(String strToDecrypt) {
        StringBuffer sf = new StringBuffer();
        try {

            String[] ar = strToDecrypt.split(",");

            for (String s : ar) {
                sf.append((char) Integer.parseInt(s));
            }
            

        } catch (NullPointerException ex) {

        }
        return sf.toString();
    }

}
