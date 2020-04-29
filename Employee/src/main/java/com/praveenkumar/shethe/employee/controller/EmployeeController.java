package com.praveenkumar.shethe.employee.controller;

import com.praveenkumar.shethe.employee.model.Companies;
import com.praveenkumar.shethe.employee.model.Employees;
import com.praveenkumar.shethe.employee.repo.CompaniesRepository;
import com.praveenkumar.shethe.employee.repo.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by Praveenkumar on 4/28/2020.
 * Controller class to handle REST API calles to /employee/**
 */
@RestController
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private CompaniesRepository companiesRepository;

    /**
     * @return An iterable of the list of Employees without filter
     * Http.ok will be returned{@code 200 OK}.
     * Http.NOT_FOUND will be returned if not found {@code 404 Not Found}.
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER)
    public Iterable<Employees> getAllEmployee() {
        return empRepository.findAll();
    }

    /**
     * @return An iterable of the list of Employees without filter
     * Http.ok will be returned{@code 200 OK}.
     * Http.NOT_FOUND will be returned if not found {@code 404 Not Found}.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER)
    public Optional<Employees> getEmployee(@PathVariable("id") Long id) {
        return empRepository.findById(id);
    }

    /**
     * Add a new Book to the database.
     *
     * @param employees The object to be inserted
     *                  {@code 201 Created}. for creating an object
     *                  {@code 400 Bad Request}. for all other requests
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createNewEmployee(@RequestBody Employees employees) {
        empRepository.save(employees);
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER)
    public List<Employees> getCompanyEmployee(@PathVariable("id") Long id) {
        Companies companies = companiesRepository.findById(id).get();
        List<Employees> employees = companies.getEmployees();

        return companiesRepository.findById(id).get().getEmployees();
    }

}
