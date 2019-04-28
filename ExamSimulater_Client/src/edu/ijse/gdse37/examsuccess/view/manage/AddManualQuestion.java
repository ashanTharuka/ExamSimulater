/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.manage;

import edu.ijse.gdse37.examsuccess.model.Batch;
import edu.ijse.gdse37.examsuccess.model.Cemester;
import edu.ijse.gdse37.examsuccess.model.Question;
import edu.ijse.gdse37.examsuccess.model.Subject;
import edu.ijse.gdse37.examsuccess.view.student.Add_Student_Panal;
import edu.ijse.gdse37.examsuccess.connecter.ServerConnecter;
import edu.ijse.gdse37.examsuccess.controller.BatchController;
import edu.ijse.gdse37.examsuccess.controller.SemesterController;
import edu.ijse.gdse37.examsuccess.controller.QuestionController;
import edu.ijse.gdse37.examsuccess.controller.SubjectController;
import java.awt.Color;
import java.awt.Frame;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ashan Tharuka
 */
public class AddManualQuestion extends javax.swing.JFrame {

    private String path;
    private String fileName;
    private String addFileName;
    private String addPath;

    private int xMouse;
    private int yMouse;
    private ArrayList<Question> questionList;
    ArrayList<Question> allQuestion;
    private ManageQuestion manage;

    /**
     * Creates new form AddManualQuestion
     * @param pth
     * @param manage
     * @param fileNam
     */
    public AddManualQuestion(String pth, String fileNam, ManageQuestion manage) {
        initComponents();
        setSize(990, 600);
        addFileName = fileNam;
        addPath = pth;
        questionList = new ArrayList<>();
        viewPaperButton.setVisible(false);
        setLocationRelativeTo(null);
        fillCombo();
        getpapersName();
        this.manage = manage;

        setDefaultCloseOperation(2);

//        TableColumnModel columnModel = table.getColumnModel();
//        columnModel.getColumn(0).setPreferredWidth(5);
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
        jLabel6 = new javax.swing.JLabel();
        closePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        minimizePanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        batchCombo = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cemesterCombo = new javax.swing.JComboBox();
        subjectCombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        typeCombo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        msgLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        viewPaperButton = new javax.swing.JLabel();
        addButton = new javax.swing.JLabel();
        deleteButton = new javax.swing.JLabel();
        doneButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(990, 600));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(990, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(990, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Add Question Manually");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 230, 40));

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/icon-nav-close.png"))); // NOI18N
        closePanel.add(jLabel2);
        jLabel2.setBounds(10, 10, 20, 20);

        jPanel1.add(closePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, -1, -1));

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

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/020739-rounded-glossy-black-icon-symbols-shapes-minimize.png"))); // NOI18N
        minimizePanel.add(jLabel5);
        jLabel5.setBounds(10, 20, 20, 10);

        jPanel1.add(minimizePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

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
        jPanel1.add(batchCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 120, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Batch");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 120, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cemester");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 110, 40));

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
        jPanel1.add(cemesterCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 110, 30));

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
        jPanel1.add(subjectCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 110, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Subject");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 110, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Paper");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 130, 40));

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
        jPanel1.add(typeCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 130, 30));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Question Number", "Question", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setColumnSelectionAllowed(true);
        table.setRowHeight(25);
        table.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(5);
            table.getColumnModel().getColumn(1).setPreferredWidth(50);
            table.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 930, 380));

        msgLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        msgLabel.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(msgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 290, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/selectedQuestionTitle.png"))); // NOI18N
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 80));

        viewPaperButton.setBackground(new java.awt.Color(102, 102, 102));
        viewPaperButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewPaperButton.setForeground(new java.awt.Color(255, 255, 255));
        viewPaperButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewPaperButton.setText("View Paper");
        viewPaperButton.setOpaque(true);
        viewPaperButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewPaperButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewPaperButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewPaperButtonMouseExited(evt);
            }
        });
        jPanel1.add(viewPaperButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 180, 50));

        addButton.setBackground(new java.awt.Color(102, 102, 102));
        addButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addButton.setText("Add Q");
        addButton.setOpaque(true);
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
        });
        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, 190, 50));

        deleteButton.setBackground(new java.awt.Color(102, 102, 102));
        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteButton.setText("Delete Q");
        deleteButton.setOpaque(true);
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
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 530, 190, 50));

        doneButton.setBackground(new java.awt.Color(0, 0, 0));
        doneButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doneButton.setForeground(new java.awt.Color(255, 255, 255));
        doneButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        doneButton.setText("Done");
        doneButton.setOpaque(true);
        doneButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doneButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                doneButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                doneButtonMouseExited(evt);
            }
        });
        jPanel1.add(doneButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 530, 340, 50));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 990, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void batchComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchComboItemStateChanged
        getpapersName();           // TODO add your handling code here:
    }//GEN-LAST:event_batchComboItemStateChanged

    private void batchComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batchComboMouseClicked
        getpapersName();           // TODO add your handling code here:
    }//GEN-LAST:event_batchComboMouseClicked

    private void cemesterComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cemesterComboItemStateChanged
        getpapersName();        // TODO add your handling code here:
    }//GEN-LAST:event_cemesterComboItemStateChanged

    private void cemesterComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cemesterComboMouseClicked
        getpapersName();           // TODO add your handling code here:
    }//GEN-LAST:event_cemesterComboMouseClicked

    private void subjectComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_subjectComboItemStateChanged

        getpapersName();                 // TODO add your handling code here:
    }//GEN-LAST:event_subjectComboItemStateChanged

    private void subjectComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectComboMouseClicked

        getpapersName();       // TODO add your handling code here:
    }//GEN-LAST:event_subjectComboMouseClicked

    private void typeComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typeComboItemStateChanged
        try {
            String batch = batchCombo.getSelectedItem().toString();
            String cemester = cemesterCombo.getSelectedItem().toString();
            String subject = subjectCombo.getSelectedItem().toString();

            String type = null;

            type = typeCombo.getSelectedItem().toString();

            path = "./Database/Papers/" + batch + "/" + cemester + "/" + subject;
            fileName = type + ".txt";

            if (type.equals("None")) {

            } else {
                QuestionController qc = ServerConnecter.getServerConnecter().getQuestionController();
                allQuestion = qc.getAllQuestion(path + "/" + fileName);
                if (allQuestion == null) {
                    msgLabel.setText(fileName.replace(".txt", "") + " paper Is Empty !!");
                } else {
                    DefaultTableModel dtm = (DefaultTableModel) table.getModel();

                    dtm.setRowCount(0);
                    table.getColumnModel().getColumn(0).setPreferredWidth(1);

                    for (Question q : allQuestion) {
                        Object[] row = {q.getqNumber(), q.getMainQ().replace("අ", "\n")};
                        dtm.addRow(row);

                    }

                    viewPaperButton.setVisible(true);
                }

            }

        } catch (NullPointerException ex) {
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(AddManualQuestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddManualQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
//        table.setRowSelectionAllowed(true);
//        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//        selection = table.getSelectedRows();


    }//GEN-LAST:event_tableMouseClicked

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);            // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseDragged

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

    private void viewPaperButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPaperButtonMouseClicked
        ViewPaper view = new ViewPaper(fileName, allQuestion);
        view.setVisible(true);
    }//GEN-LAST:event_viewPaperButtonMouseClicked

    private void viewPaperButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPaperButtonMouseEntered
        viewPaperButton.setForeground(new Color(102, 255, 255));
    }//GEN-LAST:event_viewPaperButtonMouseEntered

    private void viewPaperButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPaperButtonMouseExited
        viewPaperButton.setForeground(Color.white);
    }//GEN-LAST:event_viewPaperButtonMouseExited

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
        String ans = null;
        for (int i = 0; i < table.getRowCount(); i++) {

            try {
                ans = String.valueOf(table.getValueAt(i, 2).toString());
                System.out.println("chechBox: " + ans);
            } catch (NullPointerException ex) {

                ans = null;

            }
            try {
                if (ans.equals("true")) {

                    String qNumber = table.getValueAt(i, 0).toString();

                    QuestionController qc = ServerConnecter.getServerConnecter().getQuestionController();
                    Question q = qc.SearchQuestion("Q", qNumber, path, fileName);
                    Question que = new Question(q.getqNumber(), q.getPaperId(), q.getMainQ(), q.getQ1(), q.getQ2(), q.getQ3(), q.getQ4(), q.getQa(), q.getQb(), q.getQc(), q.getQd(), q.getPath(), q.getFileName());

                    boolean isTrue = false;

                    L1:
                    for (int j = 0; j < questionList.size(); j++) {

                        String s1 = que.getMainQ();
                        System.out.println("10");
                        if (s1.equals(questionList.get(j).getMainQ())) {
                            // System.out.println("11");
                            isTrue = true;
                            break L1;
                        } else {
                            // System.out.println("12");
                            isTrue = false;
                        }
                    }

                    if (isTrue == false) {
                        System.out.println("Q= : " + que.getMainQ());

                        questionList.add(que);
                        msgLabel.setText(questionList.size() + " Questions selectd");
                    }
                } else {
                    System.out.println("false");
                }
            } catch (NullPointerException ex) {
                System.out.println("null");
            } catch (IOException | NotBoundException ex) {
                Logger.getLogger(AddManualQuestion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_addButtonMouseClicked

    private void addButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseEntered
        addButton.setForeground(new Color(102, 255, 255));
    }//GEN-LAST:event_addButtonMouseEntered

    private void addButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseExited
        addButton.setForeground(Color.white);
    }//GEN-LAST:event_addButtonMouseExited

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        String ans = null;
        for (int i = 0; i < table.getRowCount(); i++) {

            try {
                ans = String.valueOf(table.getValueAt(i, 2).toString());
                System.out.println("chechBox: " + ans);
            } catch (NullPointerException ex) {

                ans = null;

            }
            try {
                if (ans.equals("true")) {

                    String qNumber = table.getValueAt(i, 0).toString();

                    QuestionController qc = ServerConnecter.getServerConnecter().getQuestionController();
                    Question q = qc.SearchQuestion("Q", qNumber, path, fileName);
                    Question que = new Question(q.getqNumber(), q.getPaperId(), q.getMainQ(), q.getQ1(), q.getQ2(), q.getQ3(), q.getQ4(), q.getQa(), q.getQb(), q.getQc(), q.getQd(), q.getPath(), q.getFileName());
                    L1:
                    for (int j = 0; j < questionList.size(); j++) {

                        String s1 = que.getMainQ();
                        if (s1.equals(questionList.get(j).getMainQ())) {

                            questionList.remove(questionList.get(j));
                            msgLabel.setText(questionList.size() + " Questions selectd");
                            break L1;
                        } else {

                        }
                    }

                } else {
                    System.out.println("false");
                }
            } catch (NullPointerException ex) {
                System.out.println("null");
            } catch (IOException | NotBoundException ex) {
                Logger.getLogger(AddManualQuestion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_deleteButtonMouseClicked

    private void deleteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseEntered
        addButton.setForeground(new Color(102, 255, 255));
    }//GEN-LAST:event_deleteButtonMouseEntered

    private void deleteButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseExited
        addButton.setForeground(Color.white);
    }//GEN-LAST:event_deleteButtonMouseExited

    private void doneButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneButtonMouseClicked

        manage.addSelectedQuestion(questionList, addPath, addFileName);
        this.dispose();
    }//GEN-LAST:event_doneButtonMouseClicked

    private void doneButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneButtonMouseEntered
        doneButton.setForeground(new Color(102, 255, 255));
    }//GEN-LAST:event_doneButtonMouseEntered

    private void doneButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneButtonMouseExited
        doneButton.setForeground(Color.white);
    }//GEN-LAST:event_doneButtonMouseExited

    /**
     *
     * @param args
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
            java.util.logging.Logger.getLogger(AddManualQuestion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddManualQuestion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddManualQuestion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddManualQuestion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addButton;
    private javax.swing.JComboBox batchCombo;
    private javax.swing.JComboBox cemesterCombo;
    private javax.swing.JPanel closePanel;
    private javax.swing.JLabel deleteButton;
    private javax.swing.JLabel doneButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel minimizePanel;
    private javax.swing.JLabel msgLabel;
    private javax.swing.JComboBox subjectCombo;
    private javax.swing.JTable table;
    private javax.swing.JComboBox typeCombo;
    private javax.swing.JLabel viewPaperButton;
    // End of variables declaration//GEN-END:variables

    /**
     *get papersName and lord it to combo box
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
                typeCombo.addItem("None");
            } else {
                typeCombo.removeAllItems();
                typeCombo.addItem("None");
                for (String s : papersNameList) {
                    String ss = s.replace(".txt", "");
                    typeCombo.addItem(ss);

                }

            }

        } catch (MalformedURLException | RemoteException | NotBoundException ex) {
            Logger.getLogger(ManageQuestion.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageQuestion.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *lord batch,semester,subject combo data
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

}