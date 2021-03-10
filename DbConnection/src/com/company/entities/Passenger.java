package com.company.entities;

public class Passenger {
    private int id; /*initializing variables and setting the access as private*/
    private String name;/*string type*/
    private String surname;
    private String gender;
    private double ticket_price;/*double type*/
    private int flight_num;

    public Passenger() { /*empty constructor*/

    }

    public Passenger(String name, String surname, String gender, double ticket_price, int flight_num) {
        setName(name); /*we already wrote data type in constructor, so now it should be written without data type*/
        setSurname(surname);
        setGender(gender);
        setTicket_price(ticket_price);
        setFlight_num(flight_num);
    }

    public Passenger(int id, String name, String surname, String gender, double ticket_price,int flight_num) {
        /*constructor for getting the data*/
        setId(id);
        setName(name);
        setSurname(surname);
        setGender(gender);
        setTicket_price(ticket_price);
        setFlight_num(flight_num);
    }

    public int getId() {
        return id;
    }
    /*simple get method for getting id of the passenger and returning it back*/

    public void setId(int id) {
        this.id = id;
    }
    /*simple set method for setting the id of the passenger*/

    public String getName() {
        return name;
    }
    /*simple get method for getting name of the passenger and returning it back*/

    public void setName(String name) {
        this.name = name;
    }
    /*simple set method for setting the name of the passenger*/

    public String getSurname() {
        return surname;
    }
    /*simple get method for getting surname of the passenger and returning it back*/

    public void setSurname(String surname) {
        this.surname = surname;
    }
    /*simple set method for setting the surname of the passenger*/

    public String getGender() {
        return gender;
    }
    /*simple get method for getting gender of the passenger and returning it back*/

    public void setGender(String gender) {
        this.gender = gender;
    }
    /*simple set method for setting the gender of the passenger*/

    public double getTicket_price() {
        return ticket_price;
    }
    /*simple get method for getting price of the passenger's ticket and returning it back*/

    public void setTicket_price(double ticket_price) {
        this.ticket_price = ticket_price;
    }
    /*simple set method for setting the price of the passenger's ticket*/

    public void setFlight_num(int flight_num) {
        this.flight_num = flight_num;
    }
    /*simple set method for setting the number of flight of the passenger*/

    public int getFlight_num() {
        return flight_num;
    }
    /*simple get method for getting number of flight and returning it back*/

    @Override /*to change the properties to some values*/
    public String toString() {
        return "Passenger ID : " + getId() + " Passenger name : " + getName() + " Passenger surname : " + getSurname()+ " Passenger gender : "
                +getGender() + " Ticket_price : " + getTicket_price() + " Flight_number : " + getFlight_num();
        /*returning the parameters that we had with their descriptions*/
    }
}
