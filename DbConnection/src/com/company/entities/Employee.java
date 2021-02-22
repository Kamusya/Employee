package com.company.entities;

public class Employee {
    private int id; /*initializing variables and setting the access as private*/
    private String name;
    private String surname;
    private String gender;
    private double salary;

    public Employee() { /*empty constructor*/

    }

    public Employee(String name, String surname, String gender, double salary) {
        setName(name); /*we already wrote data type in constructor, so now it should be written without data type*/
        setSurname(surname);
        setGender(gender);
        setSalary(salary);
    }

    public Employee(int id, String name, String surname, String gender, double salary) { /*constructor for getting the data*/
        setId(id);
        setName(name);
        setSurname(surname);
        setGender(gender);
        setSalary(salary);
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override /*to change the properties to some values*/
    public String toString() {
        return "Employee ID : " + getId() + " Employee name : " + getName() + " Employee surname : " + getSurname()+ " Employee gender : "
                +getGender() + " Salary : " + getSalary();
        /*returning the parameters that we had with their descriptions*/
    }
}