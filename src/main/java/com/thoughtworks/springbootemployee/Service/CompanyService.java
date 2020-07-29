package com.thoughtworks.springbootemployee.Service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Employee> findAllEmployeesByCompanyId(Integer companyId){
        return null;
    }

    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }
}
