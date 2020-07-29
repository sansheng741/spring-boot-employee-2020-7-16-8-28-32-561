package com.thoughtworks.springbootemployee;


import com.thoughtworks.springbootemployee.Service.CompanyService;
import com.thoughtworks.springbootemployee.entity.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyServiceTest {

    private final CompanyService companyService;

    public CompanyServiceTest(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Test
    void should_return_modified_company_when_update_company_information_given_1_company(){
        //given 1 company
        Company oldCompany = new Company(1,"oocl",null);
        Company newCompany = new Company(1,"ooocl",null);

    //when update company information
        companyService.addCompany(oldCompany);
        companyService.updateCompany(newCompany);
        String name = companyService.findCompanyById(oldCompany.getCompanyId()).getName();

    //then company information modified
        assertEquals("ooocl",name);
    }
}
