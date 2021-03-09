package com.company;

import com.company.controllers.PassengerController;
import com.company.repositories.interfaces.IPassengerRepository;

import java.util.Scanner;

public class PassengerFrontend {/*My main application*/
    private final PassengerController controller; /*controller*/
    private final Scanner scanner;

    public PassengerFrontend(IPassengerRepository repo2){
        this.controller=new PassengerController(repo2) ;
        this.scanner=new Scanner(System.in) ;
    }

    public void start() { /*when program starts it should print these lines:*/
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all passengers");
            System.out.println("2. Get passenger by id");
            System.out.println("3. Create passenger");
            System.out.println("4. Get ticket_price by passenger id");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): "); /*entering numbers will give values*/
                int option = scanner.nextInt();
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

        String response = controller.createPassenger(id,name, surname, gender, ticket_price, flight_num);
        System.out.println(response);
    }

    public void getAllPassengersMenu() { /*getting all the passengers with their properties*/
        String response = controller.getAllPassengers();
        System.out.println(response);
    }

    public void getPassengerByIdMenu() { /*getting an passenger's characteristics by his id*/
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getPassenger(id);
        System.out.println(response);
    }

    public void getPassengerTicket_priceByIdMenu() {
        /*Getting passenger's ticket_price by specific id, entering if will help to search for exact money*/
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getPassenger(id);
        System.out.println(response);
    }

}
