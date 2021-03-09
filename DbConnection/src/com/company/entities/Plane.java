package com.company.entities;

public class Plane {
    private int id; /*initializing variables and setting the access as private*/
    private String name;
    private int flight_num;
    private String plane_company;

    public Plane() { /*empty constructor*/

    }

    public Plane(String name, int flight_num, String plane_company ) {
        setName(name); /*we already wrote data type in constructor, so now it should be written without data type*/
        setFlight_num(flight_num);
        setPlane_company(plane_company);
    }

    public Plane(int id, String name,int flight_num, String plane_company) { /*constructor for getting the data*/
        setId(id);
        setName(name);
        setFlight_num(flight_num);
        setPlane_company(plane_company);
    }

    public int getId() {
        return id;
    } /*simple get method for getting id of an employee and returning it back*/

    public void setId(int id) {
        this.id = id;
    } /*simple set method for setting the id of an employee*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlight_num(int flight_num) {
        this.flight_num = flight_num;
    }

    public int getFlight_num() {
        return flight_num;
    }
    public void setPlane_company(String plane_company) {
        this.plane_company = plane_company;
    }

    public String getPlane_company() {
        return plane_company;
    }

    @Override /*to change the properties to some values*/
    public String toString() {
        return "Plane ID : " + getId() + " Plane name : " + getName() + "Flight_number : " + getFlight_num()
                + "Plane_company" + getPlane_company();
        /*returning the parameters that we had with their descriptions*/
    }
}
