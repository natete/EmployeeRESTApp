package com.example.rest;

import com.example.Employee;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by natete on 03/04/17.
 */
public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public Employee getEmployee(long id);

    List<Employee> getByParams(String name, String title, String     dept);

    public List<Employee> getByLastName(String name);

    public List<Employee> getByTitle(String title);

    public List<Employee> getByDept(String dept);

    public Employee add(Employee employee) throws Exception;

    public Employee update(long id, Employee employee) throws NoSuchElementException;

    public void delete(long id) throws NoSuchElementException;
}
