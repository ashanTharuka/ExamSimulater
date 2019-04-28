/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.manage;

import com.sun.java.swing.plaf.motif.MotifBorders;
import edu.ijse.gdse37.examsuccess.model.Batch;
import edu.ijse.gdse37.examsuccess.model.Student;
import edu.ijse.gdse37.examsuccess.connecter.ServerConnecter;
import edu.ijse.gdse37.examsuccess.controller.AdminController;
import edu.ijse.gdse37.examsuccess.controller.BatchController;
import edu.ijse.gdse37.examsuccess.controller.LoginController;
import edu.ijse.gdse37.examsuccess.controller.StudentController;
import java.awt.Color;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ashan Tharuka
 */
public class Email extends javax.swing.JPanel {

    private ArrayList<Student> list;
    private String type;

    /**
     * Creates new form MainAdmin
     */
    public Email() {
        initComponents();
        setSize(950, 490);
        comboLoard();
        list = new ArrayList<>();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        batchCombo = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msgText = new javax.swing.JTextArea();
        subjectText = new javax.swing.JTextField();
        clearButton = new javax.swing.JLabel();
        sendButton = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 450));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        batchCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                batchComboItemStateChanged(evt);
            }
        });
        batchCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                batchComboMouseClicked(evt);
            }
        });
        jPanel1.add(batchCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 120, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Batch");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 120, 40));

        msgText.setColumns(20);
        msgText.setRows(5);
        jScrollPane1.setViewportView(msgText);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 580, 200));
        jPanel1.add(subjectText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 580, 40));

        clearButton.setBackground(new java.awt.Color(102, 102, 102));
        clearButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clearButton.setText("Clear All");
        clearButton.setOpaque(true);
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearButtonMouseExited(evt);
            }
        });
        jPanel1.add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 120, 30));

        sendButton.setBackground(new java.awt.Color(171, 227, 247));
        sendButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        sendButton.setForeground(new java.awt.Color(255, 255, 255));
        sendButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/sendMailPic.png"))); // NOI18N
        sendButton.setText("<html> <br>");
        sendButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sendButton.setMinimumSize(new java.awt.Dimension(110, 50));
        sendButton.setPreferredSize(new java.awt.Dimension(110, 50));
        sendButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sendButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sendButtonMouseExited(evt);
            }
        });
        jPanel1.add(sendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 320, 50));

        add(jPanel1);
        jPanel1.setBounds(0, 0, 950, 490);
    }// </editor-fold>//GEN-END:initComponents

    private void batchComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchComboItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_batchComboItemStateChanged

    private void batchComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batchComboMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_batchComboMouseClicked

    private void clearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseClicked
        subjectText.setText(null);
        msgText.setText(null);
    }//GEN-LAST:event_clearButtonMouseClicked

    private void clearButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseEntered
        clearButton.setForeground(new Color(102, 255, 255));
    }//GEN-LAST:event_clearButtonMouseEntered

    private void clearButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseExited
        clearButton.setForeground(Color.white);
    }//GEN-LAST:event_clearButtonMouseExited

    private void sendButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendButtonMouseClicked
        if (subjectText.getText() == null || subjectText.getText().isEmpty() || msgText.getText().isEmpty() || msgText.getText() == null) {
            JOptionPane.showMessageDialog(null, "Emty Data !!!", "Warning", 2);
        } else {
            try {
                AdminController ac = ServerConnecter.getServerConnecter().getAdminController();
                LoginController lc = ServerConnecter.getServerConnecter().getLoginController();
                StudentController sc = ServerConnecter.getServerConnecter().getStudentController();
                String batch = batchCombo.getSelectedItem().toString();

                list = sc.getAllEmailofBatch(batch);

                String[] instituteEmail = ac.getInstitueEmailPassword().split(":");
                boolean isTrue = lc.generateAndSendEmail(list, subjectText.getText(), msgText.getText(), instituteEmail[0], instituteEmail[1]);
                if (isTrue) {
                    JOptionPane.showMessageDialog(null, " Email Sent Successfully");
                    subjectText.setText(null);
                    msgText.setText(null);

                } else {
                    JOptionPane.showMessageDialog(null, " Email Send Fail");
                }

            } catch (MalformedURLException | NullPointerException ex) {
                Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | NotBoundException ex) {
                Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
                JOptionPane.showMessageDialog(null, "Couldn't Connect internet", "Warning", 2);
            }
        }
    }//GEN-LAST:event_sendButtonMouseClicked

    private void sendButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendButtonMouseEntered
        sendButton.setBorder(new MotifBorders.BevelBorder(true, Color.BLUE, Color.BLUE));
    }//GEN-LAST:event_sendButtonMouseEntered

    private void sendButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendButtonMouseExited
        sendButton.setBorder(null);
    }//GEN-LAST:event_sendButtonMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox batchCombo;
    private javax.swing.JLabel clearButton;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea msgText;
    private javax.swing.JLabel sendButton;
    private javax.swing.JTextField subjectText;
    // End of variables declaration//GEN-END:variables

    /**
     *get all email of relavent batch
     */
    public void getEmails() {
        try {
            type = batchCombo.getSelectedItem().toString();
            try {
                StudentController sc = ServerConnecter.getServerConnecter().getStudentController();

                list = sc.getAllEmailofBatch(type);
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (NullPointerException ex) {
        }
    }

    /**
     *lord data to combo
     */
    public void comboLoard() {
        try {
            BatchController bc = ServerConnecter.getServerConnecter().getBatchController();

            ////batch combo
            ArrayList<Batch> allBatch = bc.getAllBatch();
            batchCombo.removeAll();
            for (Batch b : allBatch) {
                batchCombo.addItem(b.getBatchName());
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}