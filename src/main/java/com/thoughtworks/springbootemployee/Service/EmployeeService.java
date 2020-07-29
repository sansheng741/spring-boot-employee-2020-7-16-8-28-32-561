package com.thoughtworks.springbootemployee.Service;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

/**
 * Created by CHENCO9 on 7/28/2020 5:00 PM
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeByID(Integer id){
        return  employeeRepository.findById(id).get();
    }

    public List<Employee> getEmployeesByPage(Pageable pageable){
        return employeeRepository.findAll(pageable).getContent();
    }


    public List<Employee> getEmployeesByGender(String gender){
        return employeeRepository.findByGender(gender);
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Employee employee){
        employeeRepository.save(employee);
    }

}
