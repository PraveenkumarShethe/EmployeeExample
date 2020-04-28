package com.praveenkumar.shethe.employee.controller;

import com.praveenkumar.shethe.employee.model.Department;
import com.praveenkumar.shethe.employee.model.Employees;
import com.praveenkumar.shethe.employee.repo.DepartmentRepository;
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
 * Created by Praveenkumar on date: 4/28/2020.
 */
@RestController
@RequestMapping(value = "/department", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmpRepository empRepository;

    /**
     * @return An iterable of the list of department without filter
     * Http.ok will be returned{@code 200 OK}.
     * Http.NOT_FOUND will be returned if not found {@code 404 Not Found}.
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER)
    public Iterable<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    /**
     * @return An iterable of the list of Department without filter
     * Http.ok will be returned{@code 200 OK}.
     * Http.NOT_FOUND will be returned if not found {@code 404 Not Found}.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER)
    public Optional<Department> getDepartment(@PathVariable("id") Long id) {
        return departmentRepository.findById(id);
    }

    /**
     * Add a new Department to the database.
     *
     * @param department The object to be inserted
     *                   {@code 201 Created}. for creating an object
     *                   {@code 400 Bad Request}. for all other requests
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createNewDepartment(@RequestBody Department department) {
        departmentRepository.save(department);
    }

    /**
     * Add a new Department to the database.
     *
     * @param employees The object to be inserted
     *                   {@code 201 Created}. for creating an object
     *                   {@code 400 Bad Request}. for all other requests
     */
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void updateEmployeeWithDepartment(@RequestBody Employees employees){
        System.out.println("1st value ===============================================================================================>"+employees.getId());
        System.out.println("2nd value ================================================================================================>"+employees.getDepartment().getId());
        Optional<Employees> updateDepartmentEmp = empRepository.findById(employees.getId());
        System.out.println(updateDepartmentEmp);
        Optional<Department> department = departmentRepository.findById(employees.getDepartment().getId());
        updateDepartmentEmp.get().setDepartment(department.get());
        empRepository.save(updateDepartmentEmp.get());
    }

    @RequestMapping(name = "/empbydepart",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER)
    public List<Employees> getAllEmployeeOfDepartment(@RequestBody Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return empRepository.findByDepartment(id);
    }

}
