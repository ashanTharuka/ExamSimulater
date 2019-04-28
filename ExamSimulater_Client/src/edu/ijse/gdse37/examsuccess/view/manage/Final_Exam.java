/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.manage;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import edu.ijse.gdse37.examsuccess.model.Question;
import edu.ijse.gdse37.examsuccess.connecter.ServerConnecter;
import edu.ijse.gdse37.examsuccess.controller.AdminController;
import edu.ijse.gdse37.examsuccess.controller.ExamController;
import edu.ijse.gdse37.examsuccess.controller.LoginController;
import edu.ijse.gdse37.examsuccess.controller.PracticeExamController;
import edu.ijse.gdse37.examsuccess.controller.QuestionController;
import edu.ijse.gdse37.examsuccess.controller.ResultController;
import edu.ijse.gdse37.examsuccess.controller.StudentController;
import edu.ijse.gdse37.examsuccess.model.Exam;
import edu.ijse.gdse37.examsuccess.model.Result;
import java.awt.Color;
import java.awt.Frame;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ashan Tharuka
 */
public class Final_Exam extends javax.swing.JFrame {

    private int xMouse;
    private int yMouse;
    private int qNumber;
    private String path;
    private String fileName;
    private static int startQ;
    private int endQ;
    private String studentId;
    private HashMap<String, String> studentAnswerList;
    private ArrayList<String> correctAnswers;
    private ArrayList<String> result;

    private String qA;
    private String qB;
    private String qC;
    private String qD;
    private String examId;
    private Date d1;
    private Date d2;

    private int aMarks;
    private int bMarks;
    private int cMarks;
    private int wMarks;
    private int marksForOneQuestion;
    private String sendMail;
    private String grade;
    private int marks;
    private StringBuffer studentAns;

    private String batch;
    private String cemester;
    private String subject;
    private String paperId;

    private boolean isOpen;

    /**
     *
     * @param path
     * @param fileName
     * @param startQ
     * @param endQ
     * @param studentId
     * @param time
     * @param examId
     * @param paperId
     */
    public Final_Exam(String path, String fileName, String startQ, String endQ, String studentId, String time, String examId, String paperId) {
        try {
            initComponents();
            setLocationRelativeTo(null);
            setSize(1150, 700);
            setLocationRelativeTo(null);
            studentAns = new StringBuffer();
            System.out.println("path: " + path);
            System.out.println("FilName: " + fileName);
            System.out.println("StartQ: " + startQ);
            System.out.println("EndQ: " + endQ);
            this.studentAnswerList = new HashMap<>();
            this.result = new ArrayList<>();
            this.correctAnswers = new ArrayList<>();
            this.path = path;
            this.fileName = fileName;
            this.startQ = Integer.parseInt(startQ);
            this.endQ = Integer.parseInt(endQ);
            this.qNumber = Integer.parseInt(startQ);
            this.studentId = studentId;
            this.examId = examId;
            this.paperId = paperId;
            grade = null;
            StudentController student = ServerConnecter.getServerConnecter().getStudentController();
            student.startFinalExam(studentId, paperId);

            goTo(qNumber);

            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            d1 = new Date();
            d1 = sdf.parse(time.replace("-", ":") + ":" + "00");

            // long diff = d1.getTime();
            d2 = new Date();
            String miliTime = "00:00:01";
            d2 = sdf.parse(miliTime);
            System.out.println("Time Limt: " + time + ":" + "00");

            saveMethod();
            SummeryJPanel DB = new SummeryJPanel(startQ, endQ, studentAnswerList, this);
            summeryPanel.removeAll();
            summeryPanel.add(DB);
            summeryPanel.repaint();
            summeryPanel.revalidate();
            DB.setVisible(true);

            /////////time Thread
            new Thread() {
                public void run() {
                    String timeE = time + ":" + "00";
                    Date d3One = d1;
                    Date d3Two = d2;

                    while (!(timeE.equals("0:0:0"))) {

                        try {
                            Date subs;
                            SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss");

                            long diff = d3One.getTime() - d3Two.getTime();

                            long dM = diff / (60 * 1000) % 60;//Minutes

                            long dH = diff / (60 * 60 * 1000) % 24;//Housra

                            long dS = diff / 1000 % 60;//Seconds

                            d3One = sf.parse(dH + ":" + dM + ":" + dS);
                            timeE = dH + ":" + dM + ":" + dS;
                            timeLabel.setText(sf.format(d3One));

                        } catch (ParseException ex) {
                            Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    endMethod();
                }
            }.start();

        } catch (ParseException ex) {
            Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param path
     * @param fileName
     * @param startQ
     * @param endQ
     * @param studentId
     * @param time
     * @param examId
     * @param paperId
     * @param late
     * @param b
     */
    public Final_Exam(String path, String fileName, String startQ, String endQ, String studentId, String time, String examId, String paperId, boolean late, BeginExam b) {
        try {
            initComponents();
            setLocationRelativeTo(null);
            setSize(1150, 700);
            setLocationRelativeTo(null);
            b.dispose();
            studentAns = new StringBuffer();
            System.out.println("path: " + path);
            System.out.println("FilName: " + fileName);
            System.out.println("StartQ: " + startQ);
            System.out.println("EndQ: " + endQ);
            this.studentAnswerList = new HashMap<>();
            this.result = new ArrayList<>();
            this.correctAnswers = new ArrayList<>();
            this.path = path;
            this.fileName = fileName;
            this.startQ = Integer.parseInt(startQ);
            this.endQ = Integer.parseInt(endQ);
            this.qNumber = Integer.parseInt(startQ);
            this.studentId = studentId;
            this.examId = examId;
            this.paperId = paperId;
            grade = null;
            StudentController student = ServerConnecter.getServerConnecter().getStudentController();
            student.startFinalExam(studentId, paperId);

            saveMethod();
            SummeryJPanel DB = new SummeryJPanel(startQ, endQ, studentAnswerList, this);
            summeryPanel.removeAll();
            summeryPanel.add(DB);
            summeryPanel.repaint();
            summeryPanel.revalidate();
            DB.setVisible(true);

            goTo(qNumber);

            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            d1 = new Date();
            d1 = sdf.parse(time);

            // long diff = d1.getTime();
            d2 = new Date();
            String miliTime = "00:00:01";
            d2 = sdf.parse(miliTime);
            System.out.println("Time Limt: " + time);

            /////////time Thread
            new Thread() {
                public void run() {
                    String timeE = time + ":" + "00";
                    Date d3One = d1;
                    Date d3Two = d2;

                    while (!(timeE.equals("0:0:0"))) {

                        try {
                            Date subs;
                            SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss");

                            long diff = d3One.getTime() - d3Two.getTime();

                            long dM = diff / (60 * 1000) % 60;//Minutes

                            long dH = diff / (60 * 60 * 1000) % 24;//Housra

                            long dS = diff / 1000 % 60;//Seconds

                            d3One = sf.parse(dH + ":" + dM + ":" + dS);
                            timeE = dH + ":" + dM + ":" + dS;
                            timeLabel.setText(dH + ":" + dM + ":" + dS);

                        } catch (ParseException ex) {
                            Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    endMethod();
                }
            }.start();

        } catch (ParseException ex) {
            Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
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
        closePanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        minimizePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        summeryPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        questionPanel = new javax.swing.JPanel();
        qNumText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainQText = new javax.swing.JTextArea();
        aText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        aa = new javax.swing.JRadioButton();
        bb = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        bText = new javax.swing.JTextField();
        cText = new javax.swing.JTextField();
        dText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cc = new javax.swing.JRadioButton();
        dd = new javax.swing.JRadioButton();
        timeLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        nextButton = new javax.swing.JLabel();
        summeryButton = new javax.swing.JLabel();
        viewPaperButton = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        qCountText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 730));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1366, 730));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 730));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closePanel1.setBackground(new java.awt.Color(255, 255, 255));
        closePanel1.setForeground(new java.awt.Color(255, 255, 255));
        closePanel1.setPreferredSize(new java.awt.Dimension(40, 40));
        closePanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closePanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closePanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closePanel1MouseExited(evt);
            }
        });
        closePanel1.setLayout(null);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/icon-nav-close.png"))); // NOI18N
        closePanel1.add(jLabel10);
        jLabel10.setBounds(10, 10, 20, 20);

        jPanel1.add(closePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, -1, -1));

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/020739-rounded-glossy-black-icon-symbols-shapes-minimize.png"))); // NOI18N
        minimizePanel.add(jLabel3);
        jLabel3.setBounds(10, 20, 20, 10);

        jPanel1.add(minimizePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 10, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/finalExam1.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        summeryPanel.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(summeryPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 160, 310, 380));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/finalExam2.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1370, 60));

        questionPanel.setBackground(new java.awt.Color(255, 255, 255));
        questionPanel.setMinimumSize(new java.awt.Dimension(1150, 560));
        questionPanel.setPreferredSize(new java.awt.Dimension(1150, 560));
        questionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        qNumText.setEditable(false);
        qNumText.setBackground(new java.awt.Color(255, 255, 255));
        qNumText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        questionPanel.add(qNumText, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 70, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Question Number :");
        questionPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 150, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Question :");
        questionPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 90, 30));

        mainQText.setEditable(false);
        mainQText.setColumns(20);
        mainQText.setRows(5);
        mainQText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mainQTextKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(mainQText);

        questionPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 580, -1));

        aText.setEditable(false);
        aText.setBackground(new java.awt.Color(255, 255, 255));
        questionPanel.add(aText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 580, 42));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("A :");
        questionPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 55, 42));

        aa.setBackground(new java.awt.Color(255, 255, 255));
        aa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aaActionPerformed(evt);
            }
        });
        questionPanel.add(aa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 40, 40));

        bb.setBackground(new java.awt.Color(255, 255, 255));
        questionPanel.add(bb, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 40, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("B :");
        questionPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 55, 39));

        bText.setEditable(false);
        bText.setBackground(new java.awt.Color(255, 255, 255));
        bText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTextActionPerformed(evt);
            }
        });
        questionPanel.add(bText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 580, 41));

        cText.setEditable(false);
        cText.setBackground(new java.awt.Color(255, 255, 255));
        questionPanel.add(cText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 580, 41));

        dText.setEditable(false);
        dText.setBackground(new java.awt.Color(255, 255, 255));
        questionPanel.add(dText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 580, 41));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText(" D :");
        questionPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 61, 42));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("C :");
        questionPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 55, 43));

        cc.setBackground(new java.awt.Color(255, 255, 255));
        questionPanel.add(cc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 40, 40));

        dd.setBackground(new java.awt.Color(255, 255, 255));
        questionPanel.add(dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 40, 40));

        timeLabel.setFont(new java.awt.Font("DS-Digital", 1, 48)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(255, 51, 51));
        questionPanel.add(timeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 210, 50));

        backButton.setBackground(new java.awt.Color(171, 227, 247));
        backButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/backButton.png"))); // NOI18N
        backButton.setText("<html>Back <br>");
        backButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backButton.setMinimumSize(new java.awt.Dimension(110, 50));
        backButton.setPreferredSize(new java.awt.Dimension(110, 50));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButtonMouseExited(evt);
            }
        });
        questionPanel.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 150, 60));

        nextButton.setBackground(new java.awt.Color(171, 227, 247));
        nextButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nextButton.setForeground(new java.awt.Color(255, 255, 255));
        nextButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/requestButton.png"))); // NOI18N
        nextButton.setText("<html>Next <br>");
        nextButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nextButton.setMinimumSize(new java.awt.Dimension(110, 50));
        nextButton.setPreferredSize(new java.awt.Dimension(110, 50));
        nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextButtonMouseExited(evt);
            }
        });
        questionPanel.add(nextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 500, 150, 60));

        summeryButton.setBackground(new java.awt.Color(171, 227, 247));
        summeryButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        summeryButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        summeryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/examsuccess/view/photos/practiceExamButton.png"))); // NOI18N
        summeryButton.setText("<html>Summery <br>");
        summeryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        summeryButton.setMinimumSize(new java.awt.Dimension(110, 50));
        summeryButton.setPreferredSize(new java.awt.Dimension(110, 50));
        summeryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                summeryButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                summeryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                summeryButtonMouseExited(evt);
            }
        });
        questionPanel.add(summeryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 310, 60));

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
        questionPanel.add(viewPaperButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 560, 130, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("All Question :");
        questionPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 110, 30));

        qCountText.setEditable(false);
        qCountText.setBackground(new java.awt.Color(255, 255, 255));
        qCountText.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        qCountText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        questionPanel.add(qCountText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 60, 30));

        jPanel1.add(questionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1370, 610));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1366, 730);

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

    private void closePanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closePanel1MouseClicked
        endMethod();
    }//GEN-LAST:event_closePanel1MouseClicked

    private void closePanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closePanel1MouseEntered
        closePanel1.setBackground(Color.pink); // TODO add your handling code here:
    }//GEN-LAST:event_closePanel1MouseEntered

    private void closePanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closePanel1MouseExited
        closePanel1.setBackground(Color.white);
    }//GEN-LAST:event_closePanel1MouseExited

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        summeryPanel.removeAll();
        summeryPanel.repaint();
        saveMethod();
        if (qNumber == 1) {

        } else if (qNumber > startQ) {
            --qNumber;
            qNumText.setText(Integer.toString(qNumber));

            goTo(qNumber);

        }

    }//GEN-LAST:event_backButtonMouseClicked

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        backButton.setForeground(Color.black);
    }//GEN-LAST:event_backButtonMouseEntered

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
        backButton.setForeground(Color.WHITE);          // TODO add your handling code here:
    }//GEN-LAST:event_backButtonMouseExited

    private void nextButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonMouseClicked

        summeryPanel.removeAll();
        summeryPanel.repaint();

        saveMethod();
        if (qNumber == endQ) {

        } else {
            ++qNumber;
            qNumText.setText(Integer.toString(qNumber));

            goTo(qNumber);

        }

    }//GEN-LAST:event_nextButtonMouseClicked

    private void nextButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonMouseEntered
        nextButton.setForeground(Color.black);
    }//GEN-LAST:event_nextButtonMouseEntered

    private void nextButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonMouseExited
        nextButton.setForeground(Color.white);
    }//GEN-LAST:event_nextButtonMouseExited

    private void summeryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_summeryButtonMouseClicked
        saveMethod();
        SummeryJPanel DB = new SummeryJPanel(Integer.toString(startQ), Integer.toString(endQ), studentAnswerList, this);
        summeryPanel.removeAll();
        summeryPanel.add(DB);
        summeryPanel.repaint();
        summeryPanel.revalidate();
        DB.setVisible(true);
    }//GEN-LAST:event_summeryButtonMouseClicked

    private void summeryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_summeryButtonMouseEntered
        summeryButton.setForeground(Color.white);
    }//GEN-LAST:event_summeryButtonMouseEntered

    private void summeryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_summeryButtonMouseExited
        summeryButton.setForeground(Color.black);        // TODO add your handling code here:
    }//GEN-LAST:event_summeryButtonMouseExited

    private void viewPaperButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPaperButtonMouseClicked

        try {
            QuestionController qc = ServerConnecter.getServerConnecter().getQuestionController();
            System.out.println("view Path: " + path);
            System.out.println("view FileName: " + fileName);
            ArrayList<Question> allQuestion = qc.getAllQuestion(path + "/" + fileName);

            ViewPaper view = new ViewPaper(fileName, allQuestion);
            view.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(ManageQuestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ManageQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_viewPaperButtonMouseClicked

    private void viewPaperButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPaperButtonMouseEntered
        viewPaperButton.setForeground(new Color(102, 255, 255));
    }//GEN-LAST:event_viewPaperButtonMouseEntered

    private void viewPaperButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPaperButtonMouseExited
        viewPaperButton.setForeground(Color.white);
    }//GEN-LAST:event_viewPaperButtonMouseExited

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
            java.util.logging.Logger.getLogger(Final_Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Final_Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Final_Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Final_Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Practice_Exam().setVisible(true);
//            }
//        });
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Final_Exam().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aText;
    private javax.swing.JRadioButton aa;
    private javax.swing.JTextField bText;
    private javax.swing.JLabel backButton;
    private javax.swing.JRadioButton bb;
    private javax.swing.JTextField cText;
    private javax.swing.JRadioButton cc;
    private javax.swing.JPanel closePanel1;
    private javax.swing.JTextField dText;
    private javax.swing.JRadioButton dd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea mainQText;
    private javax.swing.JPanel minimizePanel;
    private javax.swing.JLabel nextButton;
    private javax.swing.JTextField qCountText;
    private javax.swing.JTextField qNumText;
    private javax.swing.JPanel questionPanel;
    private javax.swing.JLabel summeryButton;
    private javax.swing.JPanel summeryPanel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel viewPaperButton;
    // End of variables declaration//GEN-END:variables

    /**
     *clear text fields
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
     * get question
     */
    public void goTo(int qNumber) {
        //  System.out.println("1");
        if (qNumber <= endQ) {
            //System.out.println("2");

            clear();
            try {
                PracticeExamController pec = ServerConnecter.getServerConnecter().getPracticeExamController();
                Question q = pec.SearchQuestion("Q", Integer.toString(qNumber), path, fileName);
                if (q == null) {

                } else {
                    ////////////set data//////////////
                    qNumText.setText(q.getqNumber());
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

                    setMyAnswers();
                }
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            } catch (IOException ex) {
                Logger.getLogger(ManageQuestion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *save answer
     */
    public void saveMethod() {
        if (studentAnswerList.containsKey(qNumText.getText())) {
            // System.out.println("befor Remove : " + studentAnswerList.get(qNumText.getText()));
            studentAnswerList.remove(qNumText.getText());
            //  System.out.println("Contains: " + studentAnswerList.containsKey(qNumText.getText()));
            boolean s1 = aa.isSelected();
            if (s1) {
                qA = "A";
            } else {
                qA = "*";
            }
            boolean s2 = bb.isSelected();
            if (s2) {
                qB = "B";
            } else {
                qB = "*";
            }
            boolean s3 = cc.isSelected();
            if (s3) {
                qC = "C";
            } else {
                qC = "*";
            }
            boolean s4 = dd.isSelected();
            if (s4) {
                qD = "D";
            } else {
                qD = "*";
            }

            String myQNumber = qNumText.getText();

            String myAnswer = qA + ":" + qB + ":" + qC + ":" + qD;

            studentAnswerList.put(myQNumber, myAnswer);

        } else {
            //////////////////////answers//////////////////////////////
            boolean s1 = aa.isSelected();
            if (s1) {
                qA = "A";
            } else {
                qA = "*";
            }
            boolean s2 = bb.isSelected();
            if (s2) {
                qB = "B";
            } else {
                qB = "*";
            }
            boolean s3 = cc.isSelected();
            if (s3) {
                qC = "C";
            } else {
                qC = "*";
            }
            boolean s4 = dd.isSelected();
            if (s4) {
                qD = "D";
            } else {
                qD = "*";
            }

            String myQNumber = qNumText.getText();

            String myAnswer = qA + ":" + qB + ":" + qC + ":" + qD;
            System.out.println("save Method Call");
            System.out.println("ans: " + myAnswer);
            studentAnswerList.put(myQNumber, myAnswer);

        }
    }

    /**
     *set saved answers
     */
    public void setMyAnswers() {

        if (studentAnswerList.containsKey(qNumText.getText())) {
            String[] answer = studentAnswerList.get(qNumText.getText()).split(":");

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

    /**
     *assign question number
     * @param x
     */
    public void assignValuetoQnumber(int x) {
        this.qNumber = x;
    }

    /**
     *end exam and calculate result
     */
    public void endMethod() {
        saveMethod();
        int correctAns = 0;
        int wrongAns = 0;
        if (isOpen == false) {

            isOpen = true;
//get answers

            for (int i = startQ; i < endQ + 1; i++) {

                try {
                    QuestionController qc = ServerConnecter.getServerConnecter().getQuestionController();
                    correctAnswers.add(qc.getAnswers(path, fileName, i));

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
                            studentAns.append(Integer.toString(i + startQ) + "%" + studentAnswerList.get(Integer.toString(i + startQ)) + "#");
                            ++correctAns;
                            result.add("Correct");
                        } else if (studentAnswerList.get(Integer.toString(i + startQ)).equals("*:*:*:*")) {

                            result.add("Not Answered");
                        } else {
                            studentAns.append(Integer.toString(i + startQ) + "%" + studentAnswerList.get(Integer.toString(i + startQ)) + "#");
                            ++wrongAns;
                            result.add("Wrong");
                        }
                    } else {

                        result.add("Not Answered");
                    }

                }
            }

            try {
                //get One Question mark and pass rate....
                ExamController ec = ServerConnecter.getServerConnecter().getExamController();
                Exam passRate = ec.getPassRate(examId);

                aMarks = Integer.parseInt(passRate.getaMarks());
                bMarks = Integer.parseInt(passRate.getbMarks());
                cMarks = Integer.parseInt(passRate.getcMarks());
                wMarks = Integer.parseInt(passRate.getwMarks());
                marksForOneQuestion = Integer.parseInt(passRate.getMarkForOneQuestion());
                sendMail = passRate.getSendMail();

            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
            }

            marks = correctAns * marksForOneQuestion;

            if (marks >= aMarks) {
                grade = "A";
            } else if (marks >= bMarks) {
                grade = "B";
            } else if (marks >= cMarks) {
                grade = "C";
            } else {
                grade = "W";
            }

            //sendMail
            sendMail();

            //write Exam Result
            writeExamResult();
            //
//            try {
//                StudentController student = ServerConnecter.getServerConnecter().getStudentController();
//                ExamController ec = ServerConnecter.getServerConnecter().getExamController();
//                student.endFinalExam(studentId);
//                ec.deleteExam(examId);
//
//            } catch (RemoteException | NotBoundException | MalformedURLException ex) {
//                Logger.getLogger(Practice_Exam.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
//            }
            //

            //Result report
            PracticeExamResultReport perr = new PracticeExamResultReport();
            perr.setFinalExamData(path, fileName.replace(".txt", ""), studentId, Integer.toString(correctAns), Integer.toString(wrongAns), correctAnswers, studentAnswerList, startQ, endQ, result, grade, Integer.toString(marks));
            perr.setVisible(true);
            this.dispose();

        } else {

        }
    }

    /**
     *send student result to parent email
     */
    public void sendMail() {
        if (sendMail.equals("sendMail")) {
            try {
                AdminController ac = ServerConnecter.getServerConnecter().getAdminController();
                LoginController lc = ServerConnecter.getServerConnecter().getLoginController();
                StudentController sc = ServerConnecter.getServerConnecter().getStudentController();
                String name = sc.getName(studentId);
                String[] instituteEmail = ac.getInstitueEmailPassword().split(":");
                System.out.println("institue Email Password : " + instituteEmail);
                String msg = "Student Name: " + name + "\n" + "Student Id: " + studentId + "\n" + batch + " " + cemester + " " + subject + " " + fileName.replace(".txt", "") + " exam paper\n:  " + "Marks :" + marks + "\t" + "Grade :" + grade;
                String email = sc.getParentEmail(studentId);

                if (email == null) {

                } else {
                    boolean isSend = lc.sendMailTo(email, "IJSE EXAM RESULT", msg, instituteEmail[0], instituteEmail[1]);
                }
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException | javax.mail.MessagingException ex) {

            }

        } else {

        }
    }

    /**
     *save exam result
     */
    public void writeExamResult() {
        studentAns.append("\b");
        System.out.println("St Ans ROW: " + studentAns);
        try {
            ///////////////////////////////////////
            String[] split = path.split("/");
            batch = split[3];
            cemester = split[4];
            subject = split[5];

            ExamController ec = ServerConnecter.getServerConnecter().getExamController();
            String serverDate = ec.getServerDate();

            String[] splits = serverDate.split("#");
            String date = splits[0];
            ///////////////////////////////////////
            String resultPath = batch + "/" + cemester + "/" + subject + "/" + fileName.replace(".txt", "") + "/" + date;

            ResultController rc = ServerConnecter.getServerConnecter().getResultController();
            Result result = new Result(examId, studentId, path, studentAns.toString(), Integer.toString(startQ), Integer.toString(endQ), Integer.toString(marks), grade, resultPath, fileName.replace(".txt", ""));

            boolean addResult = rc.addResult(result);
        } catch (NotBoundException ex) {
            Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Final_Exam.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param count
     * view number of all questions
     */
    public void countSet(int count) {
        qCountText.setText(Integer.toString(count));
    }
}
