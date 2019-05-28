package com.example.demo.Service;

import com.example.demo.Models.Donation;

import java.sql.SQLException;
import java.util.List;

public interface DonationServiceI {
    void donate(Donation donation) throws SQLException;

    List<Donation> showAllDeductableDonations() throws SQLException;

    void wipeCPR() throws SQLException;

    List<Donation> showAllDonations() throws SQLException;
}
