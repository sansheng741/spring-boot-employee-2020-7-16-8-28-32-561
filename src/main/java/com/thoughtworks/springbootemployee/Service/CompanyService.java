package com.thoughtworks.springbootemployee.Service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;

import java.util.List;

/**
 * Created by CHENCO9 on 7/28/2020 8:08 PM
 */
public interface CompanyService {
    List<Company> queryAllCompany();

    Company queryCompanyById(Integer id);

    List<Employee> queryEmpByCompanyId(Integer id);

    List<Company> pageQueryCompany(int page,int pageSize);

    void addCompany(Company company);

    void updateCompanyInfo(Integer id, Company company);

    void delCompany(Integer id);
}
