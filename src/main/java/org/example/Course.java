package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
public class Course {

    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;

    private static int nextId = 1;

    public boolean isAssignmentWeightValid() {
        double sum = 0;

        for (Assignment a : assignments) {
            sum += a.getWeight();
        }

        return sum == 100;
    }

    public boolean registerStudent(Student student) {
        if (student == null || registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);

        for (Assignment a : assignments) {
            while (a.getScores().size() < registeredStudents.size()) {
                a.getScores().add(null);
            }
        }
        return true;
    }

    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double total = 0;

            for (Assignment a : assignments) {
                Integer score = a.getScores().get(i);
                if (score != null) {
                    total += score * (a.getWeight() / 100);
                }
            }
            averages[i] = (int) Math.round(total);
        }
        return averages;
    }

    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment newAssignment = new Assignment(assignmentName, weight);

        for (int i = 0; i < registeredStudents.size(); i++) {
            newAssignment.getScores().add(null);
        }

        assignments.add(newAssignment);
        return true;
    }

    public void generateScores() {
        for (Assignment a : assignments) {
            a.generateRandomScore();
        }
    }

    public void displayScores() {
        System.out.printf("Course: %s (%s)\n", courseName, courseId);

        System.out.printf("%-20s", "Student");
        for (Assignment a : assignments) {
            System.out.printf("%-15s", a.getAssignmentName());
        }
        System.out.printf("%-10s\n", "Final Score");

        int[] finalScores = calcStudentsAverage();

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            System.out.printf("%-20s", student.getStudentName());

            for (Assignment a : assignments) {
                Integer score = a.getScores().get(i);
                System.out.printf("%-15s", score == null ? "-" : score);
            }
            System.out.printf("%-10d\n", finalScores[i]);
        }
        System.out.printf("%-20s", "Average");

        for (Assignment assignment : assignments) {
            System.out.printf("%-15.0f", assignment.calcAssignmentAvg());
        }
        System.out.println();
    }

    public String toSimplifiedString() {
        return courseId + ", " + courseName + ", " + credits + ", " + department.getDepartmentName();
    }

}