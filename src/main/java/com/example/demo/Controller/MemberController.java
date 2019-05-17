package com.example.demo.Controller;

import com.example.demo.Models.Member;
import com.example.demo.Service.MemberServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    //MemberServiceI ms;

    @PostMapping ("/registerMember")
    public String registerMember(){
        //ms.registerMember(member);
        return "index";
    }
    @GetMapping ("/a")
    public String registerForm(Model model){
        model.addAttribute("member", new Member());
        return "test";
    }
    public void editMember(){

    }
    public void deleteMember(){

    }
    public void viewMember(){

    }

}
