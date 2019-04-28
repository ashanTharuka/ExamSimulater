/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.daosuper;

import edu.ijse.gdse37.examsuccess.model.Student;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface SuperDaoStudent {
    public boolean addStudent(Student student) throws RemoteException, IOException;
    public ArrayList<Student> getAllStudent() throws FileNotFoundException, IOException, RemoteException;
    public Student SearchStudent(String type, String key) throws FileNotFoundException, IOException, RemoteException;
    public boolean deleteStudent(String id) throws IOException, RemoteException;
    public boolean updateStudent(Student student) throws ClassNotFoundException, IOException, RemoteException;
    public boolean searchId(String id) throws RemoteException, FileNotFoundException, IOException;
    public boolean checkPassword(String id, String pass) throws FileNotFoundException, IOException, RemoteException;

    public String getName(String id) throws FileNotFoundException, IOException, RemoteException;
    public String getEmail(String id) throws FileNotFoundException, IOException, RemoteException;
    public String getPasword(String id) throws FileNotFoundException, IOException, RemoteException;
    public ArrayList<Student> getAllEmailofBatch(String batch) throws FileNotFoundException, IOException, RemoteException;
    public String getParentEmail(String id) throws FileNotFoundException, IOException,RemoteException;
    public ArrayList<Student> getAllStudentsOfBatch(String batch) throws FileNotFoundException, IOException,RemoteException;
    public ArrayList<Student> getAllBatchStudents(String batch) throws FileNotFoundException, IOException;
}
