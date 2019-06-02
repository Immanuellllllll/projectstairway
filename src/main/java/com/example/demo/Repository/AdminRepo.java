package com.example.demo.Repository;


import com.example.demo.Config.MySQLConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.Models.Admin;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
@Repository
public class AdminRepo implements AdminRepoI {
    Connection con;
    MySQLConnection msc;

    public AdminRepo(MySQLConnection msc) throws Exception
    {
        this.msc=msc;
        //Lets load the driver

    }

    //Sammenligner username og det hashede password med dem i databasen.
    @Override
    public ResultSet confirmLogin(Admin admin) throws NoSuchAlgorithmException, SQLException {

        String username = admin.getUserName();
        String password = admin.getPassword();
        con=msc.create();
        String q =
                "SELECT * from admin WHERE username = '" +username+ "' AND password= '"+password+"'";
        try {
            ResultSet rs = Query(q);
            return rs;
       } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    //Eksekverer en query og returnerer et ResultSet objekt.
    private ResultSet Query (String query) throws SQLException {
        Statement stmt = con.createStatement();
        return (stmt.executeQuery(query));
    }
    public void close() throws SQLException {
        con.close();
    }


}
