package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository { /*Repository is the storage where is hold data, I means Interface*/
    private final IDB db; /*final means we cannot change its value */

    public EmployeeRepository(IDB db) { /*setting the means of database in repository to be same or to be equal with database in here*/
        this.db = db;
    }

    @Override
    public boolean createEmployee(Employee employee) { /*create employee*/
        Connection con = null;
        try { /*getting connection with sql / PGAdmin's values or columns*/
            con = db.getConnection();
            String sql = "INSERT INTO employee(id,name,surname,gender,salary,position) VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, employee.getId());
            st.setString(2, employee.getName());/*in first position will be written name*/
            st.setString(3, employee.getSurname());/*in 2nd position will be written surname*/
            st.setString(4, employee.getGender());
            st.setDouble(5, employee.getSalary());
            st.setString(6, employee.getPosition());
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
    public Employee getEmployee(int id) { /*search and get Employee by id*/
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, gender, salary, position FROM employee WHERE id=?";
            /*searching the id, and by this id we weill get employee's name, surname, gender and salary*/
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("gender"),
                        rs.getDouble("salary"),
                        rs.getString("position"));
                return employee;
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
    public List<Employee> getAllEmployees() { /*getting all the employees from overall employee's table*/
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, gender, salary, position FROM employee";
            /*all the properties of employee so that all employees can be searched*/
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employee> employees = new ArrayList<>();/*setting lost of employees as new array list*/
            while (rs.next()) { /*while loop*/
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("gender"),
                        rs.getDouble("salary"),
                        rs.getString("position"));
                employees.add(employee);
            }
            return employees;

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
    public double getSalaryById(int id) { /*getting salary by id of an employee*/
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT salary FROM employee WHERE id=?";
            /*this means we have exactly id, and it has one employee, so knowing the id, we can get exact amount of salary*/

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) { /*if loop*/
                double salary = rs.getDouble("salary");
                /*setting value of salary to be equal to the salary that got specific id*/
                return salary; /*just returning salary*/
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