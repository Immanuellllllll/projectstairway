package com.example.demo.Service;

import com.example.demo.Models.Member;
import com.example.demo.Repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class MemberService implements MemberServiceI{
    @Autowired
    MemberRepo pr;

    public void registerMember(Member member) throws SQLException {
        pr.createMember(member.getFirstName(),member.getLastName(),member.getStreet(),member.getPostalcode(),member.getCity(),member.getEmail(),member.getDescription());
    }


    public void editMember(Member member) {
        // TODO - implement MemberService.editMember
        throw new UnsupportedOperationException();
    }

    public void deleteMember(int memberid) {
        // TODO - implement MemberService.deleteMember
        throw new UnsupportedOperationException();
    }

    public List<Member> viewMembers() {
        // TODO - implement MemberService.viewMembers
        throw new UnsupportedOperationException();
    }

}
