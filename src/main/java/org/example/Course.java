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