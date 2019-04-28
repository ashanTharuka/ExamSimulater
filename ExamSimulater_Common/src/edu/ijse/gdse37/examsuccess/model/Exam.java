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
public class Exam implements Serializable {

    private String examId;
    private String path;
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

    public Exam() {
    }

    public Exam(String examId, String path, String fileName, String startQ, String endQ, String aMarks, String bMarks, String cMarks, String wMarks, String date, String startTime, String timeLimit, String sendMail, String markForOneQuestion, String quizCount, String paperId) {
        this.examId = examId;
        this.path = path;
        this.fileName = fileName;
        this.startQ = startQ;
        this.endQ = endQ;
        this.aMarks = aMarks;
        this.bMarks = bMarks;
        this.cMarks = cMarks;
        this.wMarks = wMarks;
        this.date = date;
        this.startTime = startTime;
        this.timeLimit = timeLimit;
        this.sendMail = sendMail;
        this.markForOneQuestion = markForOneQuestion;
        this.quizCount = quizCount;
        this.paperId = paperId;
    }

    /**
     * @return the examId
     */
    public String getExamId() {
        return examId;
    }

    /**
     * @param examId the examId to set
     */
    public void setExamId(String examId) {
        this.examId = examId;
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

    /**
     * @return the startQ
     */
    public String getStartQ() {
        return startQ;
    }

    /**
     * @param startQ the startQ to set
     */
    public void setStartQ(String startQ) {
        this.startQ = startQ;
    }

    /**
     * @return the endQ
     */
    public String getEndQ() {
        return endQ;
    }

    /**
     * @param endQ the endQ to set
     */
    public void setEndQ(String endQ) {
        this.endQ = endQ;
    }

    /**
     * @return the aMarks
     */
    public String getaMarks() {
        return aMarks;
    }

    /**
     * @param aMarks the aMarks to set
     */
    public void setaMarks(String aMarks) {
        this.aMarks = aMarks;
    }

    /**
     * @return the bMarks
     */
    public String getbMarks() {
        return bMarks;
    }

    /**
     * @param bMarks the bMarks to set
     */
    public void setbMarks(String bMarks) {
        this.bMarks = bMarks;
    }

    /**
     * @return the cMarks
     */
    public String getcMarks() {
        return cMarks;
    }

    /**
     * @param cMarks the cMarks to set
     */
    public void setcMarks(String cMarks) {
        this.cMarks = cMarks;
    }

    /**
     * @return the wMarks
     */
    public String getwMarks() {
        return wMarks;
    }

    /**
     * @param wMarks the wMarks to set
     */
    public void setwMarks(String wMarks) {
        this.wMarks = wMarks;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the timeLimit
     */
    public String getTimeLimit() {
        return timeLimit;
    }

    /**
     * @param timeLimit the timeLimit to set
     */
    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    /**
     * @return the sendMail
     */
    public String getSendMail() {
        return sendMail;
    }

    /**
     * @param sendMail the sendMail to set
     */
    public void setSendMail(String sendMail) {
        this.sendMail = sendMail;
    }

    /**
     * @return the markForOneQuestion
     */
    public String getMarkForOneQuestion() {
        return markForOneQuestion;
    }

    /**
     * @param markForOneQuestion the markForOneQuestion to set
     */
    public void setMarkForOneQuestion(String markForOneQuestion) {
        this.markForOneQuestion = markForOneQuestion;
    }

    /**
     * @return the quizCount
     */
    public String getQuizCount() {
        return quizCount;
    }

    /**
     * @param quizCount the quizCount to set
     */
    public void setQuizCount(String quizCount) {
        this.quizCount = quizCount;
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
public String toString(){return examId;}
   
}
