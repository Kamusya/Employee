package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Passenger;
import com.company.repositories.interfaces.IPassengerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PassengerRepository implements IPassengerRepository { /*Repository is the storage where is hold data, I means Interface*/
    private final IDB db; /*final means we cannot change its value */

    public PassengerRepository(IDB db) { /*setting the means of database in repository to be same or to be equal with database in here*/
        this.db = db;
    }

    @Override
    public boolean createPassenger(Passenger passenger) { /*create passenger*/
        Connection con = null;
        try { /*getting connection with sql / PGAdmin's values or columns*/
            con = db.getConnection();
            String sql = "INSERT INTO passengers(id, name,surname,gender,ticket_price,flight_num) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, passenger.getId());
            st.setString(2, passenger.getName());/*in first position will be written name*/
            st.setString(3, passenger.getSurname());/*in 2nd position will be written surname*/
            st.setString(4, passenger.getGender());
            st.setDouble(5, passenger.getTicket_price());
            st.setInt(6, passenger.getFlight_num());
            boolean executed = st.execute();
            return true;

        } catch (SQLException throwables) { /*in case try does not work, first exception will happen*/
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Passenger getPassenger(int id) { /*search and get Employee by id*/
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, gender,ticket_price,flight_num FROM passengers WHERE id=?";
            /*searching the id, and by this id we weill get passenger's name, surname, gender and salary*/
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Passenger passenger = new Passenger(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("gender"),
                        rs.getDouble("ticket_price"),
                        rs.getInt("flight_num"));
                return passenger;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Passenger> getAllPassengers() { /*getting all the passenger from overall passenger's table*/
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, gender, ticket_price,flight_num FROM passengers";
            /*all the properties of passenger so that all passengers can be searched*/
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Passenger> passengers = new ArrayList<>();/*setting lost of passengers as new array list*/
            while (rs.next()) { /*while loop*/
                Passenger passenger = new Passenger(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("gender"),
                        rs.getDouble("ticket_price"),
                        rs.getInt("flight_num"));

                passengers.add(passenger);
            }
            return passengers;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public double getTicket_priceById(int id) { /*getting salary by id of an passenger*/
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT ticket_price FROM passenger WHERE id=?";
            /*this means we have exactly id, and it has one passenger, so knowing the id, we can get exact amount of ticket_price*/

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) { /*if loop*/
                double ticket_price = rs.getDouble("ticket_price");
                /*setting value of ticket_price to be equal to the ticket_price that got specific id*/
                return ticket_price; /*just returning ticket_price*/
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1; /*if it has empty space*/
    }
}