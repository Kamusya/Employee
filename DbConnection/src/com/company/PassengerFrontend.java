package com.company;

import com.company.controllers.EmployeeController;
import com.company.controllers.PassengerController;
import com.company.controllers.PlaneController;
import com.company.repositories.interfaces.IEmployeeRepository;
import com.company.repositories.interfaces.IPassengerRepository;
import com.company.repositories.interfaces.IPlaneRepository;

import java.util.Scanner;

public class PassengerFrontend {/*My main application*/
    private final PassengerController controller_2; /*controller*/
    private final EmployeeController controller_3; /*controller*/
    private final PlaneController controller_4;

    private final Scanner scanner; /*Scanner*/

    public PassengerFrontend(IPassengerRepository repo2, IEmployeeRepository repo3, IPlaneRepository repo4) {
        this.controller_2=new PassengerController(repo2);
        this.controller_3=new EmployeeController(repo3);
        this.controller_4=new PlaneController(repo4);
        this.scanner=new Scanner(System.in) ;
    }

    public void start() { /*when program starts it should print these lines:*/
        System.out.println("Welcome to AIRLINE RESERVATION SYSTEM! \n");
        System.out.println("Select one of the options: \n");
        System.out.println("1. Employees");
        System.out.println("2. Passengers");
        System.out.println("3. Planes");
        int option = scanner.nextInt();

        if (option == 2) {
            while (true) {
                System.out.println();
                System.out.println("Welcome, dear Passenger.");
                System.out.println("You can select option below \n");
                System.out.println("BUT! If you do not have registered yet, select '3' \n");
                System.out.println("1. Get all passengers");
                System.out.println("2. Get passenger by id");
                System.out.println("3. Create passenger");
                System.out.println("4. Get ticket_price by passenger id");
                System.out.println("0. Exit");
                System.out.println();
                try {
                    System.out.print("Enter option (1-4): "); /*entering numbers will give values*/
                    option = scanner.nextInt();
                    if (option == 1) {
                        getAllPassengersMenu();
                    } else if (option == 2) {
                        getPassengerByIdMenu();
                    } else if (option == 3) {
                        createPassengerMenu();
                    } else if (option == 4) {
                        getPassengerTicket_priceByIdMenu();

                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    scanner.next(); // to ignore incorrect input
                }

                System.out.println("*************************");

            }
        } else if (option == 1) {
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
                    option = scanner.nextInt();
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
        else if (option == 3) {
            while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all planes");
            System.out.println("2. Get plane by id");
            System.out.println("3. Create plane");
            System.out.println("4. Get name by plane id");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): "); /*entering numbers will give values*/
                option = scanner.nextInt();
                if (option == 1) {
                    getAllPlanesMenu();
                } else if (option == 2) {
                    getPlaneByIdMenu();
                } else if (option == 3) {
                    createPlaneMenu() ;
                } else if (option == 4) {
                    getPlaneNameByIdMenu();

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
    }

    public void createPassengerMenu() { /*creating passenger, giving the name, etc*/
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter gender ");
        String gender  = scanner.next();
        System.out.println("Please enter ticket_price");
        double ticket_price  = scanner.nextDouble();
        System.out.println("Please enter flight_num");
        int flight_num = scanner.nextInt();

        String response = controller_2.createPassenger(id,name, surname, gender, ticket_price, flight_num);
        System.out.println(response);
    }

    public void getAllPassengersMenu() { /*getting all the passengers with their properties*/
        String response = controller_2.getAllPassengers();
        System.out.println(response);
    }

    public void getPassengerByIdMenu() { /*getting an passenger's characteristics by his id*/
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller_2.getPassenger(id);
        System.out.println(response);
    }

    public void getPassengerTicket_priceByIdMenu()   {
        /*Getting passenger's ticket_price by specific id, entering if will help to search for exact money*/
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller_2.getPassenger(id);
        System.out.println(response);
    }
        public void createEmployeeMenu() { /*creating employee, giving the name, etc*/
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter gender ");
        String gender  = scanner.next();
        System.out.println("Please enter salary ");
        double salary  = scanner.nextDouble();
        System.out.println("Please enter position ");
            String position = scanner.next();
        String response = controller_3.createEmployee(id,name, surname, gender, salary,position);
        System.out.println(response);
    }
        public void getAllEmployeesMenu() { /*getting all the employees with their properties*/
        String response = controller_3.getAllEmployees();
        System.out.println(response);
    }

    public void getEmployeeByIdMenu() { /*getting an employee's characteristics by his id*/
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller_3.getEmployee(id);
        System.out.println(response);
    }

    public void getEmployeeSalaryByIdMenu() {
        /*Getting employee's salary by specific id, entering if will help to search for exact money*/
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller_3.getEmployee(id);
        System.out.println(response);
    }
        public void createPlaneMenu() { /*creating plane, giving the name, etc*/
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter flight_num");
        int flight_num = scanner.nextInt();
        System.out.println("Please enter plane_company");
        String plane_company = scanner.next();

        String response = controller_4.createPlane(id,name, flight_num, plane_company);
        System.out.println(response);
    }

    public void getAllPlanesMenu() { /*getting all the planes with their properties*/
        String response = controller_4.getAllPlanes();
        System.out.println(response);
    }

    public void getPlaneByIdMenu() { /*getting a plane's characteristics by his id*/
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller_4.getPlane(id);
        System.out.println(response);
    }

    public void getPlaneNameByIdMenu() {
        /*Getting plane's name by specific id*/
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller_4.getPlane(id);
        System.out.println(response);
    }

}
