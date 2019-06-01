package com.example.demo.Repository;

import com.example.demo.Config.MySQLConnection;
import com.example.demo.Models.Member;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

@Repository
public class MemberRepo implements MemberRepoI {
    Connection con;
    MySQLConnection msc;

    public MemberRepo(MySQLConnection msc) throws Exception
    {
        this.msc=msc;
        //Lets load the driver

    }

    @Override
    public void registerMember(Member member) throws SQLException {
        con=msc.create();
        String q = "INSERT INTO members (firstname, surname, street, postalcode, city, privatephone , mobilephone, workphone, job, fax, email, description, sidst_betalt_kontingent, medlemsstatus, volontørstatus )"+" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = con.prepareStatement(q);
        preparedStmt.setString (1, member.getFirstName());
        preparedStmt.setString (2, member.getLastName());
        preparedStmt.setString (3, member.getStreet());
        preparedStmt.setString (4, member.getPostalcode());
        preparedStmt.setString (5, member.getCity());
        preparedStmt.setString(6, member.getPrivatephone());
        preparedStmt.setString(7, member.getMobilephone());
        preparedStmt.setString(8, member.getWorkphone());
        preparedStmt.setString(9, member.getJob());
        preparedStmt.setString(10, member.getFax());
        preparedStmt.setString (11, member.getEmail());
        preparedStmt.setString (12, member.getDescription());
        preparedStmt.setString(13, member.getLastpayed());
        preparedStmt.setString(14, member.getMemberstatus());
        preparedStmt.setString(15, member.getVolunteerstatus());
        preparedStmt.execute();
        preparedStmt.close();
        con.close();
    }
    @Override
    public void editMember(Member member) throws SQLException {
        con=msc.create();
        String q = "UPDATE members SET firstname=?, surname=?, street=?, postalcode=?, city=?, privatephone=?, mobilephone=?, workphone=?, job=?, fax=?, email=?, description=?, sidst_betalt_kontingent=?, medlemsstatus=?, volontørstatus=?"+" where memberid=?";
        PreparedStatement preparedStmt = con.prepareStatement(q);
        preparedStmt.setString (1, member.getFirstName());
        preparedStmt.setString (2, member.getLastName());
        preparedStmt.setString (3, member.getStreet());
        preparedStmt.setString (4, member.getPostalcode());
        preparedStmt.setString (5, member.getCity());
        preparedStmt.setString(6, member.getPrivatephone());
        preparedStmt.setString(7, member.getMobilephone());
        preparedStmt.setString(8, member.getWorkphone());
        preparedStmt.setString(9, member.getJob());
        preparedStmt.setString(10, member.getFax());
        preparedStmt.setString (11, member.getEmail());
        preparedStmt.setString (12, member.getDescription());
        preparedStmt.setString(13, member.getLastpayed());
        preparedStmt.setString(14, member.getMemberstatus());
        preparedStmt.setString(15, member.getVolunteerstatus());
        preparedStmt.setInt(16, member.getMemberId());
        preparedStmt.execute();
        preparedStmt.close();
        con.close();
    }


    @Override
    public void deleteMember(int memberId) throws SQLException {
        con=msc.create();
        String q= "DELETE FROM members"+" WHERE memberId="+"(?)";
        PreparedStatement preparedStatement = con.prepareStatement(q);
        preparedStatement.setInt(1,memberId);
        preparedStatement.execute();
        preparedStatement.close();
        con.close();
        }

    //Metoden prøver at sende en SQL sætning til databasen og lykkedes det sender den et resultset af alle patienter tilbage.

    @Override
    public ResultSet viewAllMembers() throws Exception {
        con=msc.create();
        String sql = "SELECT * FROM members";
            try {
                ResultSet rs = Query(sql);
                return rs;

            }catch (Exception e){
                System.out.println(e);
            }
            return null;
    }

    @Override
    public ResultSet viewMember(int memberId) throws Exception {
        con=msc.create();
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

    @Override
    public void setDate(int memberid, String sbk) throws SQLException {
        con=msc.create();
        String q = "update members set sidst_betalt_kontingent=? where memberid=?";
        PreparedStatement preparedStatement = con.prepareStatement(q);
        preparedStatement.setString(1,sbk);
        preparedStatement.setInt(2,memberid);
        preparedStatement.execute();
        preparedStatement.close();
        con.close();
    }
    public void close() throws SQLException {
        con.close();
    }
}


