package com.praveenkumar.shethe.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Praveenkumar on date: 4/28/2020.
 */
@Entity
@Table(name = "project")
public class Project extends AbstractEntity{

    @Column(name = "project_name")
    private String projectName;

    @JoinColumn(name = "department_id")
    @ManyToOne
    private Department department;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
