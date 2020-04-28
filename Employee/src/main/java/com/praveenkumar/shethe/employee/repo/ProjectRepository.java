package com.praveenkumar.shethe.employee.repo;

import com.praveenkumar.shethe.employee.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Praveenkumar on date: 4/28/2020.
 */
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
