package com.example.demo.Service;

import com.example.demo.Models.Donation;
import com.example.demo.Repository.DonateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DonationService implements DonationServiceI {
    @Autowired
    DonateRepo dr;

    @Override
    public void donate(Donation donation) throws SQLException {
        ResultSet rs=dr.enterCPR(donation.getCpr());
        rs.next();
        int cprid=rs.getInt("cprid");
        dr.donate(donation,cprid);


    }

    @Override
    public List<Donation> showAllDonations() throws SQLException {
        ResultSet rs=dr.showAllDonations();
        List<Donation> dList=new ArrayList<>();
        while (rs.next())
        {
        dList.add(new Donation(rs.getInt("donationid"),rs.getInt("amount"),rs.getString("phonenumber"),rs.getString("cpr")));
        }

        return dList;
    }

}

