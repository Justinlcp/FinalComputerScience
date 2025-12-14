package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
public class Student {

    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;

    private static int nextId = 1;

    public enum Gender {
    MALE, FEMALE
    }


    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
        this.studentId = String.format("S%06d", nextId++);
    }

    /**
     * Registers a course, this method (1) adds the course to the student's registeredCourses list,
     * (2) adds the student to the course's registeredStudents list,
     * (3) appends a null for the scores of each assignment of the course.
     * If the course is already registered, it directly returns false without adding anything.
     * @param course the given course to be registered
     * @return True or False to validate the student's desired course to register.
     */
    public boolean registerCourse(Course course) {

        if (registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);

        for (Assignment a : course.getAssignments()) {
            a.getScores().add(null);
        }

        return true;
    }

    /**
     * Drops a course, removes the course from the student's registeredCourses list, and
     * removes the student from the course's registeredStudents list. If the course is not
     * registered yet, it directly returns false without removing anything.
     * @param course the given course to drop
     * @return True or False to validate if the course was registered or not.
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);

        return true;
    }

    public String toSimplifiedString() {
        return studentId + " - " + studentName + " - " + department.getDepartmentName();
    }

    @Override
    public String toString() {
        String result = "Student ID: " + studentId
                + ", Name: " + studentName
                + ", Gender: " + gender
                + ", Address: " + address
                + ", Department: " + department.getDepartmentName()
                + ", Registered Courses: ";

        if (registeredCourses.isEmpty()) {
            result += "None";
        } else {
            for (Course c : registeredCourses) {
                result += "["
                        + c.getCourseId() + " - "
                        + c.getCourseName() + " - "
                        + c.getDepartment().getDepartmentName()
                        + "] ";
            }
        }

        return result;
    }
}