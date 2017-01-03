package com.ga.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private Database() {
    }

    private static Database dbConnection;

    public static Database getInstance() {
        if (dbConnection == null) {
            dbConnection = new Database();
        }
        return dbConnection;
    }

    public static Connection doConnection() {

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

}