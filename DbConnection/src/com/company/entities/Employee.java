package com.company.entities;

public class Employee {
    private int id; /*initializing variables and setting the access as private*/
    private String name; /*string type */
    private String surname;
    private String gender;
    private double salary; /*double type */
    private String position;

    public Employee() { /*empty constructor*/

    }

    public Employee(String name, String surname, String gender, double salary, String position) {
        /*it can be used without id because if we want to edit the data as data serial */
        setName(name); /*we already wrote data type in constructor, so now it should be written without data type*/
        setSurname(surname);
        setGender(gender);
        setSalary(salary);
        setPosition(position);
    }

    public Employee(int id, String name, String surname, String gender, double salary, String position) {
        /*constructor for getting the data with id*/
        setId(id);
        setName(name);
        setSurname(surname);
        setGender(gender);
        setSalary(salary);
        setPosition(position);
    }

    public int getId() {
        return id;
    }
    /*simple get method for getting id of an employee and returning it back*/

    public void setId(int id) {
        this.id = id;
    }
    /*simple set method for setting the id of an employee*/

    public String getName() {
        return name;
    }
    /*simple get method for getting name of an employee and returning it back*/

    public void setName(String name) {
        this.name = name;
    }
    /*simple set method for setting the name of an employee*/

    public String getSurname() {
        return surname;
    }
    /*simple get method for getting surname of an employee and returning it back*/

    public void setSurname(String surname) {
        this.surname = surname;
    }
    /*simple set method for setting the surname of an employee*/

    public String getGender() {
        return gender;
    }
    /*simple get method for getting gender of an employee and returning it back*/

    public void setGender(String gender) {
        this.gender = gender;
    }
    /*simple set method for setting the gender of an employee*/

    public double getSalary() {
        return salary;
    }
    /*simple get method for getting salary of an employee and returning it back*/

    public void setSalary(double salary) {
        this.salary = salary;
    }
    /*simple set method for setting the salary of an employee*/

    public String getPosition() {
        return position;
    }
    /*simple get method for getting position of an employee and returning it back*/

    public void setPosition(String position) {
        this.position = position;
    }
    /*simple set method for setting the position of an employee*/


    @Override /*to change the properties to some values*/
    public String toString() {
        return "Employee ID : " + getId() + " Employee name : " + getName() + " Employee surname : " + getSurname()+ " Employee gender : "
                +getGender() + " Salary : " + getSalary() + " Position: " + getPosition();
        /*returning the parameters that we had with their descriptions*/
    }
}