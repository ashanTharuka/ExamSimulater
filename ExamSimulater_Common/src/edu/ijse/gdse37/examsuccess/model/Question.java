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
public class Question implements Serializable {

    private String qNumber;
    private String paperId;
    private String mainQ;
    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private String qa;
    private String qb;
    private String qc;
    private String qd;
    private String path;
    private String fileName;

    public Question() {
    }

    public Question(String qNumber, String paperId, String mainQ, String q1, String q2, String q3, String q4, String qa, String qb, String qc, String qd, String path, String fileName) {
        this.qNumber = qNumber;
        this.paperId = paperId;
        this.mainQ = mainQ;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.qa = qa;
        this.qb = qb;
        this.qc = qc;
        this.qd = qd;
        this.path = path;
        this.fileName = fileName;
    }

    /**
     * @return the qNumber
     */
    public String getqNumber() {
        return qNumber;
    }

    /**
     * @param qNumber the qNumber to set
     */
    public void setqNumber(String qNumber) {
        this.qNumber = qNumber;
    }

    /**
     * @return the paperId
     */
    public String getPaperId() {
        return paperId;
    }

    /**
     * @param paperId the paperId to set
     */
    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    /**
     * @return the mainQ
     */
    public String getMainQ() {
        return mainQ;
    }

    /**
     * @param mainQ the mainQ to set
     */
    public void setMainQ(String mainQ) {
        this.mainQ = mainQ;
    }

    /**
     * @return the q1
     */
    public String getQ1() {
        return q1;
    }

    /**
     * @param q1 the q1 to set
     */
    public void setQ1(String q1) {
        this.q1 = q1;
    }

    /**
     * @return the q2
     */
    public String getQ2() {
        return q2;
    }

    /**
     * @param q2 the q2 to set
     */
    public void setQ2(String q2) {
        this.q2 = q2;
    }

    /**
     * @return the q3
     */
    public String getQ3() {
        return q3;
    }

    /**
     * @param q3 the q3 to set
     */
    public void setQ3(String q3) {
        this.q3 = q3;
    }

    /**
     * @return the q4
     */
    public String getQ4() {
        return q4;
    }

    /**
     * @param q4 the q4 to set
     */
    public void setQ4(String q4) {
        this.q4 = q4;
    }

    /**
     * @return the qa
     */
    public String getQa() {
        return qa;
    }

    /**
     * @param qa the qa to set
     */
    public void setQa(String qa) {
        this.qa = qa;
    }

    /**
     * @return the qb
     */
    public String getQb() {
        return qb;
    }

    /**
     * @param qb the qb to set
     */
    public void setQb(String qb) {
        this.qb = qb;
    }

    /**
     * @return the qc
     */
    public String getQc() {
        return qc;
    }

    /**
     * @param qc the qc to set
     */
    public void setQc(String qc) {
        this.qc = qc;
    }

    /**
     * @return the qd
     */
    public String getQd() {
        return qd;
    }

    /**
     * @param qd the qd to set
     */
    public void setQd(String qd) {
        this.qd = qd;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String toString() {
        return this.getPaperId();
    }

    public boolean equals(Object ob) {
        if (ob instanceof Question) {
            Question q = (Question) ob;
            return q.getMainQ() == this.getMainQ();

        } else {
            return false;
        }
    }

}
