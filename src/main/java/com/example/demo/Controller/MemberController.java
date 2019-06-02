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
    //Kundesiden. Modtager en objekt af typen Member og bruger det som argument i kaldet til registerMember metoden i MemberService objektet.
    @PostMapping("/registerMember")
    public String registerMember(@ModelAttribute Member member, HttpServletRequest request) throws SQLException {
        ms.registerMember(member);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
    //Kundesiden. Her kan kunden registrere eller donere
    @GetMapping("/")
    public String registerForm(Model model) {
        model.addAttribute("member", new Member());
        model.addAttribute("donation", new Donation());
        return "Støt Stairways arbejde - Stairway - for gadebørn og alle børns rettigheder - Generalforsamling 2016";
    }
    //Modtager et Member objekt og bruger det som argument i editMember kaldet. Refresher derefter siden man er på.
    @PostMapping("/editMember")
    public String EditMember(@ModelAttribute Member member, HttpServletRequest request) throws SQLException {
        ms.editMember(member);
        String referer = request.getHeader("Referer");
        return "redirect:"+referer;
    }
    //Bruger det ønskede memberid som argument viewMember kaldet så man kan få et bestemt medlem vist.
    @GetMapping("/editMember/{memberid}")
    public String EditMember(Model model, @PathVariable int memberid) throws Exception {
        model.addAttribute("member", ms.viewMember(memberid));
        return "editMember";
    }
    //Samme som registerMember men fra admins side.
    @PostMapping("/createMember")
    public String createMember(@ModelAttribute Member member, HttpServletRequest request) throws SQLException {
        ms.registerMember(member);
        return "redirect:/showAllMembers";
    }
    //Siden hvor admin udfylder en medlemsformular og bekræfter.
    @GetMapping("/createMember")
    public String createMember(Model model) throws Exception{
        model.addAttribute("member", new Member());
        return "CreateMember";
    }
    //Bruger det valgte medlemsid som argument deleteMember kaldet.
    @PostMapping("/DeleteMember/{id}")
    public String DeleteMember(@PathVariable int id) throws SQLException {
        ms.deleteMember(id);
        return "redirect:/showAllMembers";
    }
    //Henter en liste med alle medlemmer fra ms og returnerer en side som præsenterer listen.
    @GetMapping("/showAllMembers")
    public String showAllMembers(Model model) throws Exception {
        model.addAttribute("medlemmer", ms.viewMembers());
        model.addAttribute("medlem", new Member());
        return "backoffice";
    }
    //Bruger de valgte medlems memberid som argument setDate kaldet som opdaterer sidst betalt kontingent datoen.
    @PostMapping("/setDate/{memberid}")
    public String setDate( @PathVariable int memberid, HttpServletRequest request) throws Exception {
        ms.setDate(memberid);
        String referer = request.getHeader("Referer");
        return "redirect:"+referer;
    }
}

