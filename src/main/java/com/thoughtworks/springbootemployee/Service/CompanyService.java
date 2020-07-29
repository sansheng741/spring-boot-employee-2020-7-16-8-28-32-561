package com.thoughtworks.springbootemployee.Service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository, EmployeeRepository employeeRepository) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
    }

    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployeesByCompanyId(Integer companyId){

        return companyRepository.findById(companyId).get().getEmployees();
    }

    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    public Company findCompanyById(Integer id){
        return companyRepository.findById(id).get();
    }

    public List<Company> getCompaniesByPage(Pageable pageable){
        return companyRepository.findAll(pageable).getContent();
    }

    public void addCompany(Company company){
        companyRepository.save(company);
    }

    public void updateCompany(Company newCompany) {
        companyRepository.save(newCompany);
    }

    public void deleteCompany(Integer id){
        employeeRepository.findAll().stream()
                .filter(employee -> employee.getCompany().getCompanyId().equals(id))
                .peek(employee -> employee.setCompany(null))
                .collect(Collectors.toList());
        companyRepository.deleteById(id);

    }
}
