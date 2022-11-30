package com.example.mockitohw35.service;
import com.example.mockitohw35.model.Employee;
import com.example.mockitohw35.record.EmployeeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
class EmployeeServiceTest {
    public static final Integer KEY_NOT_EXIST = Integer.MAX_VALUE;
    public static final EmployeeRequest NULL_FIRST_NAME = new EmployeeRequest(null, "Ivanov", 1, 10000);
    public static final EmployeeRequest NULL_LAST_NAME = new EmployeeRequest("Ivan", null, 1, 10000);
    public static final EmployeeRequest ILLEGAL_CHARACTERS_FIRST_NAME = new EmployeeRequest("Ivan1", "Ivanov", 1, 10000);
    public static final EmployeeRequest ILLEGAL_CHARACTERS_LAST_NAME = new EmployeeRequest("Ivan", "Ivanovvv22", 1, 10000);
    public static final Employee NULL_EMPLOYEE_FOR_TEST = new Employee(null, null, 1, 1);
    private final EmployeeService out = new EmployeeService();
    private List<Employee> actualEmployees;
    @BeforeEach
    public void setUp (){
        Employee oleg = new Employee("Oleg", "Olegov", 1, 30000);
        EmployeeRequest oleg_request = new EmployeeRequest("Oleg", "Olegov", 1, 30000);
        Employee vasia = new Employee("Vasia", "Vasev", 1, 10000);
        EmployeeRequest vasia_request = new EmployeeRequest("Vasia", "Vasev", 1, 10000);
        Employee sergey = new Employee("Sergey", "Sergeev", 3, 120000);
        EmployeeRequest sergey_request = new EmployeeRequest("Sergey", "Sergeev", 3, 120000);
        Employee vasiliy = new Employee("Vasiliy", "Vasiliev", 2, 15000);
        EmployeeRequest vasiliy_request = new EmployeeRequest("Vasiliy", "Vasiliev", 2, 15000);

        out.addEmployee(oleg_request);
        out.addEmployee(vasia_request);
        out.addEmployee(sergey_request);
        out.addEmployee(vasiliy_request);

        actualEmployees = new ArrayList<>(List.of(oleg, vasia, sergey, vasiliy));
    }
    @Test
    public void shouldReturnFindEmployeeCorrectlyDataEmployees() {
        int departmentId = 7;
        Employee actual = NULL_EMPLOYEE_FOR_TEST;
        for (Employee actualEmployee : actualEmployees) {
            if (actualEmployee.getId() == 3) {
                actual = new Employee(actualEmployee.getFirstName(),
                        actualEmployee.getLastName(),
                        actualEmployee.getDepartment(),
                        actualEmployee.getSalary());
            }
        }
        Employee result = out.findEmployee(departmentId);
        assertEquals(actual, result);
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenFirstNameIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> out.addEmployee(NULL_FIRST_NAME)
        );
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenLastNameIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> out.addEmployee(NULL_LAST_NAME)
        );
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenFirstNameContainsIllegalCharacters() {
        assertThrows(RuntimeException.class,
                () -> out.addEmployee(ILLEGAL_CHARACTERS_FIRST_NAME)
        );
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenLastNameContainsIllegalCharacters() {
        assertThrows(RuntimeException.class,
                () -> out.addEmployee(ILLEGAL_CHARACTERS_LAST_NAME)
        );
    }
    @Test
    public void shouldThrowRuntimeExceptionFindWhenIdNotExist() {
        assertThrows(RuntimeException.class,
                () -> out.findEmployee(KEY_NOT_EXIST)
        );
    }
    @Test
    public void shouldThrowRuntimeExceptionRemoveWhenIdNotExist() {
        assertThrows(RuntimeException.class,
                () -> out.removeEmployee(KEY_NOT_EXIST)
        );
    }
     @Test
    public void shouldReturnSalaryWhenCorrectlyDataEmployees() {
        double actual = 0;
        for (Employee actualEmployee : actualEmployees) {
            actual += actualEmployee.getSalary();
        }
        double result = out.getSalarySum();
        assertEquals(actual, result);
    }
    @Test
    public void shouldReturnAverageSalaryWhenCorrectlyDataEmployees() {
        double actual = 0;
        double sum = 0;
        for (Employee actualEmployee : actualEmployees) {
            sum += actualEmployee.getSalary();
        }
        actual = sum / actualEmployees.size();
        double result = out.getAverageSum();
        assertEquals(actual, result);
    }
    @Test
    public void shouldReturnMinSalaryWhenCorrectlyDataEmployees() {
        double min = Double.MAX_VALUE;
        Employee actual = NULL_EMPLOYEE_FOR_TEST;
        for (Employee actualEmployee : actualEmployees) {
            if (actualEmployee.getSalary() < min) {
                min = actualEmployee.getSalary();
                actual = new Employee(actualEmployee.getFirstName(),
                        actualEmployee.getLastName(),
                        actualEmployee.getDepartment(),
                        actualEmployee.getSalary());
            }
        }
        Employee result = out.getSalaryMin();
        assertEquals(actual, result);
    }
    @Test
    public void shouldReturnMaxSalaryWhenCorrectlyDataEmployees() {
        double max = Double.MIN_VALUE;
        Employee actual = NULL_EMPLOYEE_FOR_TEST;
        for (Employee actualEmployee : actualEmployees) {
            if (actualEmployee.getSalary() > max) {
                max = actualEmployee.getSalary();
                actual = new Employee(actualEmployee.getFirstName(),
                        actualEmployee.getLastName(),
                        actualEmployee.getDepartment(),
                        actualEmployee.getSalary());
            }
        }
        Employee result = out.getSalaryMax();
        assertEquals(actual, result);
    }
}
