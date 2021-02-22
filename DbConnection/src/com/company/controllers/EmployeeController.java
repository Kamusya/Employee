package com.company.controllers;

import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepository;

import java.util.List;

public class EmployeeController {
    private final IEmployeeRepository repo;

    public EmployeeController(IEmployeeRepository repo) {
        this.repo = repo;
    }

    public String createEmployee(String name, String surname, String gender, Double salary) {
        boolean male = (gender.toLowerCase().equals("male"));
        Employee employee = new Employee(name, surname, gender, salary);

        boolean created = repo.createEmployee(employee);

        return (created ? "Employee was created!" : "Employee creation was failed!");
    }

    public String getEmployee(int id) { /*getting employee by id he has*/
        Employee employee = repo.getEmployee(id);
        return (employee == null ? "Employee was not found!" : employee.toString());
    }

    public String getAllEmployees() { /*getting all employees that organization can have*/
        List<Employee> employees = repo.getAllEmployees();
        return employees.toString(); /*returning the employees*/
    }

}