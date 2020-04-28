package com.praveenkumar.shethe.employee.controller;

import com.praveenkumar.shethe.employee.model.Companies;
import com.praveenkumar.shethe.employee.repo.CompaniesRepository;
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
import java.util.Optional;

/**
 * Created by Praveenkumar on date: 4/28/2020.
 */
@RestController
@RequestMapping(value = "/company", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyController {

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
    public Iterable<Companies> getAllCompanies() {
        return companiesRepository.findAll();
    }

    /**
     * @return An iterable of the list of companies without filter
     * Http.ok will be returned{@code 200 OK}.
     * Http.NOT_FOUND will be returned if not found {@code 404 Not Found}.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER)
    public Optional<Companies> getCompany(@PathVariable("id") Long id) {
        return companiesRepository.findById(id);
    }

    /**
     * Add a new Book to the database.
     *
     * @param companies The object to be inserted
     *                  {@code 201 Created}. for creating an object
     *                  {@code 400 Bad Request}. for all other requests
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createNewCompany(@RequestBody Companies companies) {
        companiesRepository.save(companies);
    }


}
