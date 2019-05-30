package com.example.demo.Repository;

import com.example.demo.Models.Admin;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface AdminRepoI {
    //Vi tager username fra website, password taget vi igennem hash metoden fra Service. Så tjekker vi om den passer i Databasen.
    ResultSet confirmLogin(Admin admin) throws NoSuchAlgorithmException, SQLException;

    public void close() throws SQLException;
}
