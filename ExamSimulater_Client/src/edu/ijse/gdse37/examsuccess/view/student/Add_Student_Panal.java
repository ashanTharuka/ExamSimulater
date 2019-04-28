/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.student;

import edu.ijse.gdse37.examsuccess.model.Batch;
import edu.ijse.gdse37.examsuccess.model.Student;
import edu.ijse.gdse37.examsuccess.view.other.ImageResizer;
import edu.ijse.gdse37.examsuccess.connecter.ServerConnecter;
import edu.ijse.gdse37.examsuccess.controller.AdminController;
import edu.ijse.gdse37.examsuccess.controller.BatchController;
import edu.ijse.gdse37.examsuccess.controller.StudentController;
import edu.ijse.gdse37.examsuccess.view.other.Validation;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Ashan Tharuka
 */
public class Add_Student_Panal extends javax.swing.JPanel {

    private String imagePath;

    /**
     * Creates new form AddQ_Panel_Form
     */
    public Add_Student_Panal() {
        initComponents();
        setSize(770, 560);
        addButton.setVisible(false);
        w1.setVisible(false);
        w2.setVisible(false);
        imagePath = "C:\\Users\\Ashan Tharuka\\Desktop\\NetBean 8.0.2\\ExamSimulater_Server\\Database\\Student/StudentImage/default.jpg";
        photoLabel.setIcon(new ImageIcon(imagePath));

        try {
            BatchController bc = ServerConnecter.getServerConnecter().getBatchController();
            ArrayList<Batch> allBatch = bc.getAllBatch();
            batchCombo.removeAll();
            for (Batch b : allBatch) {
                batchCombo.addItem(b.getBatchName());
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Add_Student_Panal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Add_Student_Panal.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLabel1 = new javax.swing.JLabel();
        passText = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        veryPassText = new javax.swing.JPasswordField();
        emailText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        numberText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        w1 = new javax.swing.JLabel();
        w2 = new javax.swing.JLabel();
        addButton = new javax.swing.JPanel();
        addLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        batchCombo = new javax.swing.JComboBox();
        parentEmailText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        addPanel = new javax.swing.JPanel();
        photoLabel = new javax.swing.JLabel();
        attatchButton = new javax.swing.JLabel();
        pathLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(770, 560));
        setPreferredSize(new java.awt.Dimension(770, 560));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Password :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(80, 388, 156, 42);
        jPanel1.add(passText);
        passText.setBounds(246, 396, 163, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Verify Password :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(80, 448, 156, 35);

        veryPassText.setMinimumSize(new java.awt.Dimension(163, 30));
        veryPassText.setPreferredSize(new java.awt.Dimension(163, 30));
        veryPassText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                veryPassTextKeyReleased(evt);
            }
        });
        jPanel1.add(veryPassText);
        veryPassText.setBounds(246, 452, 163, 30);

        emailText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailTextKeyReleased(evt);
            }
        });
        jPanel1.add(emailText);
        emailText.setBounds(244, 292, 163, 30);

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
        jPanel1.add(nameText);
        nameText.setBounds(244, 132, 163, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Name :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 128, 138, 35);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Student Email :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(80, 284, 105, 42);

        idText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idTextKeyReleased(evt);
            }
        });
        jPanel1.add(idText);
        idText.setBounds(244, 72, 163, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nic No :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 72, 93, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Batch :");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(80, 182, 49, 42);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Telephone Number :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(80, 241, 141, 17);

        numberText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numberTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numberTextKeyReleased(evt);
            }
        });
        jPanel1.add(numberText);
        numberText.setBounds(244, 236, 163, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Add Student");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(47, 10, 300, 55);

        w1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/w3Warning.png"))); // NOI18N
        jPanel1.add(w1);
        w1.setBounds(425, 82, 40, 20);

        w2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/w3Warning.png"))); // NOI18N
        jPanel1.add(w2);
        w2.setBounds(420, 460, 30, 20);

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

        jPanel1.add(addButton);
        addButton.setBounds(246, 501, 166, 40);

        jPanel1.add(batchCombo);
        batchCombo.setBounds(244, 182, 163, 30);

        parentEmailText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                parentEmailTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                parentEmailTextKeyReleased(evt);
            }
        });
        jPanel1.add(parentEmailText);
        parentEmailText.setBounds(246, 342, 163, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Parent Email :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(80, 334, 95, 42);

        addPanel.setBackground(new java.awt.Color(255, 255, 255));
        addPanel.setLayout(null);

        photoLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addPanel.add(photoLabel);
        photoLabel.setBounds(46, 34, 123, 140);

        attatchButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        attatchButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        attatchButton.setText("Attach");
        attatchButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        attatchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attatchButtonMouseClicked(evt);
            }
        });
        addPanel.add(attatchButton);
        attatchButton.setBounds(46, 181, 123, 40);
        addPanel.add(pathLabel);
        pathLabel.setBounds(130, 121, 0, 26);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Attach Student Photo");
        addPanel.add(jLabel12);
        jLabel12.setBounds(46, 12, 123, 14);

        jPanel1.add(addPanel);
        addPanel.setBounds(480, 70, 260, 230);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 780, 580);
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

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed

    }//GEN-LAST:event_nameTextActionPerformed

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked

        String id = idText.getText();
        String name = nameText.getText();
        String batch = batchCombo.getSelectedItem().toString();
        String email = emailText.getText();
        String parentEmail = parentEmailText.getText();
        String number = numberText.getText();
        char[] password = passText.getPassword();
        String pass = String.valueOf(password);

        if (imagePath == null) {
            System.out.println("image null");
            imagePath = "C:\\Users\\Ashan Tharuka\\Desktop\\NetBean 8.0.2\\ExamSimulater_Server\\Database\\Student\\StudentImage\\default.jpg";
        }

        Student student = new Student(id, name, batch, email, number, pass, parentEmail, imagePath);
        try {
            StudentController sc = ServerConnecter.getServerConnecter().getStudentController();
            boolean isTrue = sc.addStudent(student);
            if (isTrue) {
                imagePath = "C:\\Users\\Ashan Tharuka\\Desktop\\NetBean 8.0.2\\ExamSimulater_Server\\Database\\Student/StudentImage/default.jpg";
                nameText.setText(null);
                idText.setText(null);
                emailText.setText(null);
                numberText.setText(null);
                passText.setText(null);
                veryPassText.setText(null);
                parentEmailText.setText(null);
                w2.setVisible(false);
                JOptionPane.showMessageDialog(null, "Student Added Successfully");
                
                addButton.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Student Added Fail");
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Add_Student_Panal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Add_Student_Panal.class.getName()).log(Level.SEVERE, null, ex);
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

    private void nameTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextKeyPressed
        Validation.name(nameText);
    }//GEN-LAST:event_nameTextKeyPressed

    private void idTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idTextKeyReleased
        Validation.validationText(idText);
        String id = idText.getText();
        try {
            StudentController sc = ServerConnecter.getServerConnecter().getStudentController();
            AdminController ac = ServerConnecter.getServerConnecter().getAdminController();
            boolean adminId = ac.searchId(id);
            boolean searchId = sc.searchId(id);
            if (searchId || adminId) {
                w1.setVisible(true);
            } else {
                w1.setVisible(false);
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Add_Student_Panal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Add_Student_Panal.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_idTextKeyReleased

    private void attatchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attatchButtonMouseClicked
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String fileName = f.getAbsolutePath();
            pathLabel.setText(fileName);

            ImageResizer imageResizer = new ImageResizer();
            imagePath = imageResizer.setImage(fileName, 123, 140, f.getName());

            photoLabel.setIcon(new ImageIcon(imagePath));
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_attatchButtonMouseClicked

    private void nameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextKeyReleased
        Validation.name(nameText);
    }//GEN-LAST:event_nameTextKeyReleased

    private void idTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idTextKeyPressed
        Validation.validationText(idText);
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
        Validation.email(emailText);
    }//GEN-LAST:event_emailTextKeyReleased

    private void parentEmailTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_parentEmailTextKeyPressed
        Validation.email(parentEmailText);
    }//GEN-LAST:event_parentEmailTextKeyPressed

    private void parentEmailTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_parentEmailTextKeyReleased
        Validation.email(parentEmailText);        // TODO add your handling code here:
    }//GEN-LAST:event_parentEmailTextKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addButton;
    private javax.swing.JLabel addLabel;
    private javax.swing.JPanel addPanel;
    private javax.swing.JLabel attatchButton;
    private javax.swing.JComboBox batchCombo;
    private javax.swing.JTextField emailText;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField numberText;
    private javax.swing.JTextField parentEmailText;
    private javax.swing.JPasswordField passText;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JPasswordField veryPassText;
    private javax.swing.JLabel w1;
    private javax.swing.JLabel w2;
    // End of variables declaration//GEN-END:variables
}
