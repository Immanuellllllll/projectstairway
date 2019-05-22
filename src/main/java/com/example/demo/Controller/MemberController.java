package com.example.demo.Controller;

import com.example.demo.Models.Member;
import com.example.demo.Service.MemberServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class MemberController {
    @Autowired
    MemberServiceI ms;

    @PostMapping("/registerMember")
    public String registerMember(@ModelAttribute Member member, HttpServletRequest request) throws SQLException {
        ms.registerMember(member);
        String referer = request.getHeader("Referer");
        return "redirect:"+referer;
    }

    @GetMapping("/a")
    public String registerForm(Model model) {
        model.addAttribute("member", new Member());
        return "Støt Stairways arbejde - Stairway - for gadebørn og alle børns rettigheder - Generalforsamling 2016";
    }

    @PostMapping("/EditMember")
    public String EditMember(@ModelAttribute Member member, HttpServletRequest request) throws SQLException {
        ms.editMember(member);
        String referer = request.getHeader("Referer");
        return "test";
    }

    @PostMapping("/DeleteMember/{id}")
    public String DeleteMember(@PathVariable int id) throws SQLException {
        System.out.println("HHHEEEEEERERERERERE");
        ms.deleteMember(id);
        return "test";
    }


    @GetMapping("/showAllMembers")
    public String showAllMembers(Model model) throws Exception {
        model.addAttribute("medlemmer", ms.viewMembers());
        model.addAttribute("medlem", new Member());
        return "backoffice";
    }
}

