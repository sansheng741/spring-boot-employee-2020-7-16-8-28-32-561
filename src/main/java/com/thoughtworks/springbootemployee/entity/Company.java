package com.thoughtworks.springbootemployee.entity;

import java.util.List;

/**
 * Created by CHENCO9 on 7/28/2020 8:04 PM
 */
public class Company {
    private Integer id;
    private List<Employee> employee;

    public Company() {
    }

    public Company(Integer id, List<Employee> employee) {
        this.id = id;
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
