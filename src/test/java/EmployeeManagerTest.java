
import com.atuyto.Employee;
import com.atuyto.EmployeeManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class EmployeeManagerTest {

    @Test
    public void testAddEmployee() {
        EmployeeManager manager = new EmployeeManager();
        Employee employee = new Employee("Alice", "Developer", 60000);
        manager.addEmployee(employee);
        assertEquals(1, manager.findEmployeeByName("Alice") != null ? 1 : 0);
    }

    @Test
    public void testRemoveEmployee() {
        EmployeeManager manager = new EmployeeManager();
        Employee employee = new Employee("Bob", "Manager", 70000);
        manager.addEmployee(employee);
        manager.removeEmployee(employee);
        assertNull(manager.findEmployeeByName("Bob"));
    }

    @Test
    public void testAverageSalary() {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(new Employee("Alice", "Developer", 60000));
        manager.addEmployee(new Employee("Bob", "Manager", 70000));
        assertEquals(65000, manager.getAverageSalary());
    }

    @Test
    public void testAverageSalaryEmpty() {
        EmployeeManager manager = new EmployeeManager();
        assertThrows(IllegalStateException.class, () -> manager.getAverageSalary());
    }
}
