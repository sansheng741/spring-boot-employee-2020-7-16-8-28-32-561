package com.thoughtworks.springbootemployee.entity;

/**
 * Created by CHENCO9 on 7/28/2020 8:04 PM
 */
public class Company {
    private Integer id;
    private Employee employee;

    public Company() {
    }

    public Company(Integer id, Employee employee) {
        this.id = id;
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
