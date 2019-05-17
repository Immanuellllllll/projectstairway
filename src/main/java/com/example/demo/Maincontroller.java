package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

@Controller
public class Maincontroller {

    @Autowired
    Databasen db;

    @GetMapping
    public String index(Model model) throws SQLException {
        model.addAttribute("stuff",db.getStuff());
        return "index";
    }
}
