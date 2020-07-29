package com.thoughtworks.springbootemployee;


import com.thoughtworks.springbootemployee.Service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceTest {

    private EmployeeService employeeService;

    public EmployeeServiceTest(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


}
