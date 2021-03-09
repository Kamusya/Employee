package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.EmployeeRepository;
import com.company.repositories.interfaces.IEmployeeRepository;

public class Main {

    public static void main(String[] args) {

        // Here you specify which DB and UserRepository to use
        // And changing DB should not affect to whole code
        IDB db = new PostgresDB(); /*connecting databases*/
        IEmployeeRepository repo = new EmployeeRepository(db); /*connecting repository (storage) and database*/
        EmployeeFrontend app = new EmployeeFrontend(repo);
        app.start(); /*command for start*/
    }
}
