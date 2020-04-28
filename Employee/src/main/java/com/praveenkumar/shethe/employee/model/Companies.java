package com.praveenkumar.shethe.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Praveenkumar on date: 4/28/2020.
 */
@Entity
@Table(name = "companies")
public class Companies extends AbstractEntity{

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "email_domain")
    private String emailDomain;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmailDomain() {
        return emailDomain;
    }

    public void setEmailDomain(String emailDomain) {
        this.emailDomain = emailDomain;
    }
}
