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
public class Subject implements Serializable {

    private String id;
    private String subjectName;

    public Subject() {
    }

    public Subject(String id, String subjectName) {
        this.id = id;
        this.subjectName = subjectName;
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
     * @return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String toString() {
        return id;
    }
}
