package com.example.demo.Repository;

import com.example.demo.Config.MySQLConnection;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

@Repository
public class MemberRepo {
    Connection con;
    MySQLConnection msc;

    public MemberRepo(MySQLConnection msc) throws Exception
    {
        this.msc=msc;
        this.con=msc.create();
        //Lets load the driver

    }

    public void registerMember(String firstName,String lastName,String street,String postalcode, String city, String email, String description) throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        mySQLConnection.create();
        String q = "INSERT INTO members (firstname, surname, street, postalcode, city, email, description)"+" VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = con.prepareStatement(q);
        preparedStmt.setString (1, firstName);
        preparedStmt.setString (2, lastName);
        preparedStmt.setString (3, street);
        preparedStmt.setString (4, postalcode);
        preparedStmt.setString (5, city);
        preparedStmt.setString (6, email);
        preparedStmt.setString (7, description);
        preparedStmt.execute();
        preparedStmt.close();
        mySQLConnection.connClose();

    }
    public void editMember(int memberid, String firstName,String lastName,String street,String postalcode, String city, String privatephone, String mobilephone,String workphone,String job, String fax, String email,String description, String Sidst_betalt_kontingent, String medlemsstatus,String volontørstatus) throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        mySQLConnection.create();
        String q = "UPDATE members SET firstname=?, surname=?, street=?, postalcode=?, city=?, privatephone=?, mobilephone=?, workphone=?, job=?, fax=?, email=?, description=?, sidst_betalt_kontingent=?, medlemsstatus=?, volontørstatus=?"+" where memberid=?";
        PreparedStatement preparedStmt = con.prepareStatement(q);
        preparedStmt.setString (1, firstName);
        preparedStmt.setString (2, lastName);
        preparedStmt.setString (3, street);
        preparedStmt.setString (4, postalcode);
        preparedStmt.setString (5, city);
        preparedStmt.setString(6, privatephone);
        preparedStmt.setString(7, mobilephone);
        preparedStmt.setString(8, workphone);
        preparedStmt.setString(9, job);
        preparedStmt.setString(10, fax);
        preparedStmt.setString (11, email);
        preparedStmt.setString (12, description);
        preparedStmt.setString(13, Sidst_betalt_kontingent);
        preparedStmt.setString(14, medlemsstatus);
        preparedStmt.setString(15, volontørstatus);
        preparedStmt.setInt(16, memberid);
        preparedStmt.execute();
        preparedStmt.close();
        mySQLConnection.connClose();
    }


    public void deleteMember(int memberId) throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        mySQLConnection.create();
        String q= "DELETE FROM members"+" WHERE memberId="+"(?)";
        PreparedStatement preparedStatement = con.prepareStatement(q);
        preparedStatement.setInt(1,memberId);
        preparedStatement.execute();
        preparedStatement.close();
        mySQLConnection.connClose();
        }

    //Metoden prøver at sende en SQL sætning til databasen og lykkedes det sender den et resultset af alle patienter tilbage.

    public ResultSet viewAllMembers() throws Exception {
        MySQLConnection mySQLConnection = new MySQLConnection();
        mySQLConnection.create();
            String sql = "SELECT * FROM members";
            try {
                ResultSet rs = Query(sql);
                mySQLConnection.connClose();
                return rs;

            }catch (Exception e){
                System.out.println(e);
            }
            mySQLConnection.connClose();
            return null;
    }

    public ResultSet viewMember(int memberId) throws Exception {
        MySQLConnection mySQLConnection = new MySQLConnection();
        mySQLConnection.create();
        String sql = "SELECT * FROM members WHERE memberid=" + memberId;
        try {
            ResultSet rs = Query(sql);
            return rs;
        }catch (Exception e){
            System.out.println(e);
        }
        mySQLConnection.connClose();
        return null;
    }

    //Metoden beder om en String og returnerer en ordre til at udføre den i databasen.
    private ResultSet Query (String query) throws SQLException
    {
        Statement stmt = con.createStatement();
        return (stmt.executeQuery(query));
    }

    public void setDate(int memberid, String sbk) throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        mySQLConnection.create();
        String q = "update members set sidst_betalt_kontingent=? where memberid=?";
        PreparedStatement preparedStatement = con.prepareStatement(q);
        preparedStatement.setString(1,sbk);
        preparedStatement.setInt(2,memberid);
        preparedStatement.execute();
        preparedStatement.close();
        mySQLConnection.connClose();
    }
}


