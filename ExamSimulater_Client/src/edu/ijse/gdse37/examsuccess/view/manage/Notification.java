/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.manage;

import com.sun.java.swing.plaf.motif.MotifBorders;
import edu.ijse.gdse37.examsuccess.connecter.ServerConnecter;
import edu.ijse.gdse37.examsuccess.controller.LoginController;
import java.awt.Color;
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
public class Notification extends javax.swing.JPanel {

    /**
     * Creates new form MainAdmin
     */
    public Notification() {
        initComponents();
        setSize(950, 490);

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
        sendButton = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        setMinimumSize(new java.awt.Dimension(800, 450));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sendButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sendButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/sendButonPic.png"))); // NOI18N
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
        jPanel1.add(sendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 320, 50));

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 580, 260));

        add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 450);
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendButtonMouseClicked
        String s = textArea.getText();
        if (s.isEmpty() || s == null) {
            JOptionPane.showMessageDialog(null, "Emty Data!!!", "Warning", 2);
        } else {
            try {
                LoginController lc = ServerConnecter.getServerConnecter().getLoginController();
                lc.sendMessage(s);
                textArea.setText(null);
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_sendButtonMouseClicked

    private void sendButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendButtonMouseEntered
        sendButton.setBorder(new MotifBorders.BevelBorder(true, Color.BLUE, Color.BLUE));        // TODO add your handling code here:
    }//GEN-LAST:event_sendButtonMouseEntered

    private void sendButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendButtonMouseExited
        sendButton.setBorder(null);        // TODO add your handling code here:
    }//GEN-LAST:event_sendButtonMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel sendButton;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
