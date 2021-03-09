package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Plane;
import com.company.repositories.interfaces.IPlaneRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PlaneRepository implements IPlaneRepository { /*Repository is the storage where is hold data, I means Interface*/
    private final IDB db; /*final means we cannot change its value */

    public PlaneRepository(IDB db) { /*setting the means of database in repository to be same or to be equal with database in here*/
        this.db = db;
    }

    @Override
    public boolean createPlane(Plane plane) { /*create plane*/
        Connection con = null;
        try { /*getting connection with sql / PGAdmin's values or columns*/
            con = db.getConnection();
            String sql = "INSERT INTO planes(id, name,flight_num, plane_company) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, plane.getId());
            st.setString(2, plane.getName());/*in first position will be written name*/
            st.setInt(3, plane.getFlight_num());
            st.setString(4, plane.getPlane_company());
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
    public Plane getPlane(int id) { /*search and get Plane by id*/
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name,flight_num, plane_company FROM planes WHERE id=?";
            /*searching the id, and by this id we weill get plane's name, flight_num, plane_company*/
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Plane plane = new Plane(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("flight_num"),
                        rs.getString("plane_company"));
                return plane;
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
    public List<Plane> getAllPlanes() { /*getting all the plane from overall plane's table*/
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name,flight_num,plane_company FROM planes";
            /*all the properties of plane so that all planes can be searched*/
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Plane> planes = new ArrayList<>();/*setting lost of planes as new array list*/
            while (rs.next()) { /*while loop*/
                Plane plane = new Plane(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("flight_num"),
                        rs.getString("plane_company"));

                planes.add(plane);
            }
            return planes;

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
    public String getNameById(int id) { /*getting name by id of an plane*/
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT name FROM plane WHERE id=?";
            /*this means we have exactly id, and it has one plane, so knowing the id, we can get exact name*/

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) { /*if loop*/
                String name = rs.getString("name");
                /*setting name to be equal to the name that got specific id*/
                return name; /*just returning name*/
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
        return "null"; /*if it has empty space*/
    }
}