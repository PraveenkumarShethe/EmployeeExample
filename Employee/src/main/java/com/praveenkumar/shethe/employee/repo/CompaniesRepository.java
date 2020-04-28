package com.praveenkumar.shethe.employee.repo;

import com.praveenkumar.shethe.employee.model.Companies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Praveenkumar on date: 4/28/2020.
 */
@Repository
public interface CompaniesRepository extends CrudRepository<Companies, Long> {
}
