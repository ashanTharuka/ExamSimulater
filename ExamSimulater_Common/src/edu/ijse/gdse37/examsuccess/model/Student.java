/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.model;

import java.io.Serializable;

/**
 *
 * @author Ashan Tharuka
 */
public class Student implements Serializable {
    
    private String id;
    private String name;
    private String batch;
    private String email;
    private String phoneNumber;
    private String password;
    private String parentEmail;
    private String imagePath;
    
    public Student() {
    }
    
    public Student(String id, String name, String batch, String email, String phoneNumber, String password, String parentEmail, String imagePath) {
        this.id = id;
        this.name = name;
        this.batch = batch;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.parentEmail = parentEmail;
        this.imagePath = imagePath;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the batch
     */
    public String getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the parentEmail
     */
    public String getParentEmail() {
        return parentEmail;
    }

    /**
     * @param parentEmail the parentEmail to set
     */
    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    /**
     * @return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public boolean equals(Object ob) {
        if (ob instanceof Student) {
            Student s = (Student) ob;
            return s.getId() == this.id;
        } else {
            return false;
        }
        
    }
    
    public String toString(){return id;}
    
}
