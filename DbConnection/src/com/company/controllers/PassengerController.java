package com.company.controllers;

import com.company.entities.Passenger;
import com.company.repositories.interfaces.IPassengerRepository;

import java.util.List;

public class PassengerController {
    private final IPassengerRepository repo2;

    public PassengerController(IPassengerRepository repo2) {
        this.repo2 = repo2;
    }

    public String createPassenger(int id, String name, String surname, String gender, Double ticket_price, int flight_num) {
        //boolean male = (gender.toLowerCase().equals("male"));
        Passenger passenger = new Passenger(id,name, surname, gender, ticket_price, flight_num);
        /*Creating the Object Passenger*/
        boolean created = repo2.createPassenger(passenger);

        return (created ? "Passenger was created!" : "Passenger creation was failed!");
        /*If it was created, it will give first statement, otherwise second statement.*/
    }

    public String getPassenger(int id) { /*getting passenger by id he has*/
        Passenger passenger = repo2.getPassenger(id);
        return (passenger == null ? "Passenger was not found!" : passenger.toString());
        /*If Passenger has no value, then it's not found, otherwise it will give values from toString*/
    }

    public String getAllPassengers() { /*getting all passengers that organization can have*/
        List<Passenger> passengers = repo2.getAllPassengers();
        /*Passenger array*/
        return passengers.toString(); /*returning the passengers*/
    }

}