package com.example.demo.Repository;

import com.example.demo.Config.MySQLConnection;
import com.example.demo.Models.Donation;
import org.springframework.stereotype.Repository;

import java.sql.*;

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

    public void donate(Donation donation, int cprid) throws SQLException {
        MySQLConnection msc=new MySQLConnection();
        msc.create();
        String q = "INSERT INTO donation (amount, cprid, phonenumber)"+" VALUES (?, ?, ?)";
        PreparedStatement preparedStmt = con.prepareStatement(q);
        preparedStmt.setInt (1, donation.getAmount());
        preparedStmt.setInt (2, cprid);
        preparedStmt.setString (3, donation.getPhoneNumber());
        preparedStmt.execute();
        preparedStmt.close();
        msc.connClose();
    }
    public ResultSet enterCPR (String cpr) throws SQLException {
        MySQLConnection msc = new MySQLConnection();
        msc.create();
        String q = "insert into cpr (cpr) values (?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(q);
            preparedStatement.setString(1, cpr);
            preparedStatement.execute();
            preparedStatement.close();
        } catch(Exception e){}
        q = "SELECT cprid FROM cpr WHERE cpr ="+cpr;
        ResultSet rs = Query(q);
        return rs;

    }
    private ResultSet Query (String query) throws SQLException
    {
        Statement stmt = con.createStatement();
        return (stmt.executeQuery(query));
    }

    public ResultSet showAllDonations() throws SQLException {
        String q="Select * from donation right join cpr on donation.cprid=cpr.cprid";
        ResultSet rs =Query(q);
        return rs;
    }
}
