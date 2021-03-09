package com.company;

import com.company.controllers.PlaneController;
import com.company.repositories.interfaces.IPlaneRepository;

import java.util.Scanner;

public class PlaneFrontend {/*My main application*/
    private final PlaneController controller; /*controller*/
    private final Scanner scanner;

    public PlaneFrontend(IPlaneRepository repo3){
        this.controller=new PlaneController(repo3) ;
        this.scanner=new Scanner(System.in) ;
    }

    public void start() { /*when program starts it should print these lines:*/
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
                int option = scanner.nextInt();
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
    public void createPlaneMenu() { /*creating plane, giving the name, etc*/
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter flight_num");
        int flight_num = scanner.nextInt();
        System.out.println("Please enter plane_company");
        String plane_company = scanner.next();

        String response = controller.createPlane(id,name, flight_num, plane_company);
        System.out.println(response);
    }

    public void getAllPlanesMenu() { /*getting all the planes with their properties*/
        String response = controller.getAllPlanes();
        System.out.println(response);
    }

    public void getPlaneByIdMenu() { /*getting a plane's characteristics by his id*/
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getPlane(id);
        System.out.println(response);
    }

    public void getPlaneNameByIdMenu() {
        /*Getting plane's name by specific id*/
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getPlane(id);
        System.out.println(response);
    }

}