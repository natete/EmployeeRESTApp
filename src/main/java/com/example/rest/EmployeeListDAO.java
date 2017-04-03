package com.example.rest;

import com.example.Employee;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * Created by natete on 03/04/17.
 */
public class EmployeeListDAO implements EmployeeDAO {
    private final CopyOnWriteArrayList<Employee> eList = MockEmployeeList.getInstance();

    @Override
    public List<Employee> getAllEmployees() {
        return eList;
    }

    @Override
    public Employee getEmployee(long id) {
        Employee match = null;

        match = eList.stream().filter((e) -> e.getId() == id).findFirst().orElse(match);

        return match;
    }

    @Override
    public List<Employee> getByParams(String name, String title, String dept) {
        List<Employee> matchList = eList.stream()
                                        .filter(e -> e.getLastName().contains(name)
                                                && e.getTitle().contains(title)
                                                && e.getDept().contains(dept))
                                        .collect(Collectors.toList());

        return matchList;
    }

    @Override
    public List<Employee> getByLastName(String name) {
        List<Employee> matchList = eList.stream()
                                        .filter((e) -> e.getLastName().contains(name))
                                        .collect(Collectors.toList());

        return matchList;
    }

    @Override
    public List<Employee> getByTitle(String title) {
        List<Employee> matchList = eList.stream()
                                        .filter((e) -> e.getTitle().contains(title))
                                        .collect(Collectors.toList());

        return matchList;
    }

    @Override
    public List<Employee> getByDept(String dept) {
        List<Employee> matchList = eList.stream()
                                        .filter((e) -> e.getDept().contains(dept))
                                        .collect(Collectors.toList());

        return matchList;
    }

    @Override
    public Employee add(Employee employee) throws Exception {
        long next = eList.size() + 100;

        Employee nextEmployee = new Employee(next, employee.getFirstName(), employee.getLastName(), employee
                .getEmail(), employee.getPhone(), employee.getBirthDate(), employee.getTitle(), employee.getDept());

        eList.add(nextEmployee);
        return nextEmployee;
    }

    @Override
    public Employee update(long id, Employee employee) throws NoSuchElementException {
        int matchIndex = getEmployeeIndex(id);

        if (matchIndex > -1) {
            eList.set(matchIndex, employee);
            return employee;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void delete(long id) throws NoSuchElementException {
        int matchIndex = getEmployeeIndex(id);

        if (matchIndex > -1) {
            eList.remove(matchIndex);
        } else {
            throw new NoSuchElementException();
        }
    }

    private int getEmployeeIndex(long id) {
        int matchIndex = -1;

        matchIndex = eList.stream()
                          .filter(e -> e.getId() == id).findFirst().map(e -> eList.indexOf(e))
                          .orElse(matchIndex);
        return matchIndex;
    }
}
