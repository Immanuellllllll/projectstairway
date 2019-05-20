package com.example.demo.Repository;

import com.example.demo.Config.MySQLConnection;
import org.springframework.stereotype.Repository;

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

    public void registerMember(String firstName,String lastName,String street,String postalcode, String city, String email) throws SQLException {
        String q = "INSERT INTO members (firstname, lastname, street, postalcode, city, email)"+" VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = con.prepareStatement(q);
        preparedStmt.setString (1, firstName);
        preparedStmt.setString (2, lastName);
        preparedStmt.setString (3, street);
        preparedStmt.setString (4, postalcode);
        preparedStmt.setString (5, city);
        preparedStmt.setString (6, email);
        preparedStmt.execute();
        preparedStmt.close();
    }

    public void editMember(String firstName,String lastName,String street,String postalcode, String city, String email) throws SQLException {
        String q = "UPDATE members SET(firstname, lastname, street, postalcode, city, email)"+" VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = con.prepareStatement(q);
        preparedStmt.setString (1, firstName);
        preparedStmt.setString (2, lastName);
        preparedStmt.setString (3, street);
        preparedStmt.setString (4, postalcode);
        preparedStmt.setString (5, city);
        preparedStmt.setString (6, email);
        preparedStmt.execute();
        preparedStmt.close();
    }




    public void deleteMember(int memberId) throws SQLException {
       String q= "DELETE FROM members"+"WHERE memberId="+"(?)";
        PreparedStatement preparedStatement = con.prepareStatement(q);
        preparedStatement.setInt(1,memberId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    //Metoden prøver at sende en SQL sætning til databasen og lykkedes det sender den et resultset af alle patienter tilbage.

    public ResultSet viewAllMembers() throws Exception {
            String sql = "SELECT * FROM members";
            try {
                ResultSet rs = Query(sql);
                return rs;
            }catch (Exception e){
                System.out.println(e);
            }
            return null;
    }

    public ResultSet viewMember(int memberId) throws Exception {
        String sql = "SELECT * FROM members WHERE memberid=" + memberId;
        try {
            ResultSet rs = Query(sql);
            return rs;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //Metoden beder om en String og returnerer en ordre til at udføre den i databasen.
    private ResultSet Query (String query) throws SQLException
    {
        Statement stmt = con.createStatement();
        return (stmt.executeQuery(query));
    }

}

