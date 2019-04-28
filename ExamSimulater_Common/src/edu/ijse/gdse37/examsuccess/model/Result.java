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
public class Result implements Serializable {

    private String examId;
    private String studentId;
    private String path;
    private String studentAns;
    private String startQ;
    private String endQ;
    private String marks;
    private String grade;
    private String resultPath;
    private String paperName;

    public Result() {
    }

    public Result(String examId, String studentId, String path, String studentAns, String startQ, String endQ, String marks, String grade, String resultPath, String paperName) {
        this.examId = examId;
        this.studentId = studentId;
        this.path = path;
        this.studentAns = studentAns;
        this.startQ = startQ;
        this.endQ = endQ;
        this.marks = marks;
        this.grade = grade;
        this.resultPath = resultPath;
        this.paperName = paperName;
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
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
     * @return the studentAns
     */
    public String getStudentAns() {
        return studentAns;
    }

    /**
     * @param studentAns the studentAns to set
     */
    public void setStudentAns(String studentAns) {
        this.studentAns = studentAns;
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
     * @return the marks
     */
    public String getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    public void setMarks(String marks) {
        this.marks = marks;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return the resultPath
     */
    public String getResultPath() {
        return resultPath;
    }

    /**
     * @param resultPath the resultPath to set
     */
    public void setResultPath(String resultPath) {
        this.resultPath = resultPath;
    }

    /**
     * @return the paperName
     */
    public String getPaperName() {
        return paperName;
    }

    /**
     * @param paperName the paperName to set
     */
    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }
    

}
