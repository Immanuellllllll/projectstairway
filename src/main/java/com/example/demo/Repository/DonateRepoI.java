package com.example.demo.Repository;

import com.example.demo.Models.Donation;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DonateRepoI {
    void donate(Donation donation, int cprid) throws SQLException;

    ResultSet enterCPR(String cpr) throws SQLException;

    ResultSet showAllDeductableDonations() throws SQLException;

    void wipeCPR() throws SQLException;

    ResultSet showAllDonations() throws SQLException;

    void close() throws SQLException;
}
