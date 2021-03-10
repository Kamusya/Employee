package com.company.data;

import com.company.data.interfaces.IDB;

import java.sql.*;

public class PostgresDB implements IDB {
    /*to access the interface methods, the interface must be implemented*/
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/PostgresDB"; /*name of database*/
        try {
            Class.forName("org.postgresql.Driver"); /*the driver’s class file*/
            /*Connection con = DriverManager.getConnection(connectionUrl, "postgres", "5678a");*/
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "kamilaaman01");
            /*establishing the connection + writing the password from our Database*/
            return con;
        } catch (Exception e) { /*in case the statement in try doesn't work or it's no longer true, it gives exception e*/
            System.out.println(e);
            throw e;
        }
    }
}