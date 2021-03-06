package com.example.demo.Service;

import com.example.demo.Models.Donation;
import com.example.demo.Repository.DonateRepo;
import com.example.demo.Repository.DonateRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DonationService implements DonationServiceI {
    @Autowired
    DonateRepoI dr;

    //Metoden kalder metoden enterCPR(mere om det i DonateRepo) og bruger Donation objektet samt CPR-nummeret som argumenter i dr.donate kaldet.
    @Override
    public void donate(Donation donation) throws SQLException {
        ResultSet rs=dr.enterCPR(donation.getCpr());
        rs.next();
        int cprid=rs.getInt("cprid");
        dr.close();
        dr.donate(donation,cprid);

    }

    @Override
    public List<Donation> showAllDeductableDonations() throws SQLException {
        ResultSet rs=dr.showAllDeductableDonations();
        List<Donation> dList=new ArrayList<>();
        while (rs.next())
        {
        dList.add(new Donation(rs.getInt("donationid"),rs.getInt("amount"),rs.getString("phonenumber"),rs.getString("cpr"),rs.getString("name")));
        }
        dr.close();
        return dList;
    }

    @Override
    public void wipeCPR() throws SQLException {
        dr.wipeCPR();
    }

    @Override
    public List<Donation> showAllDonations() throws SQLException {
        ResultSet rs=dr.showAllDonations();
        List<Donation> dList=new ArrayList<>();
        while (rs.next())
        {
            dList.add(new Donation(rs.getInt("donationid"),rs.getInt("amount"),rs.getString("phonenumber"),null,rs.getString("name")));
        }
        dr.close();
        return dList;
    }
}



