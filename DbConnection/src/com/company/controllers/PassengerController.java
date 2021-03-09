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
        boolean male = (gender.toLowerCase().equals("male"));
        Passenger passenger = new Passenger(id,name, surname, gender, ticket_price, flight_num);

        boolean created = repo2.createPassenger(passenger);

        return (created ? "Passenger was created!" : "Passenger creation was failed!");
    }

    public String getPassenger(int id) { /*getting passenger by id he has*/
        Passenger passenger = repo2.getPassenger(id);
        return (passenger == null ? "Passenger was not found!" : passenger.toString());
    }

    public String getAllPassengers() { /*getting all passengers that organization can have*/
        List<Passenger> passengers = repo2.getAllPassengers();
        return passengers.toString(); /*returning the passengers*/
    }

}