package edu.ijse.gdse37.examsuccess.view.other;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JTextField;

/**
 *
 * @author Ashan Tharuka
 */
public class Validation {

    /**
     *
     * @param textFild
     */
    public static void phoneNumber(JTextField textFild) {
        try {
            String txt = textFild.getText();
            int caretPosition = textFild.getCaretPosition();
            if (!txt.matches("^[0-9]{0,10}$")) {
                txt = txt.substring(0, caretPosition - 1) + txt.substring(caretPosition);
                textFild.setText(txt);
                textFild.setCaretPosition(caretPosition - 1);
            }
        } catch (StringIndexOutOfBoundsException ex) {
        }

    }

    /**
     *
     * @param textField
     */
    public static void validationText(JTextField textField) {
        try {
            String text = textField.getText();
            if (!text.isEmpty()) {
                boolean res = text.matches("^[0-9]{0,9}[v]{0,1}?$");
                if (!res) {
                    textField.setText(text.substring(0, text.length() - 1));
                }
            }
        } catch (StringIndexOutOfBoundsException ex) {
        }
    }

    /**
     *
     * @param textFild
     */
    public static void name(JTextField textFild) {
        try {
            String txt = textFild.getText();
            int caretPosition = textFild.getCaretPosition();
            if (!txt.matches("^[A-Za-z// ][^~@!]*$")) {
                textFild.setText(txt.substring(0, caretPosition - 1) + txt.substring(caretPosition));
                textFild.setCaretPosition(caretPosition - 1);
            }
        } catch (StringIndexOutOfBoundsException ex) {
        }
    }

    /**
     *
     * @param textFild
     */
    public static void numberOnly(JTextField textFild) {
        try {
            String txt = textFild.getText();
            int caretPosition = textFild.getCaretPosition();
            if (!txt.matches("^[0-9]{0,9}$")) {
                textFild.setText(txt.substring(0, caretPosition - 1) + txt.substring(caretPosition));
                textFild.setCaretPosition(caretPosition - 1);
            }
        } catch (StringIndexOutOfBoundsException ex) {
        }
    }

    /**
     *
     * @param textFild
     */
    public static void email(JTextField textFild) {
        try {
            String txt = textFild.getText();
            int caretPosition = textFild.getCaretPosition();
            if (!txt.matches("^[A-Za-z// ][^~:]*$")) {
                textFild.setText(txt.substring(0, caretPosition - 1) + txt.substring(caretPosition));
                textFild.setCaretPosition(caretPosition - 1);
            }
        } catch (StringIndexOutOfBoundsException ex) {
        }
    }

}
