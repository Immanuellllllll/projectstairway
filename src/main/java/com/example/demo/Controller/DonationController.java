package com.example.demo.Controller;

import com.example.demo.Models.Donation;
import com.example.demo.Service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class DonationController {
    @Autowired
    DonationService ds;

    @PostMapping("/donate")
    public String donate(@ModelAttribute Donation donation) throws SQLException {
        ds.donate(donation);
        return "Tak";
    }
    @GetMapping("/showAllDonations")
    public String showAllDonations(Model model) throws SQLException {
        model.addAttribute("donations", ds.showAllDonations());
        model.addAttribute("donation", new Donation());
        return "showAllDonations";
    }
}
