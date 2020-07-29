package com.thoughtworks.springbootemployee.Service.Impl;

import com.thoughtworks.springbootemployee.Oracle;
import com.thoughtworks.springbootemployee.Service.EmployeeService;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by CHENCO9 on 7/28/2020 5:03 PM
 */
@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private Oracle oracle;

    @Override
    public List<Employee> selectAllEmployees() {
        return oracle.getEmployeeList();
    }

    @Override
    public Employee selectEmployeeById(Integer id) {
        for (Employee employee : oracle.getEmployeeList()) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void delEmployeeById(Integer id) {
        oracle.getEmployeeList().removeIf(employee -> employee.getId().equals(id));
    }

    @Override
    public void updateEmployeeById(Integer id, Employee employee) {
        delEmployeeById(id);
        addEmployee(employee);
    }

    @Override
    public void addEmployee(Employee employee) {
        oracle.getEmployeeList().add(employee);
    }

    @Override
    public List<Employee> pageQueryEmployee(Integer page, Integer pageSize) {
        return oracle.getEmployeeList().stream().skip((page-1)*pageSize).limit(pageSize).collect(Collectors.toList());
    }

    @Override
    public List<Employee> selectEmployeeByGender(String gender) {

        return  oracle.getEmployeeList().stream().filter(e->e.getGender().equals(gender)).collect(Collectors.toList());

    }
}
