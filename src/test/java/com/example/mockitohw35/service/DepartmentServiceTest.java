package com.example.mockitohw35.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.mockitohw35.constants.EmployeeServiceTestConstants.EMPLOYEE_LIST;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private EmployeeService repositoryMock;

    @InjectMocks
    private DepartmentService out;

    @Test
    public void shouldReturnCollectionOfTeamsWhenFindAllTeamsCalled() {
        when(repositoryMock.getAllEmployees())
                .thenReturn(EMPLOYEE_LIST);

        assertIterableEquals(EMPLOYEE_LIST, out.getAllEmployeesInDepartment(1));
    }








}
