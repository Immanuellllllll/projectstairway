package com.example.demo.Service;

import com.example.demo.Models.Member;
import com.example.demo.Repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Service
public class MemberService implements MemberServiceI{
    @Autowired
    MemberRepo mr;

    public void registerMember(Member member) throws SQLException {
        mr.registerMember(member.getFirstName(), member.getLastName(), member.getStreet(), member.getPostalcode(), member.getCity(), member.getEmail(),member.getDescription());
    }

    public void editMember(Member member) throws SQLException {
        mr.editMember(member.getFirstName(), member.getLastName(), member.getStreet(), member.getPostalcode(), member.getCity(), member.getEmail(),member.getDescription());
    }

    public void deleteMember(int memberId) throws SQLException {
        mr.deleteMember(memberId);
    }
    public List<Member> viewMembers() throws Exception {

        ResultSet rs = mr.viewAllMembers();

        List<Member> memberList = new ArrayList<Member>();


        while (rs.next()) {
            int memberId = rs.getInt("memberid");
            String firstName = rs.getString("firstname");
            String lastName = rs.getString("lastname");
            String street = rs.getString("street");
            String postalcode = rs.getString("postalcode");
            String city = rs.getString("city");
            String email = rs.getString("email");
            Member member = new Member(memberId, firstName, lastName, street, postalcode, city, email);
            memberList.add(member);




        }

        return memberList;


    }

}