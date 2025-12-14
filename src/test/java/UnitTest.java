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
        boolean result = true;
        boolean output = Address.isPostalCodeValid(code);
        Assertions.assertEquals(result, output);
    }

    @Test
    @DisplayName("123456 --> False")
    void testPostalCode2() {
        String code = "123456";
        boolean result = false;
        boolean output = Address.isPostalCodeValid(code);
        Assertions.assertEquals(result, output);
    }

    @Test
    @DisplayName("ABCDEF --> False")
    void testPostalCode3() {
        String code = "ABCDEF";
        boolean result = false;
        boolean output = Address.isPostalCodeValid(code);
        Assertions.assertEquals(result, output);
    }

    @Test
    @DisplayName("Computer Science --> True")
    void testDepartmentName1() {
        String dept = "Computer Science";
        boolean result = true;
        boolean output = Department.isDepartmentNameValid(dept);
        Assertions.assertEquals(result, output);
    }

    @Test
    @DisplayName("Chemistry123 --> False")
    void testDepartmentName2() {
        String dept = "Chemistry123";
        boolean result = false;
        boolean output = Department.isDepartmentNameValid(dept);
        Assertions.assertEquals(result, output);
    }

    @Test
    @DisplayName("Science! --> False")
    void testDepartmentName3() {
        String dept = "Science!";
        boolean result = false;
        boolean output = Department.isDepartmentNameValid(dept);
        Assertions.assertEquals(result, output);
    }
}