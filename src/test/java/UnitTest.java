import org.example.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class UnitTest {

    @Test
    @DisplayName("A1B2C3 --> True")
    void testPostalCode1() {
        String code = "A1B2C3";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(code);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("123456 --> False")
    void testPostalCode2() {
        String code = "123456";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(code);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("ABCDEF --> False")
    void testPostalCode3() {
        String code = "ABCDEF";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(code);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Computer Science --> True")
    void testDepartmentName1() {
        String dept = "Computer Science";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(dept);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Chemistry123 --> False")
    void testDepartmentName2() {
        String dept = "Chemistry123";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(dept);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Science! --> False")
    void testDepartmentName3() {
        String dept = "Science!";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(dept);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Scores 60 and 80 --> average = 70")
    void testAssignmentAverage1() {
        Assignment task = new Assignment("Exam", 50, 100);

        ArrayList<Integer> score = new ArrayList<>();
        score.add(60);
        score.add(80);
        task.setScores(score);

        double expected = 70.0;
        double actual = task.calcAssignmentAvg();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("No scores --> 0")
    void testAssignmentAverage2() {
        Assignment task = new Assignment("Exam", 10, 100);

        double expected = 0.0;
        double actual = task.calcAssignmentAvg();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Student add to course --> successful")
    void testRegisterStudent1() {
        Department dept = new Department("French");
        Course classCourse = new Course("Grammar", 5.9, dept);

        Address location = new Address(
                13, "Dog", "Quebec", Address.Province.QC, "A1B2C3"
        );

        Student learner = new Student(
                "Greg", Student.Gender.MALE, location, dept
        );

        boolean expected = true;
        boolean actual = classCourse.registerStudent(learner);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Registering same student twice --> False")
    void testRegisterStudent2() {
        Department dept = new Department("Math");
        Course classCourse = new Course("Geometry", 3.0, dept);

        Address location = new Address(
                20, "King", "Toronto", Address.Province.ON, "A1B2C3"
        );

        Student learner = new Student(
                "Bob", Student.Gender.MALE, location, dept
        );

        classCourse.registerStudent(learner);

        boolean expected = false;
        boolean actual = classCourse.registerStudent(learner);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    @DisplayName("10 + 30 + 60 = 100 --> True")
    void testAssignmentWeight1() {
        Department dept = new Department("Computer Science");
        Course classCourse = new Course("Programming", 5.9, dept);

        classCourse.addAssignment("Exam1", 10, 100);
        classCourse.addAssignment("Exam2", 30, 100);
        classCourse.addAssignment("Final", 60, 100);

        boolean expected = true;
        boolean actual = classCourse.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("20 + 60 is not 100 --> False")
    void testAssignmentWeight2() {
        Department dept = new Department("Computer Science");
        Course classCourse = new Course("Programming", 5.9, dept);

        classCourse.addAssignment("Exam1", 10, 100);
        classCourse.addAssignment("Final", 50, 100);

        boolean expected = false;
        boolean actual = classCourse.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }
}