package com.example.mockitohw35.controller;

import com.example.mockitohw35.model.Employee;
import com.example.mockitohw35.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department/employees")
    @ResponseBody
    public Collection<Employee> getAllEmployeesInDepartment(@RequestParam int id) {
        return this.departmentService.getAllEmployeesInDepartment(id);
    }

    @GetMapping("/department/allemployees")
    @ResponseBody
    public Map<Integer, List<Employee>> getAllEmployeesInDepartment() {
        return this.departmentService.getAllEmployees();
    }

    @GetMapping("/department/salary/sum")
    @ResponseBody
    public double getSalarySum(@RequestParam int id) {
        return this.departmentService.getSalarySumInDepartment(id);
    }

    @GetMapping("/department/salary/max")
    @ResponseBody
    public double getSalaryMax(@RequestParam int id) {
        return this.departmentService.getSalaryMaxInDepartment(id);
    }

    @GetMapping("/department/salary/min")
    @ResponseBody
    public double getSalaryMin(@RequestParam int id) {
        return this.departmentService.getSalaryMinInDepartment(id);
    }
}

