package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Assignment {

    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;

    private static int nextId = 1;

    /**
     * Generates random scores for all students in an assignment, the scores are generated
     * with the following rule: Firstly generate a random number in range [0, 10], then
     * if the number is 0, then generate a random score in range [0, 60) for the student;
     * if the number is 1, 2, then generate a random score in range [60, 70) for the student;
     * if the number is 3, 4, then generate a random score in range [70, 80) for the student;
     * if the number is 5, 6, 7, 8, then generate a random score in range [80, 90) for the student;
     * if the number is 9, 10, then generate a random score in range [90, 100] for the student;
     */
    public void generateRandomScore() {
        Random rand = new Random();

        for (int i = 0; i < scores.size(); i++) {
            int randomNum = rand.nextInt(11);
            int score;

            if (randomNum == 0) {
                score = rand.nextInt(60);
            } else if (randomNum == 1 || randomNum == 2) {
                score = 60 + rand.nextInt(10);
            } else if (randomNum == 3 || randomNum == 4) {
                score = 70 + rand.nextInt(10);
            } else if (randomNum >= 5 && randomNum <= 8) {
                score = 80 + rand.nextInt(10);
            } else {
                score = 90 + rand.nextInt(11);
            }

            scores.set(i, score);
        }
    }

    /**
     * Calculates the average score for the assignment.
     * @return the average score for the assignment.
     */
    public double calcAssignmentAvg() {
        if (scores.isEmpty()) return 0;

        int sum = 0;
        int amountOfGrades = 0;
        for (Integer score : scores) {
            if (score != null) {
                sum += score;
                amountOfGrades++;
            }
        }
        return amountOfGrades == 0 ? 0 : (double) sum / amountOfGrades;
    }
}