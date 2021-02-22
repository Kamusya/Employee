package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final IDB db;

    public EmployeeRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createEmployee(Employee employee) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO users(name,surname,gender,salary) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, employee.getName());
            st.setString(2, employee.getSurname());
            st.setString(3, employee.getGender());
            st.setDouble(4, employee.getSalary());
            boolean executed = st.execute();
            return executed;
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
        return false;
    }

    @Override
    public Employee getEmployee(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, gender, salary FROM employees WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("gender"),
                        rs.getDouble("salary");
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
    public List<Employee> getAllEmployees() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, gender, salary FROM employees";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employee> employees = new ArrayList<>();
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("gender"),
                        rs.getDouble("salary");

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

    //getSalary
    @Override
    public double getSalaryById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT salary FROM employee WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int salary = rs.getInt("salary");

                return salary;
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
        return -1;
    }
}