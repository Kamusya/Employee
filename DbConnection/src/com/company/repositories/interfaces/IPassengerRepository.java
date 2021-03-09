package com.company.repositories.interfaces;

import com.company.entities.Passenger;

import java.util.List;

public interface IPassengerRepository { /*I means Interface*/
        boolean createPassenger(Passenger passenger);
        Passenger getPassenger(int id);
        List<Passenger> getAllPassengers();
        double getTicket_priceById(int id) ;
    }
