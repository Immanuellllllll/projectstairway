package com.example.demo.Repository;

import com.example.demo.Config.MySQLConnection;
import com.example.demo.Models.Donation;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class DonateRepo {
    Connection con;
    MySQLConnection msc;

    public DonateRepo(MySQLConnection msc) throws Exception
    {
        this.msc=msc;
        this.con=msc.create();
        //Lets load the driver

    }

    public void donate(Donation donation) throws SQLException {
        String q = "INSERT INTO members (amount, email, phonenumber)"+" VALUES (?, ?, ?)";
        PreparedStatement preparedStmt = con.prepareStatement(q);
        preparedStmt.setInt (1, donation.getAmount());
        preparedStmt.setString (2, donation.getEmail());
        preparedStmt.setString (3, donation.getPhoneNumber());
    }
}
