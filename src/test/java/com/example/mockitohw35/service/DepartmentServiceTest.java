package com.example.mockitohw35.service;
import com.example.mockitohw35.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class )
class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentService departmentService;
    private List<Employee> actualEmployees;
    @BeforeEach
    public void setUp() {
        Employee oleg = new Employee("Oleg", "Olegov", 1, 30000);
        Employee vasia = new Employee("Vasia", "Vasev", 1, 10000);
        Employee sergey = new Employee("Sergey", "Sergeev", 2, 25000);
        Employee vasiliy = new Employee("Vasiliy", "Vasiliev", 2, 15000);

        actualEmployees = new ArrayList<>(List.of (oleg, vasia, sergey, vasiliy));
        when(employeeService.getEmployeesList()).thenReturn(actualEmployees);
    }
    @Test
    public void shouldReturnEmployeesFromDepartment() {
        final int departmentId = 1;
        final List<Employee> actual = new ArrayList<>();
        for (Employee actualEmployee : actualEmployees) {
            if (actualEmployee.getDepartment() == departmentId) {
                actual.add(actualEmployee);
            }
        }

        final List <Employee> expected = departmentService.getAllEmployeesInDepartmentToList(departmentId);
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnAllEmployees() {
        final Map <Integer, List<Employee>> actual = new HashMap<>();
        for (Employee actualEmployee : actualEmployees) {
            List<Employee> employees = new ArrayList<>();
            if (actual.containsKey(actualEmployee.getDepartment())) {
                employees = actual.get(actualEmployee.getDepartment());
            }
            employees.add(actualEmployee);
            actual.put(actualEmployee.getDepartment(), employees);
        }
        final Map<Integer, List<Employee>> expected = departmentService.getAllEmployees();
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnSalarySumFromDepartment() {
        final int departmentId = 1;
        double actual = 0;
        for (Employee actualEmployee : actualEmployees) {
            if (actualEmployee.getDepartment() == departmentId) {
                actual += actualEmployee.getSalary();
            }
        }
        final double expected = departmentService.getSalarySumInDepartment(departmentId);
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnSalaryMinFromDepartment() {
        final int departmentId = 1;
        double actual = Double.MAX_VALUE;
        for (Employee actualEmployee : actualEmployees) {
            if (actualEmployee.getDepartment() == departmentId &&
                    actualEmployee.getSalary() < actual) {
                actual = actualEmployee.getSalary();
            }
        }
        final double expected = departmentService.getSalaryMinInDepartment(departmentId);
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnSalaryMaxFromDepartment() {
        final int departmentId = 2;
        double actual = Double.MIN_VALUE;
        for (Employee actualEmployee : actualEmployees) {
            if (actualEmployee.getDepartment() == departmentId &&
                    actualEmployee.getSalary() > actual) {
                actual = actualEmployee.getSalary();
            }
        }
        final double expected = departmentService.getSalaryMaxInDepartment(departmentId);
        assertEquals(expected, actual);
    }
}
