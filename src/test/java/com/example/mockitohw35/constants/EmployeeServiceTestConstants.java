package com.example.mockitohw35.constants;


import com.example.mockitohw35.model.Employee;
import com.example.mockitohw35.record.EmployeeRequest;

import java.util.List;

public class EmployeeServiceTestConstants {

    public static final Integer KEY_NOT_EXIST = Integer.MAX_VALUE;
    public static final EmployeeRequest NULL_FIRST_NAME = new EmployeeRequest(null, "Sidorov", 2, 35000);
    public static final EmployeeRequest NULL_LAST_NAME = new EmployeeRequest("Oleg", null, 1, 1000);
    public static final EmployeeRequest ILLEGAL_CHARACTERS_FIRST_NAME = new EmployeeRequest("Olga", "Ivanova", 2, 54000);
    public static final EmployeeRequest ILLEGAL_CHARACTERS_LAST_NAME = new EmployeeRequest("Sergey", "Sergeev", 3, 25500);
    public static final EmployeeRequest OLEG_REQUEST = new EmployeeRequest("Oleg", "Olegov", 1, 30000);
    public static final Employee OLEG = new Employee("Oleg", "Olegov", 1, 30000);
    public static final EmployeeRequest VASIA_REQUEST = new EmployeeRequest("Vasia", "Vasev", 1, 10000);
    public static final Employee VASIA = new Employee("Vasia", "Vasev", 1, 10000);
    public static final EmployeeRequest SERGEY_REQUEST = new EmployeeRequest("Sergey", "Sergeev", 3, 120000);
    public static final Employee SERGEY = new Employee("Sergey", "Sergeev",  3, 120000);
    public static final EmployeeRequest VASILIY_REQUEST = new EmployeeRequest("Vasiliy", "Vasiliev", 1, 175000);
    public static final Employee VASILIY = new Employee("Vasiliy", "Vasiliev",1, 175000);

    public static final List<Employee> EMPLOYEE_LIST = List.of(
            OLEG,
            VASIA,
            SERGEY,
            VASILIY
    );

}
