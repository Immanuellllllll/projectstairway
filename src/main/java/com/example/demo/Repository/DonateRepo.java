package com.example.demo.Repository;

import com.example.demo.Config.MySQLConnection;  // Vores config fil importeres
import com.example.demo.Models.Donation;  //        Donations modellen importeres
import org.springframework.stereotype.Repository;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

@Repository
public class DonateRepo implements DonateRepoI {
    MySQLConnection msc;
    Connection con;

    public DonateRepo(MySQLConnection msc) throws Exception
    {
        this.msc=msc;
    }

    @Override
    public void donate(Donation donation, int cprid) throws SQLException {
        con=msc.create();
        String q = "INSERT INTO donation (amount, cprid, phonenumber,name)"+" VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStmt = con.prepareStatement(q);
        preparedStmt.setInt (1, donation.getAmount());
        preparedStmt.setInt (2, cprid);
        preparedStmt.setString (3, donation.getPhoneNumber());
        preparedStmt.setString (4, donation.getName());

        preparedStmt.execute();
        preparedStmt.close();
        con.close();

    }
    @Override
    public ResultSet enterCPR(String cpr) throws SQLException {
        con=msc.create();
        String q = "insert into cpr (cpr) values (?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(q);
            preparedStatement.setString(1, cpr);
            preparedStatement.execute();
            preparedStatement.close();
        } catch(Exception e){System.out.println(e);}
        finally {
            q = "SELECT cprid FROM cpr WHERE cpr =" + cpr;
            ResultSet rs = Query(q);
            return rs;
        }
    }
    private ResultSet Query (String query) throws SQLException
    {
        Statement stmt = con.createStatement();
        return (stmt.executeQuery(query));
    }

    @Override
    public ResultSet showAllDeductableDonations() throws SQLException {
        con=msc.create();
        String q="Select * from donation right join cpr on donation.cprid=cpr.cprid";
        Statement stmt = con.createStatement();
        ResultSet rs=stmt.executeQuery(q);
        return rs;
    }

    @Override
    public void wipeCPR() throws SQLException {
        con=msc.create();
        String q ="Delete from cpr";
        Statement stmt =con.createStatement();
        stmt.execute(q);
        stmt.close();
        con.close();
    }

    @Override
    public ResultSet showAllDonations() throws SQLException {
        con=msc.create();
        String q="Select * from donation";
        Statement stmt = con.createStatement();
        ResultSet rs=stmt.executeQuery(q);
        return rs;
    }
    @Override
    public void close() throws SQLException {
        con.close();
    }
}
