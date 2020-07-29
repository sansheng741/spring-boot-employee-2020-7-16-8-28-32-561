package com.thoughtworks.springbootemployee.entity;



import javax.persistence.*;
import java.util.List;

/**
 * Created by CHENCO9 on 7/28/2020 8:04 PM
 */
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Integer companyId;
    private String  name;


    @OneToMany(mappedBy = "company")
    private List<Employee> employees;


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
