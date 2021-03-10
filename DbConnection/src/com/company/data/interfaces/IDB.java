package com.company.data.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDB { /*the abstract class*/
    Connection getConnection() throws SQLException, ClassNotFoundException; /*having 2 exceptions*/
}