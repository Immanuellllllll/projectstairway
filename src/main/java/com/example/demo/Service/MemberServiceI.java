package com.example.demo.Service;

import com.example.demo.Models.Member;

import java.util.List;

public interface MemberServiceI {
    void registerMember(Member member) throws Exception;

    void editMember(Member member) throws Exception ;

    void deleteMember(int memberid) throws Exception ;

    List<Member> viewAllMembers() throws Exception;
}
