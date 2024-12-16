
import com.atuyto.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void testEmployeeCreation() {
        Employee employee = new Employee("Alice", "Developer", 60000);
        assertEquals("Alice", employee.getName());
        assertEquals("Developer", employee.getRole());
        assertEquals(60000, employee.getSalary());
    }

    @Test
    public void testSetSalary() {
        Employee employee = new Employee("Bob", "Manager", 70000);
        employee.setSalary(75000);
        assertEquals(75000, employee.getSalary());
    }

    @Test
    public void testSetSalaryInvalid() {
        Employee employee = new Employee("Charlie", "Designer", 50000);
        assertThrows(IllegalArgumentException.class, () -> employee.setSalary(-1000));
    }

    @Test
    public void testEmployeeToString() {
        Employee employee = new Employee("David", "QA", 55000);
        String expected = "Employee{name='David', role='QA', salary=55000.0}";
        assertEquals(expected, employee.toString());
    }
}
