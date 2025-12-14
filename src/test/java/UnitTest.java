import org.example.Address;
import org.example.Department;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;

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
}