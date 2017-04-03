package com.example;

import com.example.rest.EmployeeDAO;
import com.example.rest.EmployeeListDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by natete on 03/04/17.
 */
@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {

    EmployeeDAO edao = new EmployeeListDAO();

//    @RequestMapping(method = RequestMethod.GET)
//    public Employee[] getAll() {
//        return edao.getAllEmployees().toArray(new Employee[0]);
//    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity get(@PathVariable final long id) {

        Employee match = edao.getEmployee(id);

        if (match != null) {
            return new ResponseEntity(match, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getByParams(
            @RequestParam(value = "lastName", defaultValue = "", required = false) final String name,
            @RequestParam(value = "title", defaultValue = "", required = false) final String title,
            @RequestParam(value = "department", defaultValue = "", required = false) final String dept) {

        final List<Employee> matchList = edao
                .getByParams(name, title, dept);

        if (matchList != null) {
            return new ResponseEntity(matchList, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody final Employee employee) {
        try {
            final Employee created = edao.add(employee);
            return new ResponseEntity(created, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity update(@PathVariable final long id, @RequestBody final Employee employee) {
        try {
            final Employee updated = edao.update(id, employee);
            return new ResponseEntity(updated, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity delete(@PathVariable final long id) {
        try {
            edao.delete(id);
            return new ResponseEntity(null, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }
}
