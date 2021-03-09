package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.entities.Passenger;
import com.company.repositories.EmployeeRepository;
import com.company.repositories.PassengerRepository;
import com.company.repositories.PlaneRepository;
import com.company.repositories.interfaces.IEmployeeRepository;
import com.company.repositories.interfaces.IPassengerRepository;
import com.company.repositories.interfaces.IPlaneRepository;

public class Main {

    public static void main(String[] args) {

        // Here you specify which DB and UserRepository to use
        // And changing DB should not affect to whole code
        IDB db = new PostgresDB(); /*connecting databases*/
        IEmployeeRepository repo = new EmployeeRepository(db); /*connecting repository (storage) and database*/
        EmployeeFrontend app = new EmployeeFrontend(repo);
        IPassengerRepository repo2 = new PassengerRepository(db); /*connecting repository (storage) and database*/
        PassengerFrontend app2 = new PassengerFrontend(repo2);
        IPlaneRepository repo3 = new PlaneRepository(db); /*connecting repository (storage) and database*/
        PlaneFrontend app3 = new PlaneFrontend(repo3);
        app.start(); /*command for start*/
        app2.start();
        app3.start();

    }
}
