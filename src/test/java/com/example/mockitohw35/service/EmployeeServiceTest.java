package com.example.mockitohw35.service;

import com.example.mockitohw35.model.Employee;
import org.junit.jupiter.api.Test;

import static com.example.mockitohw35.constants.EmployeeServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeServiceTest {

    private final EmployeeService out = new EmployeeService();

    @Test
    public void shouldReturnFindEmployeeCorrectlyDataEmployees() {
        out.addEmployee(OLEG_REQUEST);
        out.addEmployee(VASIA_REQUEST);
        out.addEmployee(SERGEY_REQUEST);
        out.addEmployee(VASILIY_REQUEST);
        Employee result = out.findEmployee(7);
        assertEquals(SERGEY, result);
    }

    @Test
    public void shouldReturnAddEmployeesWhenCorrectlyDataEmployees() {
        Employee result = out.addEmployee(SERGEY_REQUEST);
        assertEquals(result, SERGEY);
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
    public void shouldThrowRuntimeExceptionRemoveWhenIdNotExist() {
        assertThrows(RuntimeException.class,
                () -> out.removeEmployee(KEY_NOT_EXIST)
        );
    }

    @Test
    public void shouldThrowRuntimeExceptionFindWhenIdNotExist() {
        assertThrows(RuntimeException.class,
                () -> out.findEmployee(KEY_NOT_EXIST)
        );
    }


    @Test
    public void shouldReturnSalaryWhenCorrectlyDataEmployees() {
        out.addEmployee(OLEG_REQUEST);
        out.addEmployee(VASIA_REQUEST);
        out.addEmployee(SERGEY_REQUEST);
        out.addEmployee(VASILIY_REQUEST);
        double result = out.getSalarySum();
        assertEquals(OLEG.getSalary() + VASIA.getSalary() + SERGEY.getSalary() + VASILIY.getSalary(), result);
    }

    @Test
    public void shouldReturnAverageSalaryWhenCorrectlyDataEmployees() {
        out.addEmployee(OLEG_REQUEST);
        out.addEmployee(VASIA_REQUEST);
        out.addEmployee(SERGEY_REQUEST);
        out.addEmployee(VASILIY_REQUEST);
        double result = out.getAverageSum();
        assertEquals((OLEG.getSalary() + VASIA.getSalary() + SERGEY.getSalary() + VASILIY.getSalary()) / 4, result);
    }

    @Test
    public void shouldReturnMinSalaryWhenCorrectlyDataEmployees() {
        out.addEmployee(OLEG_REQUEST);
        out.addEmployee(VASIA_REQUEST);
        out.addEmployee(SERGEY_REQUEST);
        out.addEmployee(VASILIY_REQUEST);
        Employee result = out.getSalaryMin();
        assertEquals(VASIA, result);
    }

    @Test
    public void shouldReturnMaxSalaryWhenCorrectlyDataEmployees() {
        out.addEmployee(OLEG_REQUEST);
        out.addEmployee(VASIA_REQUEST);
        out.addEmployee(SERGEY_REQUEST);
        out.addEmployee(VASILIY_REQUEST);
        Employee result = out.getSalaryMax();
        assertEquals(OLEG, result);
    }


}
