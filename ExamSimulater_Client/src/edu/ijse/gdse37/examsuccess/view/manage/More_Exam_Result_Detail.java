/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.manage;

import edu.ijse.gdse37.examsuccess.connecter.ServerConnecter;
import edu.ijse.gdse37.examsuccess.controller.PracticeExamController;
import edu.ijse.gdse37.examsuccess.model.Question;
import java.awt.Color;
import java.awt.Frame;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ashan Tharuka
 */
public class More_Exam_Result_Detail extends javax.swing.JFrame {

    private int xMouse;
    private int yMouse;
    private ArrayList<String> result;
    private String path;
    private String fileName;
    private HashMap<String, String> studentAnswerList;
    private int startQ;
    private int endQ;

    /**
     * Creates new form More_Exam_Result_Detail
     * @param correctAnswers
     * @param resultList
     * @param studentAnswerList
     * @param startQ
     * @param path
     * @param fileName
     * @param endQ
     */
    public More_Exam_Result_Detail(ArrayList<String> correctAnswers, HashMap<String, String> studentAnswerList, String path, String fileName, int startQ, int endQ, ArrayList<String> resultList) {
        setDefaultCloseOperation(2);
        initComponents();
        setSize(797, 711);
        setLocationRelativeTo(null);
        result = null;
        this.studentAnswerList = null;
        result = new ArrayList<>();
        this.path = path;
        this.fileName = fileName;
        this.studentAnswerList = studentAnswerList;
        this.startQ = startQ;
        this.endQ = endQ;
        this.result = resultList;
        System.out.println("FileNAme: " + fileName);
        System.out.println("More Detail Path : " + path);
        System.out.println("startQ: " + startQ);

        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();

        dtm.setRowCount(0);
        int s = startQ;
        for (int i = 0; i < correctAnswers.size(); i++) {

            if (studentAnswerList.containsKey(Integer.toString(i + startQ))) {
                if (studentAnswerList.get(Integer.toString(i + startQ)).equals(correctAnswers.get(i))) {

                    String ans1 = studentAnswerList.get(Integer.toString(i + startQ));
                    String ans2 = ans1.replace(":", "  ");
                    String ans3 = ans2.replace("*", "");
                    String stAns = ans3.trim();

                    String cor1 = correctAnswers.get(i);
                    String cor2 = cor1.replace(":", "  ");
                    String cor3 = cor2.replace("*", "");
                    String corAns = cor3.trim();

                    Object[] row = {"" + (i + startQ), stAns, corAns, result.get(i)};
                    dtm.addRow(row);
                } else if (studentAnswerList.get(Integer.toString(i + startQ)).equals("*:*:*:*")) {

                    String cor1 = correctAnswers.get(i);
                    String cor2 = cor1.replace(":", "  ");
                    String cor3 = cor2.replace("*", "");
                    String corAns = cor3.trim();

                    Object[] row = {"" + (i + startQ), "", corAns, result.get(i)};
                    dtm.addRow(row);
                } else {

                    String ans1 = studentAnswerList.get(Integer.toString(i + startQ));
                    String ans2 = ans1.replace(":", "  ");
                    String ans3 = ans2.replace("*", "");
                    String stAns = ans3.trim();

                    String cor1 = correctAnswers.get(i);
                    String cor2 = cor1.replace(":", "  ");
                    String cor3 = cor2.replace("*", "");
                    String corAns = cor3.trim();

                    Object[] row = {"" + (i + startQ), stAns, corAns, result.get(i)};
                    dtm.addRow(row);
                }
            } else {
                String cor1 = correctAnswers.get(i);
                String cor2 = cor1.replace(":", "  ");
                String cor3 = cor2.replace("*", "");
                String corAns = cor3.trim();

                Object[] row = {"" + (i + startQ), "", corAns, result.get(i)};
                dtm.addRow(row);
            }

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
        getReportButton = new javax.swing.JLabel();
        minimizePanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        closePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainQText = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        aText = new javax.swing.JTextField();
        aa = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        bb = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cc = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        dd = new javax.swing.JRadioButton();
        dText = new javax.swing.JTextField();
        cText = new javax.swing.JTextField();
        bText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        getReportButton.setBackground(new java.awt.Color(102, 102, 102));
        getReportButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getReportButton.setForeground(new java.awt.Color(255, 255, 255));
        getReportButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getReportButton.setText("Get Answer Report");
        getReportButton.setOpaque(true);
        getReportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getReportButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                getReportButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                getReportButtonMouseExited(evt);
            }
        });
        jPanel1.add(getReportButton);
        getReportButton.setBounds(200, 640, 480, 40);

        minimizePanel.setBackground(new java.awt.Color(255, 255, 255));
        minimizePanel.setPreferredSize(new java.awt.Dimension(40, 40));
        minimizePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizePanelMouseExited(evt);
            }
        });
        minimizePanel.setLayout(null);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/020739-rounded-glossy-black-icon-symbols-shapes-minimize.png"))); // NOI18N
        minimizePanel.add(jLabel9);
        jLabel9.setBounds(10, 10, 20, 20);

        jPanel1.add(minimizePanel);
        minimizePanel.setBounds(690, 0, 40, 30);

        closePanel.setBackground(new java.awt.Color(255, 255, 255));
        closePanel.setForeground(new java.awt.Color(255, 255, 255));
        closePanel.setPreferredSize(new java.awt.Dimension(40, 40));
        closePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closePanelMouseExited(evt);
            }
        });
        closePanel.setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/icon-nav-close.png"))); // NOI18N
        closePanel.add(jLabel3);
        jLabel3.setBounds(10, 0, 20, 30);

        jPanel1.add(closePanel);
        closePanel.setBounds(740, 0, 40, 30);

        mainQText.setEditable(false);
        mainQText.setColumns(20);
        mainQText.setRows(5);
        mainQText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mainQTextKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(mainQText);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(140, 320, 590, 90);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Question :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 320, 90, 30);

        aText.setEditable(false);
        aText.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(aText);
        aText.setBounds(150, 430, 580, 42);

        aa.setBackground(new java.awt.Color(255, 255, 255));
        aa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aaActionPerformed(evt);
            }
        });
        jPanel1.add(aa);
        aa.setBounds(50, 430, 40, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("A :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(90, 430, 55, 42);

        bb.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(bb);
        bb.setBounds(50, 480, 40, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("B :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(90, 480, 55, 39);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("C :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(90, 530, 55, 43);

        cc.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(cc);
        cc.setBounds(50, 530, 40, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText(" D :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(90, 580, 61, 42);

        dd.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(dd);
        dd.setBounds(50, 580, 40, 40);

        dText.setEditable(false);
        dText.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(dText);
        dText.setBounds(150, 580, 580, 41);

        cText.setEditable(false);
        cText.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(cText);
        cText.setBounds(150, 530, 580, 41);

        bText.setEditable(false);
        bText.setBackground(new java.awt.Color(255, 255, 255));
        bText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTextActionPerformed(evt);
            }
        });
        jPanel1.add(bText);
        bText.setBounds(150, 480, 580, 41);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/title1.png"))); // NOI18N
        jLabel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel10MouseDragged(evt);
            }
        });
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });
        jPanel1.add(jLabel10);
        jLabel10.setBounds(-170, -10, 1110, 40);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Question Number", "Your Answer", "Correct Answer", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(25);
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(50, 40, 680, 260);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainQTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mainQTextKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainQTextKeyPressed

    private void aaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aaActionPerformed

    private void bTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bTextActionPerformed

    private void minimizePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizePanelMouseClicked
        this.setState(Frame.ICONIFIED);// TODO add your handling code here:
    }//GEN-LAST:event_minimizePanelMouseClicked

    private void minimizePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizePanelMouseEntered
        minimizePanel.setBackground(Color.pink); // TODO add your handling code here:
    }//GEN-LAST:event_minimizePanelMouseEntered

    private void minimizePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizePanelMouseExited
        minimizePanel.setBackground(Color.white);  // TODO add your handling code here:
    }//GEN-LAST:event_minimizePanelMouseExited

    private void closePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closePanelMouseClicked

        this.dispose();
    }//GEN-LAST:event_closePanelMouseClicked

    private void closePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closePanelMouseEntered
        closePanel.setBackground(Color.pink); // TODO add your handling code here:
    }//GEN-LAST:event_closePanelMouseEntered

    private void closePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closePanelMouseExited
        closePanel.setBackground(Color.white);  // TODO add your handling code here:
    }//GEN-LAST:event_closePanelMouseExited

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        System.out.println("table clicked");
        String qNumber = table.getValueAt(table.getSelectedRow(), 0).toString();
        goTo(Integer.parseInt(qNumber));
    }//GEN-LAST:event_tableMouseClicked

    private void jLabel10MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseDragged

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();           // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MousePressed

    private void getReportButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getReportButtonMouseClicked
        int i = table.getRowCount();
        if (i < 1) {
            JOptionPane.showMessageDialog(null, "No Data");
        } else {
            try {
                InputStream is = getClass().getResourceAsStream("../jasper/MoreResultReport.jrxml");
                JasperReport jr = JasperCompileManager.compileReport(is);
                JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap<String, Object>(), new JRTableModelDataSource(table.getModel()));
                JasperViewer.viewReport(jp, false);
            } catch (JRException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_getReportButtonMouseClicked

    private void getReportButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getReportButtonMouseEntered
        getReportButton.setForeground(new Color(102, 255, 255));        // TODO add your handling code here:
    }//GEN-LAST:event_getReportButtonMouseEntered

    private void getReportButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getReportButtonMouseExited
        getReportButton.setForeground(Color.white);         // TODO add your handling code here:
    }//GEN-LAST:event_getReportButtonMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(More_Exam_Result_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(More_Exam_Result_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(More_Exam_Result_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(More_Exam_Result_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aText;
    private javax.swing.JRadioButton aa;
    private javax.swing.JTextField bText;
    private javax.swing.JRadioButton bb;
    private javax.swing.JTextField cText;
    private javax.swing.JRadioButton cc;
    private javax.swing.JPanel closePanel;
    private javax.swing.JTextField dText;
    private javax.swing.JRadioButton dd;
    private javax.swing.JLabel getReportButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea mainQText;
    private javax.swing.JPanel minimizePanel;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    public void clear() {
        mainQText.setText(null);
        aText.setText(null);
        bText.setText(null);
        cText.setText(null);
        dText.setText(null);
        aa.setSelected(false);
        bb.setSelected(false);
        cc.setSelected(false);
        dd.setSelected(false);
    }

    /**
     *
     * @param qNumber
     */
    public void goTo(int qNumber) {

        clear();
        try {
            PracticeExamController pec = ServerConnecter.getServerConnecter().getPracticeExamController();
            Question q = pec.SearchQuestion("Q", Integer.toString(qNumber), path, fileName + ".txt");
            if (q == null) {

            } else {
                ////////////set data//////////////

                mainQText.setText(q.getMainQ().replace("අ", "\n"));
                aText.setText(q.getQ1());
                bText.setText(q.getQ2());
                cText.setText(q.getQ3());
                dText.setText(q.getQ4());
                ///////////////setb Ans///////////////////////
                String a = q.getQa();
                String b = q.getQb();
                String c = q.getQc();
                String d = q.getQd();

                setMyAnswers(qNumber);
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
        } catch (IOException ex) {
            Logger.getLogger(ManageQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param qNumber
     */
    public void setMyAnswers(int qNumber) {
        if (studentAnswerList.containsKey(Integer.toString(qNumber))) {
            String[] answer = studentAnswerList.get(Integer.toString(qNumber)).split(":");

            if (answer[0].equals("A")) {
                aa.setSelected(true);
            } else {

            }

            if (answer[1].equals("B")) {
                bb.setSelected(true);
            } else {

            }
            if (answer[2].equals("C")) {
                cc.setSelected(true);
            } else {

            }
            if (answer[3].equals("D")) {
                dd.setSelected(true);
            } else {

            }
        }
    }

}
