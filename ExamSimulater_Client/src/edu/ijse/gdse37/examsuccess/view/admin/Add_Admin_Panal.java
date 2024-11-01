/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.admin;

import edu.ijse.gdse37.examsuccess.model.Admin;
import edu.ijse.gdse37.examsuccess.connecter.ServerConnecter;
import edu.ijse.gdse37.examsuccess.controller.AdminController;
import edu.ijse.gdse37.examsuccess.controller.StudentController;
import edu.ijse.gdse37.examsuccess.view.other.Validation;
import edu.ijse.gdse37.examsuccess.view.student.Add_Student_Panal;
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
public class Add_Admin_Panal extends javax.swing.JPanel {

    /**
     * Creates new form AddQ_Panel_Form
     */
    public Add_Admin_Panal() {
        initComponents();
        setSize(790, 600);
        addButton.setVisible(false);
        w2.setVisible(false);
        w3.setVisible(false);
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
        jPanel2 = new javax.swing.JPanel();
        veryPassText = new javax.swing.JPasswordField();
        passText = new javax.swing.JPasswordField();
        emailText = new javax.swing.JTextField();
        numberText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        addButton = new javax.swing.JPanel();
        addLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        w2 = new javax.swing.JLabel();
        w3 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(827, 560));
        setLayout(null);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        veryPassText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                veryPassTextKeyReleased(evt);
            }
        });
        jPanel2.add(veryPassText, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 165, 30));
        jPanel2.add(passText, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 163, 30));

        emailText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextActionPerformed(evt);
            }
        });
        emailText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailTextKeyReleased(evt);
            }
        });
        jPanel2.add(emailText, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 163, 30));

        numberText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numberTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numberTextKeyReleased(evt);
            }
        });
        jPanel2.add(numberText, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 163, 30));

        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });
        nameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTextKeyReleased(evt);
            }
        });
        jPanel2.add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 163, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Name :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 175, 138, 35));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Telephone Number :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("E mail :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 141, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Password :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 148, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Verify Password :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 156, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nic No :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 122, 93, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Add New Admin");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 24, 300, 55));

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addButtonMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addButtonMouseReleased(evt);
            }
        });
        addButton.setLayout(null);

        addLabel.setFont(new java.awt.Font("Monotype.com", 1, 18)); // NOI18N
        addLabel.setText("Add");
        addButton.add(addLabel);
        addLabel.setBounds(70, 0, 50, 40);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/plus.png"))); // NOI18N
        addButton.add(jLabel16);
        jLabel16.setBounds(30, 0, 40, 40);

        jPanel2.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 165, 40));

        w2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/w3Warning.png"))); // NOI18N
        jPanel2.add(w2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 30, 30));

        w3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/w3Warning.png"))); // NOI18N
        jPanel2.add(w3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 30, 30));

        idText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idTextKeyReleased(evt);
            }
        });
        jPanel2.add(idText, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 163, 30));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 830, 560);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 830, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void veryPassTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_veryPassTextKeyReleased
        char[] password1 = passText.getPassword();
        char[] password2 = veryPassText.getPassword();
        String pass1 = String.valueOf(password1);
        String pass2 = String.valueOf(password2);
        if (pass1.equals(pass2)) {
            w2.setVisible(false);

            addButton.setVisible(true);

        } else {
            w2.setVisible(true);
            addButton.setVisible(false);
        }
    }//GEN-LAST:event_veryPassTextKeyReleased

    private void emailTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextActionPerformed

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked

        String name = nameText.getText();
        String id = idText.getText();
        String number = numberText.getText();
        char[] password = veryPassText.getPassword();
        String pass = String.valueOf(password);
        String email = emailText.getText();

        Admin admin = new Admin(id, name, number, pass, email);

        try {
            AdminController ac = ServerConnecter.getServerConnecter().getAdminController();
            boolean isTrue = ac.addAdmin(admin);
            if (isTrue) {
                nameText.setText(null);
                idText.setText(null);
                numberText.setText(null);
                passText.setText(null);
                veryPassText.setText(null);
                emailText.setText(null);
                w2.setVisible(false);
                JOptionPane.showMessageDialog(null, " Admin Added Successfully");
                addButton.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, " Admin Added Fail");
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Add_Admin_Panal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Add_Admin_Panal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addButtonMouseClicked

    private void addButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseEntered
        addButton.setBackground(Color.yellow);// TODO add your handling code here:
    }//GEN-LAST:event_addButtonMouseEntered

    private void addButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseExited
        addButton.setBackground(Color.white);        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonMouseExited

    private void addButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonMouseReleased

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed

    }//GEN-LAST:event_nameTextActionPerformed

    private void idTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idTextKeyReleased
        Validation.validationText(idText);
        String id = idText.getText();
        try {
            StudentController sc = ServerConnecter.getServerConnecter().getStudentController();
            AdminController ac = ServerConnecter.getServerConnecter().getAdminController();
            boolean adminId = ac.searchId(id);
            boolean searchId = sc.searchId(id);
            if (searchId || adminId) {
                w3.setVisible(true);
            } else {
                w3.setVisible(false);
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Add_Student_Panal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Add_Student_Panal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_idTextKeyReleased

    private void nameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextKeyReleased
        Validation.name(nameText);
    }//GEN-LAST:event_nameTextKeyReleased

    private void nameTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextKeyPressed
        Validation.name(nameText);
    }//GEN-LAST:event_nameTextKeyPressed

    private void idTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idTextKeyPressed
        Validation.validationText(idText);        // TODO add your handling code here:
    }//GEN-LAST:event_idTextKeyPressed

    private void numberTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberTextKeyPressed
        Validation.phoneNumber(numberText);
    }//GEN-LAST:event_numberTextKeyPressed

    private void numberTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberTextKeyReleased
        Validation.phoneNumber(numberText);        // TODO add your handling code here:
    }//GEN-LAST:event_numberTextKeyReleased

    private void emailTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTextKeyPressed
        Validation.email(emailText);
    }//GEN-LAST:event_emailTextKeyPressed

    private void emailTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTextKeyReleased
        Validation.email(emailText);        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addButton;
    private javax.swing.JLabel addLabel;
    private javax.swing.JTextField emailText;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField numberText;
    private javax.swing.JPasswordField passText;
    private javax.swing.JPasswordField veryPassText;
    private javax.swing.JLabel w2;
    private javax.swing.JLabel w3;
    // End of variables declaration//GEN-END:variables
}
