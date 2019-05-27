package com.example.demo.Controller;

import com.example.demo.Models.Admin;
import com.example.demo.Service.AdminServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@Controller
public class AdminController {
    @Autowired
    AdminServiceI As;

    @GetMapping("/")
    public String Login (Model model){
        model.addAttribute("admin", new Admin());
        return "Login";
    }

    @PostMapping("/Login")
    public String confirmLogin (@ModelAttribute Admin admin, HttpSession session) throws SQLException, NoSuchAlgorithmException {
        try {
            As.confirmLogin(admin);
session.setAttribute("admin", true);
        }
       catch(Exception e) {
           System.out.println(e);
           return "Login";
        }
        return "redirect:/showAllMembers";
    }

}
