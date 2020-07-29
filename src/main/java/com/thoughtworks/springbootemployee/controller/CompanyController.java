package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.Service.CompanyService;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> queryAllCompanies() {
        return companyService.findAllCompanies();
    }

    @GetMapping("/{id}")
    public Company queryCompanyById(@PathVariable("id") Integer id) {
        return companyService.findCompanyById(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> queryAllEmployeesByCompanyId(@PathVariable("id") Integer id) {
        return companyService.findAllEmployeesByCompanyId(id);
    }

    @GetMapping(params = {"page", "size"})
    public List<Company> getCompaniesByPage(@PageableDefault(size = 2) Pageable pageable) {
        return companyService.getCompaniesByPage(pageable);
    }

    @PostMapping
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }

    @PutMapping
    public void updateCompany(@RequestBody Company company){
        companyService.updateCompany(company);
    }


}
