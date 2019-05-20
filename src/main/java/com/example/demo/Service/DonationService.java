package com.example.demo.Service;

import com.example.demo.Models.Donation;
import com.example.demo.Repository.DonateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DonationService implements DonationServiceI {
    @Autowired
    DonateRepo dr;

    @Override
    public void donate(Donation donation) throws SQLException {
        dr.donate(donation);

    }

}

