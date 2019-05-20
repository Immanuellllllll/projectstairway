package com.example.demo.Service;

import com.example.demo.Models.Member;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

public interface MemberServiceI {
    void registerMember(Member member) throws SQLException;

    void editMember(Member member) throws SQLException;

    void deleteMember(int memberid) throws SQLException;

    List<Member> viewMembers() throws Exception;
}
