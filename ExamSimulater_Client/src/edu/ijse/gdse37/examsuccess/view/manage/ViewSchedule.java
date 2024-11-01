/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.manage;

import edu.ijse.gdse37.examsuccess.model.Batch;
import edu.ijse.gdse37.examsuccess.model.Cemester;
import edu.ijse.gdse37.examsuccess.model.Exam;
import edu.ijse.gdse37.examsuccess.model.Subject;
import edu.ijse.gdse37.examsuccess.connecter.ServerConnecter;
import edu.ijse.gdse37.examsuccess.controller.BatchController;
import edu.ijse.gdse37.examsuccess.controller.SemesterController;
import edu.ijse.gdse37.examsuccess.controller.ExamController;
import edu.ijse.gdse37.examsuccess.controller.ResultController;
import edu.ijse.gdse37.examsuccess.controller.SubjectController;
import edu.ijse.gdse37.examsuccess.view.student.Add_Student_Panal;
import edu.ijse.gdse37.examsuccess.view.student.Student;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ashan Tharuka
 */
public class ViewSchedule extends javax.swing.JPanel {

    private String path;
    private ArrayList<Exam> upcomingExam;
    private String examId;
    private String paperPath;
    private String fileName;
    private String startQ;
    private String endQ;
    private String aMarks;
    private String bMarks;
    private String cMarks;
    private String wMarks;
    private String date;
    private String startTime;
    private String timeLimit;
    private String sendMail;
    private String markForOneQuestion;
    private String quizCount;
    private String paperId;
    private SimpleDateFormat sf;
    private Student student;
    private String studentId;
    private String serverDate;

    /**
     * Creates new form MainAdmin
     * @param id
     * @param student
     */
    public ViewSchedule(String id, Student student) {
        initComponents();
        setSize(990, 600);
        fillCombo();
        getpapersName();
        sf = new SimpleDateFormat("yyyy-MM-dd");
        this.student = student;
        this.studentId = id;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        batchCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cemesterCombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        scrollpane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        subjectCombo = new javax.swing.JComboBox();
        paperNameLabel = new javax.swing.JLabel();
        examIdLabel = new javax.swing.JLabel();
        paperNameText = new javax.swing.JTextField();
        examIdText = new javax.swing.JTextField();
        requestButton = new javax.swing.JLabel();

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
        jPanel1.add(batchCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 150, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Batch");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 150, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cemester");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 170, 40));

        cemesterCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cemesterComboItemStateChanged(evt);
            }
        });
        cemesterCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cemesterComboMouseClicked(evt);
            }
        });
        jPanel1.add(cemesterCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 170, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Subject");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 140, 40));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Exam Id", "Exam Name", "Exam Date", "Start Time", "Time Limit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table.setRowHeight(25);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        scrollpane.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(scrollpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 650, -1));

        subjectCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                subjectComboItemStateChanged(evt);
            }
        });
        subjectCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subjectComboMouseClicked(evt);
            }
        });
        jPanel1.add(subjectCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 140, 30));

        paperNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        paperNameLabel.setText("Paper Name");
        jPanel1.add(paperNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, 100, 30));

        examIdLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        examIdLabel.setText("Exam Id");
        jPanel1.add(examIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, 80, 30));

        paperNameText.setEditable(false);
        paperNameText.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(paperNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 150, 110, 30));

        examIdText.setEditable(false);
        examIdText.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(examIdText, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 80, 30));

        requestButton.setBackground(new java.awt.Color(171, 227, 247));
        requestButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        requestButton.setForeground(new java.awt.Color(255, 255, 255));
        requestButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        requestButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/requestButton.png"))); // NOI18N
        requestButton.setText("<html>Request <br>");
        requestButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        requestButton.setMinimumSize(new java.awt.Dimension(110, 50));
        requestButton.setPreferredSize(new java.awt.Dimension(110, 50));
        requestButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                requestButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                requestButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                requestButtonMouseExited(evt);
            }
        });
        jPanel1.add(requestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 150, 60));

        add(jPanel1);
        jPanel1.setBounds(0, 0, 990, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void batchComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchComboItemStateChanged
        getpapersName();      // TODO add your handling code here:
    }//GEN-LAST:event_batchComboItemStateChanged

    private void batchComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batchComboMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_batchComboMouseClicked

    private void cemesterComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cemesterComboItemStateChanged
        getpapersName();         // TODO add your handling code here:
    }//GEN-LAST:event_cemesterComboItemStateChanged

    private void cemesterComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cemesterComboMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cemesterComboMouseClicked

    private void subjectComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_subjectComboItemStateChanged
        getpapersName();
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectComboItemStateChanged

    private void subjectComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectComboMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_subjectComboMouseClicked

    private void requestButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_requestButtonMouseClicked
        if (examIdText.getText() == null || examIdText.getText().isEmpty() || paperNameText.getText().isEmpty() || paperNameText.getText() == null) {
            JOptionPane.showMessageDialog(null, "Select paper");
        } else {
            String userDate1 = null;
            String userTime1 = null;
            try {
                ExamController ec = ServerConnecter.getServerConnecter().getExamController();
                serverDate = ec.getServerDate();

                if (serverDate == null) {

                } else {
                    String[] split = serverDate.split("#");
                    userDate1 = split[0];

                    Date userDate = new Date();
                    Date userTime = new Date();

                    userDate = sf.parse(userDate1);

                    //////////////////////////////////////////////
                    boolean checkDate = checkDate(userDate);
                    if (checkDate == false) {
                        JOptionPane.showMessageDialog(null, "Exam has More Days");
                    } else {

                        String[] splits = path.split("/");
                        String batch = splits[3];
                        String cemester = splits[4];
                        String subject = splits[5];

                        ///////////////////////////////////////
                        String resultPath = batch + "/" + cemester + "/" + subject + "/" + fileName.replace(".txt", "") + "/" + userDate1;
                        System.out.println("Result Path: " + resultPath);

                        ResultController rc = ServerConnecter.getServerConnecter().getResultController();
                        boolean IsDoExam = rc.IsDoExam(studentId, resultPath);

                        if (IsDoExam) {
                            JOptionPane.showMessageDialog(null, "Warning!!");
                        } else {
                            BeginExam pe = new BeginExam();
                            System.out.println("Schedule FileName: " + fileName);
                            pe.startFinalExam(path, fileName, startQ, endQ, paperNameText.getText(), studentId, startTime, timeLimit, examId, paperId);
                            student.clearPanel();
                            pe.setVisible(true);
                        }
                    }
                }

            } catch (NotBoundException | MalformedURLException | RemoteException | ParseException ex) {
                Logger.getLogger(ViewSchedule.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ViewSchedule.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_requestButtonMouseClicked

    private void requestButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_requestButtonMouseEntered
        requestButton.setForeground(Color.black);
    }//GEN-LAST:event_requestButtonMouseEntered

    private void requestButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_requestButtonMouseExited
        requestButton.setForeground(Color.WHITE);          // TODO add your handling code here:
    }//GEN-LAST:event_requestButtonMouseExited

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int index = table.getRowCount();
        if (index < 1) {
            JOptionPane.showMessageDialog(null, "No Data");
        } else {
            try {
                int selectedRow = table.getSelectedRow();
                this.examId = upcomingExam.get(selectedRow).getExamId();
                this.paperPath = upcomingExam.get(selectedRow).getPath();
                this.fileName = upcomingExam.get(selectedRow).getFileName();
                this.startQ = upcomingExam.get(selectedRow).getStartQ();
                System.out.println("Schedule startQ: " + startQ);
                this.endQ = upcomingExam.get(selectedRow).getEndQ();
                this.aMarks = upcomingExam.get(selectedRow).getaMarks();
                this.bMarks = upcomingExam.get(selectedRow).getbMarks();
                this.cMarks = upcomingExam.get(selectedRow).getcMarks();
                this.wMarks = upcomingExam.get(selectedRow).getwMarks();
                this.date = upcomingExam.get(selectedRow).getDate();
                this.startTime = upcomingExam.get(selectedRow).getStartTime();
                this.timeLimit = upcomingExam.get(selectedRow).getTimeLimit();
                this.sendMail = upcomingExam.get(selectedRow).getSendMail();
                this.markForOneQuestion = upcomingExam.get(selectedRow).getMarkForOneQuestion();
                this.quizCount = upcomingExam.get(selectedRow).getQuizCount();
                this.paperId = upcomingExam.get(selectedRow).getPaperId();

                examIdText.setText(examId);
                paperNameText.setText(fileName.replace(".txt", ""));
            } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            }

        }

    }//GEN-LAST:event_tableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox batchCombo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cemesterCombo;
    private javax.swing.JLabel examIdLabel;
    private javax.swing.JTextField examIdText;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel paperNameLabel;
    private javax.swing.JTextField paperNameText;
    private javax.swing.JLabel requestButton;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JComboBox subjectCombo;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    public void fillCombo() {

        try {
            BatchController bc = ServerConnecter.getServerConnecter().getBatchController();
            SemesterController cc = ServerConnecter.getServerConnecter().getCemesterController();
            SubjectController sc = ServerConnecter.getServerConnecter().getSubjectController();

            ////batch combo
            ArrayList<Batch> allBatch = bc.getAllBatch();
            batchCombo.removeAll();
            for (Batch b : allBatch) {
                batchCombo.addItem(b.getBatchName());
            }

            ////Cemster Combo
            ArrayList<Cemester> allCemester = cc.getAllCemester();
            cemesterCombo.removeAll();
            for (Cemester c : allCemester) {
                cemesterCombo.addItem(c.getCemesterName());
            }

            /////Subject Combo
            ArrayList<Subject> allSubject = sc.getAllSubject();
            subjectCombo.removeAll();
            for (Subject s : allSubject) {
                subjectCombo.addItem(s.getSubjectName());
            }

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Add_Student_Panal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Add_Student_Panal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     */
    public void getpapersName() {
        try {
            String batch = batchCombo.getSelectedItem().toString();
            String cemester = cemesterCombo.getSelectedItem().toString();
            String subject = subjectCombo.getSelectedItem().toString();

            path = "./Database/Papers/" + batch + "/" + cemester + "/" + subject;

            ExamController ec = ServerConnecter.getServerConnecter().getExamController();
            upcomingExam = ec.getUpcomingExam(path);

            DefaultTableModel dtm = new DefaultTableModel();
            dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            table.setRowHeight(25);

            for (Exam e : upcomingExam) {
                Object[] row = {e.getExamId(), e.getFileName().replace(".txt", ""), e.getDate(), e.getStartTime().replace("-", ":"), e.getTimeLimit().replace("-", ":")};
                dtm.addRow(row);
            }

        } catch (NullPointerException ex) {
        } catch (NotBoundException | FileNotFoundException | ParseException ex) {
            Logger.getLogger(ViewSchedule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ViewSchedule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewSchedule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViewSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param userDate
     * @return
     */
    public boolean checkDate(Date userDate) {
        boolean ans = false;
        try {

            Date examDate = new Date();

            examDate = sf.parse(date);

            if (examDate.after(userDate)) {
                ans = false;
            } else if (examDate.equals(userDate)) {
                ans = true;
            } else {
                ans = true;
            }

        } catch (ParseException ex) {
            Logger.getLogger(ViewSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ans;
    }

    /**
     *
     * @param message
     */
    public void updateMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}

