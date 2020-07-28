package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENCO9 on 7/28/2020 5:11 PM
 */
@Repository
public class Oracle {
    List<Employee> employeeList = new ArrayList<>();
    List<Company> companyList = new ArrayList<>();
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }
}
