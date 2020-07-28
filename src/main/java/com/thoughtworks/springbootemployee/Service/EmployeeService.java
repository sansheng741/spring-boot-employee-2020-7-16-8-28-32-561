package com.thoughtworks.springbootemployee.Service;

import com.thoughtworks.springbootemployee.entity.Employee;

import java.util.List;

/**
 * Created by CHENCO9 on 7/28/2020 5:00 PM
 */
public interface EmployeeService {
    List<Employee> selectAllEmployees();

    Employee selectEmployeeById(Integer id);

    void delEmployeeById(Integer id);

    void updateEmployeeById(Integer id, Employee employee);

    void addEmployee(Employee employee);
}
