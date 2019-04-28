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
public class Cemester implements Serializable{
    private String id;
    private String cemesterName;

    public Cemester() {
    }

    public Cemester(String id, String cemesterName) {
        this.id = id;
        this.cemesterName = cemesterName;
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
     * @return the cemesterName
     */
    public String getCemesterName() {
        return cemesterName;
    }

    /**
     * @param cemesterName the cemesterName to set
     */
    public void setCemesterName(String cemesterName) {
        this.cemesterName = cemesterName;
    }
    public String toString(){return id;}
}
