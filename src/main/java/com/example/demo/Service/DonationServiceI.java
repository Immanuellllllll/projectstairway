package com.example.demo.Service;

import com.example.demo.Models.Donation;

import java.sql.SQLException;

public interface DonationServiceI {
    void donate(Donation donation) throws SQLException;
}
