/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.observerble;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Ashan Tharuka
 */
public class StudentObserverble {

    private static HashMap<String, String> finalExamList = new HashMap<>();
    private static HashMap<String, String> practiceExamList = new HashMap<>();

    /**
     *
     * @param studentId
     * @param paperId
     */
    public void startPracticeExam(String studentId, String paperId) {
        practiceExamList.put(studentId, paperId);
    }

    /**
     *
     * @param studentId
     */
    public void endPracticeExam(String studentId) {
        practiceExamList.remove(studentId);

    }

    /**
     *
     * @param studentId
     * @param paperId
     */
    public void startFinalExam(String studentId, String paperId) {
        practiceExamList.put(studentId, paperId);
    }

    /**
     *
     * @param studentId
     */
    public void endFinalExam(String studentId) {
        practiceExamList.remove(studentId);

    }

    /**
     *
     * @param paperId
     * @return
     */
    public boolean IsAvailablePracticeExam(String paperId) {
        boolean ans = false;
        Collection<String> practice = practiceExamList.values();

        for (String pId : practice) {
            if (pId.equals(paperId)) {
                return true;

            } else {
                ans = false;
            }

        }
        return ans;

    }

    /**
     *
     * @param paperId
     * @return
     */
    public boolean IsAvailableFinalExam(String paperId) {
        boolean ans = false;
        Collection<String> practice = practiceExamList.values();

        for (String pId : practice) {
            if (pId.equals(paperId)) {
                return true;

            } else {
                ans = false;
            }

        }
        return ans;

    }
}
