package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Assignment {

    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;

    private static int nextId = 1;

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