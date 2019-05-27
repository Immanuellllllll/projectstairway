package com.example.demo.Controller;

import com.example.demo.Models.Donation;
import com.example.demo.Models.Member;
import com.example.demo.Service.MemberService;
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
        return "redirect:" + referer;
    }

    @GetMapping("/a")
    public String registerForm(Model model) {
        model.addAttribute("member", new Member());
        model.addAttribute("donation", new Donation());

        return "Støt Stairways arbejde - Stairway - for gadebørn og alle børns rettigheder - Generalforsamling 2016";
    }

    @PostMapping("/editMember")
    public String EditMember(@ModelAttribute Member member, HttpServletRequest request) throws SQLException {
        ms.editMember(member);
        String referer = request.getHeader("Referer");
        return "redirect:"+referer;
    }

    @GetMapping("/editMember/{memberid}")
    public String EditMember(Model model, @PathVariable int memberid) throws Exception {
        model.addAttribute("member", ms.viewMember(memberid));
        return "editMember";
    }

    @PostMapping("/createMember")
    public String createMember(@ModelAttribute Member member, HttpServletRequest request) throws SQLException {
        ms.registerMember(member);
        member.setMemberId(1);
        return "redirect:/showAllMembers";
    }
    @GetMapping("/createMember")
    public String createMember(Model model) throws Exception{
        model.addAttribute("member", new Member());
        return "CreateMember";
    }


    @PostMapping("/DeleteMember/{id}")
    public String DeleteMember(@PathVariable int id) throws SQLException {
        System.out.println(id);
        ms.deleteMember(id);
        return "test";
    }


    @GetMapping("/showAllMembers")
    public String showAllMembers(Model model) throws Exception {
        model.addAttribute("medlemmer", ms.viewMembers());
        model.addAttribute("medlem", new Member());
        return "backoffice";
    }

    @GetMapping("/showTest")
    public String showAllMemberstwo (Model model) throws Exception {
        model.addAttribute("medlemmer", ms.viewMembers());
        model.addAttribute("medlem", new Member());
        return "backofficetest";
    }
    @GetMapping("/showMember/{memberid}")
    public String showMember(Model model, @PathVariable int memberid) throws Exception {
        model.addAttribute("member", ms.viewMember(memberid));
        return "Showsinglemember";
    }
    @PostMapping("/setDate/{memberid}")
    public String setDate( @PathVariable int memberid, HttpServletRequest request) throws Exception {
        ms.setDate(memberid);
        String referer = request.getHeader("Referer");
        return "redirect:"+referer;
    }
}

