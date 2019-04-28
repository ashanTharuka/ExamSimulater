/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.daosuper;

import edu.ijse.gdse37.examsuccess.model.Exam;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface SuperDaoExam {
    public boolean addExam(Exam exam) throws RemoteException, IOException;
    public boolean deleteExam(String examId) throws IOException, RemoteException;
    public Exam SearchExam(String examid) throws FileNotFoundException, IOException, RemoteException;
    public String getNewExamId() throws FileNotFoundException, IOException,RemoteException;
    public ArrayList<Exam> getAllExam() throws FileNotFoundException, IOException,RemoteException;

    public boolean searchExamIdIsAvailable(String examId) throws FileNotFoundException, IOException,RemoteException;
    public boolean updateExam(Exam exam) throws ClassNotFoundException, IOException,RemoteException; 
    public ArrayList<Exam> getUpcomingExam(String path) throws FileNotFoundException, IOException,ParseException,RemoteException;
    public String getServerDate() throws RemoteException;
    
    public Exam getPassRate(String examId) throws FileNotFoundException, IOException,RemoteException;
    public boolean writeExamId(String paperId) throws IOException,RemoteException;
    public boolean IsPaperIdAvailable(String paperId) throws FileNotFoundException, IOException;
    public ArrayList<Exam> getExams(String path) throws FileNotFoundException, IOException;
    public ArrayList<Exam> geAlltExams() throws FileNotFoundException, IOException;
    public boolean IsExamAvailable(String date,String id) throws FileNotFoundException, IOException;
}
