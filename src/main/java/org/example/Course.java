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

    public Course(String courseName, double credits, Department department) {
        this.courseName = util.Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;

        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);

        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }

    /**
     * Checks if the sum of weights of all assignments of that course equals to 100%.
     * @return True or False as the validity of the assignment weight
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0;

        for (Assignment a : assignments) {
            sum += a.getWeight();
        }

        return sum == 100;
    }

    /**
     * adds a student to the student list of the course, also add a new null element to each
     * assignment of this course, and add a new null element for the finalScores.
     * @param student the given student to be added to the list
     * @return True or False to whether the student was registered or not
     */
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

    /**
     * calculates the weighted average score of a student.
     * @return the average of the student
     */
    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double total = 0;

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    total += score * (assignment.getWeight() / 100);
                }
            }
            averages[i] = (int) Math.round(total);
        }
        return averages;
    }

    /**
     * Adds a new assignment to the course.
     * @param assignmentName the given assignment name
     * @param weight the weight of the assignment
     * @return True or False to whether the new assignment can be added to the course
     */
    public boolean addAssignment(String assignmentName, double weight) {
        Assignment newAssignment = new Assignment(assignmentName, weight);

        for (int i = 0; i < registeredStudents.size(); i++) {
            newAssignment.getScores().add(null);
        }

        assignments.add(newAssignment);
        return true;
    }

    /**
     * Generates random scores for each assignment and student, and calculates the final
     * score for each student.
     */
    public void generateScores() {
        for (Assignment a : assignments) {
            a.generateRandomScore();
        }
    }

    /**
     *  Displays the scores of a course in a table, with the assignment averages and student
     *  weighted average.
     */
    public void displayScores() {
        System.out.printf("Course: %s (%s)\n", courseName, courseId);

        System.out.printf("%-20s", "Student");
        for (Assignment a : assignments) {
            System.out.printf("%-15s", a.getAssignmentName());
        }
        System.out.printf("%-10s\n", "Final");

        int[] finalScores = calcStudentsAverage();

        for (int i = 0; i < registeredStudents.size(); i++) {
            System.out.printf("%-20s", registeredStudents.get(i).getStudentName());

            for (Assignment a : assignments) {
                Integer score = a.getScores().get(i);
                System.out.printf("%-15s", score == null ? "-" : score);
            }

            System.out.printf("%-10d\n", finalScores[i]);
        }

        System.out.printf("%-20s", "Average");
        for (Assignment a : assignments) {
            System.out.printf("%-15.0f", a.calcAssignmentAvg());
        }
        System.out.println();
    }

    public String toSimplifiedString() {
        return courseId + ", " + courseName + ", " + credits + ", " + department.getDepartmentName();
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName=" + courseName +
                ", credits=" + credits +
                ", department=" + department.getDepartmentName() +
                ", registeredStudents=" + registeredStudents.size() +
                ", weightValid=" + isAssignmentWeightValid() +
                '}';
    }
}