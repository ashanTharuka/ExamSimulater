/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.manage;

import com.sun.java.swing.plaf.motif.MotifBorders;
import edu.ijse.gdse37.examsuccess.model.Batch;
import edu.ijse.gdse37.examsuccess.model.Cemester;
import edu.ijse.gdse37.examsuccess.model.Subject;
import edu.ijse.gdse37.examsuccess.connecter.ServerConnecter;
import edu.ijse.gdse37.examsuccess.controller.BatchController;
import edu.ijse.gdse37.examsuccess.controller.SemesterController;
import edu.ijse.gdse37.examsuccess.controller.QuestionController;
import edu.ijse.gdse37.examsuccess.controller.ResultController;
import edu.ijse.gdse37.examsuccess.controller.StudentController;
import edu.ijse.gdse37.examsuccess.controller.SubjectController;
import edu.ijse.gdse37.examsuccess.model.Result;
import edu.ijse.gdse37.examsuccess.model.Student;
import edu.ijse.gdse37.examsuccess.view.student.Add_Student_Panal;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
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
public class ViewStudentResult extends javax.swing.JPanel {

    private SimpleDateFormat sf;
    private String studentId;
    private String batchPath;
    private boolean me;
    private boolean all;
    private boolean high;
    private boolean low;
    private String path;
    private String date;
    private String batch;
    private String subject;
    private String cemester;
    private String fileName;
    private String grade;
    private String marks;
    private int startQ;
    private int endQ;
    private int wrongAns;
    private int correctAns;
    private ArrayList<Result> searchAllStudentResult;
    private ArrayList<String> correctAnswers;
    private ArrayList<String> resultList;
    private Result result;
    private ArrayList<Integer> marksList;

    /**
     * Creates new form MainAdmin
     *
     * @param id
     */
    public ViewStudentResult(String id) {
        initComponents();
        setSize(990, 600);
        fillCombo();
        getpapersName();
        sf = new SimpleDateFormat("yyyy-MM-dd");
        this.studentId = id;
        this.marksList = new ArrayList<>();
        this.correctAnswers = new ArrayList<>();
        this.resultList = new ArrayList<>();

        allRadio.setSelected(true);
        all = allRadio.isSelected();
        if (all == true) {
            myPanel.setVisible(true);
            meRadio.setSelected(false);
            me = false;
        }

        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);

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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        batchCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cemesterCombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        scrollpane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        subjectCombo = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        typeCombo = new javax.swing.JComboBox();
        datePiker = new org.jdesktop.swingx.JXDatePicker();
        jLabel17 = new javax.swing.JLabel();
        meRadio = new javax.swing.JRadioButton();
        allRadio = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        myPanel = new javax.swing.JPanel();
        highRadio = new javax.swing.JRadioButton();
        lowRadio = new javax.swing.JRadioButton();
        reportButton = new javax.swing.JLabel();
        searchButton = new javax.swing.JLabel();
        getAllResultRadioButton = new javax.swing.JRadioButton();

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
        jPanel1.add(batchCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 150, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Batch");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 150, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cemester");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 170, 40));

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
        jPanel1.add(cemesterCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 170, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Subject");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 140, 40));

        scrollpane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Exam Id", "Paper", "Student Id", "Marks", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        jPanel1.add(scrollpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 630, 380));

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
        jPanel1.add(subjectCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 140, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Select Date ");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, 130, 40));

        typeCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typeComboItemStateChanged(evt);
            }
        });
        typeCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                typeComboMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                typeComboMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                typeComboMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                typeComboMouseReleased(evt);
            }
        });
        typeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboActionPerformed(evt);
            }
        });
        jPanel1.add(typeCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 140, 30));

        datePiker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datePikerMouseClicked(evt);
            }
        });
        jPanel1.add(datePiker, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 140, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Paper");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 140, 40));

        meRadio.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(meRadio);
        meRadio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        meRadio.setText("Only me");
        meRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meRadioActionPerformed(evt);
            }
        });
        jPanel1.add(meRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        allRadio.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(allRadio);
        allRadio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        allRadio.setText("All");
        allRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allRadioActionPerformed(evt);
            }
        });
        jPanel1.add(allRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 72, 990, 10));

        myPanel.setBackground(new java.awt.Color(255, 255, 255));
        myPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        myPanel.setLayout(null);

        highRadio.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(highRadio);
        highRadio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        highRadio.setText("  High Marks");
        highRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highRadioActionPerformed(evt);
            }
        });
        myPanel.add(highRadio);
        highRadio.setBounds(70, 40, 160, 25);

        lowRadio.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(lowRadio);
        lowRadio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lowRadio.setText("  Low Marks");
        lowRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lowRadioActionPerformed(evt);
            }
        });
        myPanel.add(lowRadio);
        lowRadio.setBounds(70, 110, 170, 25);

        reportButton.setBackground(new java.awt.Color(102, 102, 102));
        reportButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reportButton.setForeground(new java.awt.Color(255, 255, 255));
        reportButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reportButton.setText("Get Report");
        reportButton.setOpaque(true);
        reportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportButtonMouseExited(evt);
            }
        });
        myPanel.add(reportButton);
        reportButton.setBounds(70, 160, 130, 30);

        jPanel1.add(myPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 280, 220));

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/serachButton.png"))); // NOI18N
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchButtonMouseExited(evt);
            }
        });
        jPanel1.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, 120, 60));

        getAllResultRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(getAllResultRadioButton);
        getAllResultRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getAllResultRadioButton.setText("Get My All Result");
        getAllResultRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllResultRadioButtonActionPerformed(evt);
            }
        });
        jPanel1.add(getAllResultRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

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

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (me == true) {
            if (datePiker.getDate() != null) {

//                int rowCount = table.getRowCount();
//                System.out.println("Row Count: " + rowCount);
//                if (rowCount == 1) {

                    int index = table.getSelectedRow();
                    String examId = table.getValueAt(table.getSelectedRow(), 0).toString();
                    if (examId.equals("Absent")) {

                    } else {

                        if (searchAllStudentResult == null) {

                        } else {
                            //loard
                            loardResultReport(index);
                        }

                    }
//                } else {
//                }
            } else {
                JOptionPane.showMessageDialog(null, "Select Date");

            }
        }

    }//GEN-LAST:event_tableMouseClicked

    private void typeComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typeComboItemStateChanged
        //  getpapersName();
    }//GEN-LAST:event_typeComboItemStateChanged

    private void typeComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_typeComboMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_typeComboMouseClicked

    private void typeComboMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_typeComboMouseExited

    }//GEN-LAST:event_typeComboMouseExited

    private void typeComboMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_typeComboMousePressed

    }//GEN-LAST:event_typeComboMousePressed

    private void typeComboMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_typeComboMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_typeComboMouseReleased

    private void typeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboActionPerformed

    }//GEN-LAST:event_typeComboActionPerformed

    private void datePikerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datePikerMouseClicked

    }//GEN-LAST:event_datePikerMouseClicked

    private void meRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meRadioActionPerformed
        me = meRadio.isSelected();
        if (me == true) {
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            myPanel.setVisible(false);
            allRadio.setSelected(false);
            all = false;
        }
    }//GEN-LAST:event_meRadioActionPerformed

    private void allRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allRadioActionPerformed
        all = allRadio.isSelected();
        if (all == true) {

            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            myPanel.setVisible(true);
            meRadio.setSelected(false);
            me = false;
        }

    }//GEN-LAST:event_allRadioActionPerformed

    private void lowRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lowRadioActionPerformed
        try {
            low = lowRadio.isSelected();
            if (low) {
                high = false;

                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                int row = 0;
                Integer min = Collections.min(marksList);
                for (int i = 0; i < marksList.size(); i++) {
                    if (min == marksList.get(i)) {
                        row = i;
                    }
                }
                System.out.println("Low row: " + row);

                // table.setRowSelectionAllowed(low);
                table.getSelectionModel().setSelectionInterval(row, row);

            }
        } catch (NoSuchElementException | IllegalArgumentException ex) {

        }
    }//GEN-LAST:event_lowRadioActionPerformed

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        try {
            batch = batchCombo.getSelectedItem().toString();
            cemester = cemesterCombo.getSelectedItem().toString();
            subject = subjectCombo.getSelectedItem().toString();
            fileName = typeCombo.getSelectedItem().toString();

        } catch (NullPointerException ex) {
        }

        Date d1 = new Date();
        try {
            if (datePiker.getDate() != null) {
                sf = new SimpleDateFormat("yyyy-MM-dd");
                d1 = datePiker.getDate();
                date = sf.format(d1);

                if (all) {//all

                    try {
                        ResultController rc = ServerConnecter.getServerConnecter().getResultController();
                        String resultPath = batch + "/" + cemester + "/" + subject + "/" + fileName.replace(".txt", "") + "/" + date;
                        searchAllStudentResult = rc.SearchAllStudentResult(resultPath);
                        loardAllStudentData();
                    } catch (NotBoundException ex) {
                        Logger.getLogger(ViewStudentResult.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(ViewStudentResult.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ViewStudentResult.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ViewStudentResult.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else { //me
                    try {
                        ResultController rc = ServerConnecter.getServerConnecter().getResultController();
                        String resultPath = batch + "/" + cemester + "/" + subject + "/" + fileName.replace(".txt", "") + "/" + date;
                        result = rc.SearchStudentResult(studentId, resultPath);
                        if (result == null) {
                            JOptionPane.showMessageDialog(null, "No Result");
                        } else {
                            loardOneStudentData();
                        }
                    } catch (NotBoundException ex) {
                        Logger.getLogger(ViewStudentResult.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(ViewStudentResult.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ViewStudentResult.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ViewStudentResult.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Select Date!!!", "Warning", 2);
            }
        } catch (NullPointerException | NumberFormatException ex) {
        }
    }//GEN-LAST:event_searchButtonMouseClicked

    private void searchButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseEntered
        searchButton.setBorder(new MotifBorders.BevelBorder(true, Color.red, Color.red));
    }//GEN-LAST:event_searchButtonMouseEntered

    private void searchButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseExited
        searchButton.setBorder(null);
    }//GEN-LAST:event_searchButtonMouseExited

    private void highRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highRadioActionPerformed
        try {
            high = highRadio.isSelected();
            if (high) {
                low = false;

                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                int row = 0;
                Integer max = Collections.max(marksList);
                for (int i = 0; i < marksList.size(); i++) {
                    if (max == marksList.get(i)) {
                        row = i;
                    }
                }
                System.out.println("High row: " + row);
                table.setRowSelectionInterval(row, row);

            }
        } catch (NoSuchElementException | IllegalArgumentException ex) {

        }
    }//GEN-LAST:event_highRadioActionPerformed

    private void reportButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportButtonMouseClicked
        int i = table.getRowCount();
        if (i < 1) {
            JOptionPane.showMessageDialog(null, "No Data");
        } else {
            try {
                InputStream is = getClass().getResourceAsStream("../jasper/ResultReport.jrxml");
                JasperReport jr = JasperCompileManager.compileReport(is);
                JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap<String, Object>(), new JRTableModelDataSource(table.getModel()));
                JasperViewer.viewReport(jp, false);
            } catch (JRException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_reportButtonMouseClicked

    private void reportButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportButtonMouseEntered
        reportButton.setForeground(new Color(102, 255, 255));
    }//GEN-LAST:event_reportButtonMouseEntered

    private void reportButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportButtonMouseExited
        reportButton.setForeground(Color.white);        // TODO add your handling code here:
    }//GEN-LAST:event_reportButtonMouseExited

    private void getAllResultRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllResultRadioButtonActionPerformed
  myPanel.setVisible(true);         
        if (studentId.isEmpty() || studentId == null) {
            
        } else {
            try {
                ResultController resultController = ServerConnecter.getServerConnecter().getResultController();
                ArrayList<Result> studentAllResult = resultController.getStudentAllResult(studentId);
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                dtm.setRowCount(0);
                for (Result r : studentAllResult) {
                    Object[] row = {r.getExamId(), r.getPaperName(), r.getStudentId(), r.getMarks(), r.getGrade()};
                    dtm.addRow(row);
                }
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(ViewAdminResult.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ViewAdminResult.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_getAllResultRadioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton allRadio;
    private javax.swing.JComboBox batchCombo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cemesterCombo;
    private org.jdesktop.swingx.JXDatePicker datePiker;
    private javax.swing.JRadioButton getAllResultRadioButton;
    private javax.swing.JRadioButton highRadio;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton lowRadio;
    private javax.swing.JRadioButton meRadio;
    private javax.swing.JPanel myPanel;
    private javax.swing.JLabel reportButton;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JLabel searchButton;
    private javax.swing.JComboBox subjectCombo;
    private javax.swing.JTable table;
    private javax.swing.JComboBox typeCombo;
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
        } catch (NullPointerException ex) {
        }
        try {
            QuestionController qc = ServerConnecter.getServerConnecter().getQuestionController();
            ArrayList<String> papersNameList = qc.getPapersName(path);
            if (papersNameList == null) {
                typeCombo.removeAllItems();

            } else {
                typeCombo.removeAllItems();

                for (String s : papersNameList) {
                    String ss = s.replace(".txt", "");
                    typeCombo.addItem(ss);
                }

            }

        } catch (MalformedURLException | RemoteException | NotBoundException ex) {
            Logger.getLogger(ManageQuestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     */
    public void loardAllStudentData() {
        ArrayList<Student> allStudentsOfBatch = new ArrayList<>();
        HashSet<String> setList = new HashSet<String>();

        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        try {

            for (int i = 0; i < searchAllStudentResult.size() + 1; i++) {
                Result r = searchAllStudentResult.get(i);
                marksList.add(Integer.parseInt(r.getMarks()));
                Object[] row = {r.getExamId(), r.getPaperName(), r.getStudentId(), r.getMarks(), r.getGrade()};
                dtm.addRow(row);

            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("ERROR");
        }
        try {
            StudentController sc = ServerConnecter.getServerConnecter().getStudentController();
            allStudentsOfBatch = sc.getAllStudentsOfBatch(batch);
            System.out.println("All Student Size: " + allStudentsOfBatch.size());

            for (int i = 0; i < allStudentsOfBatch.size() + 1; i++) {

                for (int j = 0; j < searchAllStudentResult.size() + 1; j++) {
                    System.out.println("Search Result :" + searchAllStudentResult.get(j).getStudentId());
                    if (searchAllStudentResult.get(j).getStudentId().equals(allStudentsOfBatch.get(i).getId())) {
                        System.out.println("Equal :" + allStudentsOfBatch.get(i).getId());
                    } else {
                        System.out.println("OUT: " + allStudentsOfBatch.get(i).getId());
                        setList.add(allStudentsOfBatch.get(i).getId());
                    }

                }
            }
        } catch (IndexOutOfBoundsException | IOException | NotBoundException ex) {

        }

        for (String studentId : setList) {
            Object[] row = {"Absent ", "Absent ", studentId, "", "Absent "};
            dtm.addRow(row);
        }

    }

    /**
     *
     */
    public void loardOneStudentData() {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);

        Object[] row = {result.getExamId(), result.getPaperName(), result.getStudentId(), result.getMarks(), result.getGrade()};
        dtm.addRow(row);

    }

    /**
     *
     * @param index
     */
    public void loardResultReport(int index) {
        correctAnswers = null;
        correctAns = 0;
        wrongAns = 0;
        correctAnswers = new ArrayList<>();
        HashMap<String, String> studentAnswerList = new HashMap<>();
        Result result = searchAllStudentResult.get(index);
        startQ = Integer.parseInt(result.getStartQ());
        endQ = Integer.parseInt(result.getEndQ());
        grade = result.getGrade();
        marks = result.getMarks();
        fileName = result.getPaperName().replace(".txt", "");
        studentId = result.getStudentId();

        System.out.println("Full Ans: " + result.getStudentAns());
        String[] ans = result.getStudentAns().split("#");
        try {
            for (int i = 0; i < ans.length; i++) {
                System.out.println("ans: " + ans[i]);
                String[] split = ans[i].split("%");
                studentAnswerList.put(split[0], split[1]);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
        System.out.println("Sudents Ans List size : " + studentAnswerList.size());
        //get answers

        for (int i = startQ; i < endQ + 1; i++) {

            try {
                QuestionController qc = ServerConnecter.getServerConnecter().getQuestionController();
                correctAnswers.add(qc.getAnswers(path, fileName + ".txt", i));

            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Student Ans ArrayList Size :" + studentAnswerList.size());
        System.out.println("Correct Ans ArrayList Size :" + correctAnswers.size());

        //check correct Answers 
        if (correctAnswers.size() == 0) {

        } else {
            for (int i = 0; i < correctAnswers.size(); i++) {
                if (studentAnswerList.containsKey(Integer.toString(i + startQ))) {
                    if (studentAnswerList.get(Integer.toString(i + startQ)).equals(correctAnswers.get(i))) {

                        ++correctAns;
                        resultList.add("Correct");
                    } else if (studentAnswerList.get(Integer.toString(i + startQ)).equals("*:*:*:*")) {

                        resultList.add("Not Answered");
                    } else {

                        ++wrongAns;
                        resultList.add("Wrong");
                    }
                } else {

                    resultList.add("Not Answered");
                }

            }
        }

        //
        PracticeExamResultReport perr = new PracticeExamResultReport();
        perr.setFinalExamData(path, fileName.replace(".txt", ""), studentId, Integer.toString(correctAns), Integer.toString(wrongAns), correctAnswers, studentAnswerList, startQ, endQ, resultList, grade, marks);
        perr.setVisible(true);

    }

}
