package com.praveenkumar.shethe.employee.repo;

import com.praveenkumar.shethe.employee.model.Employees;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Praveenkumar on date: 4/28/2020.
 */
@Repository
public interface EmpRepository extends CrudRepository<Employees, Long> {

//    List<Employees> findByDepartment(long id);

}
