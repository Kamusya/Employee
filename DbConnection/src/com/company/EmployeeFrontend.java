package com.company;

import com.company.controllers.EmployeeController;
import com.company.repositories.interfaces.IEmployeeRepository;

import java.util.Scanner;

public class EmployeeFrontend { /*My main application*/
    private final EmployeeController controller; /*controller*/
    private final Scanner scanner;

    public EmployeeFrontend(IEmployeeRepository repo){
        this.controller=new EmployeeController(repo) ;
        this.scanner=new Scanner(System.in) ;
    }

    public void start() { /*when program starts it should print these lines:*/
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all employees");
            System.out.println("2. Get employee by id");
            System.out.println("3. Create employee");
            System.out.println("4. Get salary by employee id");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): "); /*entering numbers will give values*/
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllEmployeesMenu();
                } else if (option == 2) {
                    getEmployeeByIdMenu();
                } else if (option == 3) {
                    createEmployeeMenu();
                } else if (option == 4) {
                    getEmployeeSalaryByIdMenu();

                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }
    public void createEmployeeMenu() { /*creating employee, giving the name, etc*/
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter gender ");
        String gender  = scanner.next();
        System.out.println("Please enter salary ");
        double salary  = scanner.nextDouble();
        String response = controller.createEmployee(name, surname, gender, salary);
        System.out.println(response);
    }

    public void getAllEmployeesMenu() { /*getting all the employees with their properties*/
        String response = controller.getAllEmployees();
        System.out.println(response);
    }

    public void getEmployeeByIdMenu() { /*getting an employee's characteristics by his id*/
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getEmployee(id);
        System.out.println(response);
    }

    public void getEmployeeSalaryByIdMenu() {
        /*Getting employee's salary by specific id, entering if will help to search for exact money*/
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getEmployee(id);
        System.out.println(response);
    }

}


