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

    @PostMapping ("/registerMember")
    public String registerMember(){
        //ms.registerMember(member);
        return "index";
    }
    @GetMapping ("/a")
    public String registerForm(Model model){
        model.addAttribute("member", new Member());
        return "Støt Stairways arbejde - Stairway - for gadebørn og alle børns rettigheder - Generalforsamling 2016";
    }
    @PostMapping("/EditMember")
    public String EditMember(@ModelAttribute Member member, HttpServletRequest request) throws SQLException {
        ms.editmember(member);
        String referer = request.getHeader("Referer");
        return "test";

        @PostMapping("/DeleteMember")
        public String DeleteMember(@PathVariable int memberId) throws SQLException {
            ms.deleteMember(memberId);
            return "test";
        }


        @GetMapping("/showAllMembers")
        public String showAllMembers(Member member) throws Exception {
            member.addAttribute("medlemer", ms.getALL());
            member.addAttribute("medlem",new Member());
            return "test";
        }

        }


    }
}
