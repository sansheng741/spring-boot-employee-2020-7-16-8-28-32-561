package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.Service.CompanyService;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CHENCO9 on 7/28/2020 8:07 PM
 */
@RestController
public class CompanyController {


    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public List<Company> queryAllCompany(){
        return companyService.queryAllCompany();
    }

    @GetMapping("/companies/{id}")
    public Company queryCompanyById(Integer id){
        return companyService.queryCompanyById(id);
    }

    @GetMapping("/companies/{id}/employee")
    public List<Employee> queryEmpByCompanyId(Integer id){
        return companyService.queryEmpByCompanyId(id);
    }

    @GetMapping("/companies/{page}/{pageSize}")
    public List<Company> pageQueryCompany(int page,int pageSize){
        return companyService.pageQueryCompany(page,pageSize);
    }

    @PostMapping("companies")
    public void addCompany(Company company){
        companyService.addCompany(company);
    }

    @PutMapping("/companies/{id}")
    public void updateCompanyInfo(Integer id,Company company){
        companyService.updateCompanyInfo(id,company);
    }

    @DeleteMapping("/companies/{id}")
    public void delCompany(Integer id){
        companyService.delCompany(id);
    }
}