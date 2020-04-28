package com.praveenkumar.shethe.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Praveenkumar on date: 4/28/2020.
 */
@Entity
@Table(name = "department")
public class Department extends AbstractEntity{

    @Column(name = "department_name")
    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

}
