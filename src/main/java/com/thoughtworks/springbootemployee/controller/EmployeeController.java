package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.Service.EmployeeService;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CHENCO9 on 7/28/2020 4:59 PM
 */
@RestController
@RequestMapping("employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable("id") Integer id) {
        return employeeService.findEmployeeByID(id);
    }

    @GetMapping(params = {"page", "size"})
    public List<Employee> getEmployeesByPage(@PageableDefault(size = 2) Pageable pageable) {
        return employeeService.getEmployeesByPage(pageable);
    }

    @GetMapping(params = {"gender"})
    public List<Employee> getEmployeesByGender(@RequestParam String gender) {
        return employeeService.getEmployeesByGender(gender);
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }


}
