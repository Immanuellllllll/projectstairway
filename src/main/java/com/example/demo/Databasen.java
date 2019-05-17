package com.example.demo;

import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class Databasen {

    Connection con;


    public Databasen() throws ClassNotFoundException, SQLException {

            //Lets load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String user = "test";
            String pwd = "Testtest";
            String server = "test.crzbpvntiewt.eu-central-1.rds.amazonaws.com";
            String db = "test";
            String port = "3306";


            con = DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+db, user, pwd);

    }

    public Stuff getStuff() throws SQLException {
        String q ="select * from stuffs";
        ResultSet rs = Query(q);

        rs.next();

        Stuff stuff = new Stuff(rs.getString("name"),rs.getInt("sid"),rs.getString("location"));
        return stuff;

    }

    private ResultSet Query(String q) throws SQLException {
        Statement stmt = con.createStatement();
        return(stmt.executeQuery(q));
    }


}

