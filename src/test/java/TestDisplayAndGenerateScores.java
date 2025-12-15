import org.example.Address;
import org.example.Course;
import org.example.Department;
import org.example.Student;

public class TestDisplayAndGenerateScores {
    public static void main(String[] args) {

        Address address = new Address(1111, "Cool", "Montreal", Address.Province.QC, "H2J3U8");

        Department department = new Department("Law");

        Student student = new Student("Bart Simpson", Student.Gender.MALE, address, department);

        Course course = new Course("History", 5.9, department);

        course.registerStudent(student);

        course.addAssignment("Exam1", 20);

        course.generateScores();
        course.displayScores();
    }
}
