/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.cemester;

import edu.ijse.gdse37.examsuccess.model.Cemester;
import edu.ijse.gdse37.examsuccess.connecter.ServerConnecter;
import edu.ijse.gdse37.examsuccess.controller.SemesterController;
import edu.ijse.gdse37.examsuccess.view.admin.Delete_Admin_Panal;
import edu.ijse.gdse37.examsuccess.view.other.Relese;
import java.awt.Color;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ashan Tharuka
 */
public class Delete_Cemester_Panal extends javax.swing.JPanel {

    /**
     * Creates new form AddQ_Panel_Form
     */
    private String code;
    private Relese relese;

    public Delete_Cemester_Panal(Relese relese) {
        initComponents();
        setSize(630, 510);
        this.relese = relese;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        matchLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        cemesterText = new javax.swing.JTextField();
        deleteButton = new javax.swing.JPanel();
        addLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(630, 510));
        setPreferredSize(new java.awt.Dimension(630, 510));
        setLayout(null);

        matchLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(matchLabel);
        matchLabel.setBounds(414, 446, 176, 44);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Delete Cemester");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(80, 40, 300, 55);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("ID No :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 110, 93, 42);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Cemester Name:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(80, 180, 131, 42);

        idText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextActionPerformed(evt);
            }
        });
        jPanel1.add(idText);
        idText.setBounds(240, 110, 163, 37);
        jPanel1.add(cemesterText);
        cemesterText.setBounds(240, 180, 163, 37);

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButtonMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteButtonMouseReleased(evt);
            }
        });
        deleteButton.setLayout(null);

        addLabel.setFont(new java.awt.Font("Monotype.com", 1, 18)); // NOI18N
        addLabel.setText("Delete");
        deleteButton.add(addLabel);
        addLabel.setBounds(70, 0, 80, 40);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/Delete_Icon.png"))); // NOI18N
        deleteButton.add(jLabel16);
        jLabel16.setBounds(30, 0, 40, 40);

        jPanel1.add(deleteButton);
        deleteButton.setBounds(240, 250, 160, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/courseLine.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(0, 0, 40, 560);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 630, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void idTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextActionPerformed
        String code = idText.getText();
        relese.code = code;
        try {
            SemesterController semesterController = ServerConnecter.getServerConnecter().getCemesterController();
            if (this.code != code) {
                semesterController.releaseSemester(this.code);
            } else {
                this.code = code;
            }

            Cemester cem = semesterController.SearchCemester("id", code);
            if (cem == null) {
                JOptionPane.showMessageDialog(null, "Not Match");
            } else {
                if (semesterController.reserveSemester(code)) {
                    cemesterText.setText(cem.getCemesterName());
                } else {
                    JOptionPane.showMessageDialog(this, code + " is reserved");
                }

            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Delete_Cemester_Panal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Delete_Cemester_Panal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_idTextActionPerformed

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        try {
            String code = idText.getText();
            relese.code = code;
            try {
                SemesterController semesterController = ServerConnecter.getServerConnecter().getCemesterController();
                boolean isTrue = semesterController.deleteCemester(code);
                if (isTrue) {
                    idText.setText(null);
                    cemesterText.setText(null);
                    JOptionPane.showMessageDialog(null, "Delete Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Delete Fail");
                }
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(Delete_Cemester_Panal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Delete_Cemester_Panal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                SemesterController semesterController = ServerConnecter.getServerConnecter().getCemesterController();
                semesterController.releaseSemester(this.code);
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(Delete_Admin_Panal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void deleteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseEntered
        deleteButton.setBackground(Color.yellow);// TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonMouseEntered

    private void deleteButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseExited
        deleteButton.setBackground(Color.white);        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonMouseExited

    private void deleteButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addLabel;
    private javax.swing.JTextField cemesterText;
    private javax.swing.JPanel deleteButton;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel matchLabel;
    // End of variables declaration//GEN-END:variables
}