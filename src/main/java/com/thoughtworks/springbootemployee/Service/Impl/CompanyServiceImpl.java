package com.thoughtworks.springbootemployee.Service.Impl;

import com.thoughtworks.springbootemployee.Oracle;
import com.thoughtworks.springbootemployee.Service.CompanyService;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by CHENCO9 on 7/28/2020 8:15 PM
 */
@Service("CompanyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private Oracle oracle;

    @Override
    public List<Company> queryAllCompany() {
        return oracle.getCompanyList();
    }

    @Override
    public Company queryCompanyById(Integer id) {
        for (Company company : oracle.getCompanyList()) {
            if (company.getId().equals(id)) {
                return company;
            }
        }
        return null;
    }

    @Override
    public List<Employee> queryEmpByCompanyId(Integer id) {
        Company company = queryCompanyById(id);
        return company.getEmployee();
    }

    @Override
    public List<Company> pageQueryCompany(Integer page, Integer pageSize) {
        return oracle.getCompanyList().stream().skip((page-1)*pageSize).limit(pageSize).collect(Collectors.toList());
    }

    @Override
    public void addCompany(Company company) {
        oracle.getCompanyList().add(company);
    }

    @Override
    public void updateCompanyInfo(Integer id, Company company) {
        delCompany(id);
        addCompany(company);
    }

    @Override
    public void delCompany(Integer id) {
        oracle.getCompanyList().removeIf(company -> company.getId().equals(id));
    }
}
