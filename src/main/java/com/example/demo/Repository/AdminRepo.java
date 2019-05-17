package com.example.demo.Repository;


import com.example.demo.Config.MySQLConnection;
import com.example.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
/*@Repository
public class AdminRepo {
    Connection con;
    MySQLConnection msc;

    public AdminRepo(){
        this.msc=msc;
        this.msc= (MySQLConnection) msc.create();
    }

    /*public ResultSet confirmLogin() throws NoSuchAlgorithmException, SQLException {
        String username = "Nils";
        String password = admService.checkPassword();
        String q =
                "SELECT from stairwaydatabase.admin WHERE username = '" +username+ "AND password= '"+password+"'";
        try {
            ResultSet rs = Query(q);
            return rs;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    private ResultSet Query (String query) throws SQLException {
        Statement stmt = con.createStatement();
        return (stmt.executeQuery(query));
    }

}*/
