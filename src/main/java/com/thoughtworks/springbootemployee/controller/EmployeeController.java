package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.Service.EmployeeService;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CHENCO9 on 7/28/2020 4:59 PM
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.selectAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployees(@PathVariable("id") Integer id) {
        return employeeService.selectEmployeeById(id);
    }

    @PostMapping("/employees")
    public void addEmployees(Employee employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployees(@PathVariable("id") Integer id) {
        employeeService.delEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    public void updateEmployees(@PathVariable("id") Integer id, Employee employee) {
        employeeService.updateEmployeeById(id, employee);
    }

    @GetMapping("/employees/{page}/{pageSize}")
    public List<Employee> pageQueryEmployee(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        return employeeService.pageQueryEmployee(page, pageSize);
    }

    @GetMapping("/employees/gender={gender}")
    public List<Employee> queryEmployeesByGender(@PathVariable("gender") String gender) {
        return employeeService.selectEmployeeByGender(gender);
    }


}
