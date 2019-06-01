package com.example.demo.Repository;

import com.example.demo.Models.Member;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MemberRepoI {
    void registerMember(Member member) throws SQLException;

    void editMember(Member member) throws SQLException;

    void deleteMember(int memberId) throws SQLException;

    ResultSet viewAllMembers() throws Exception;

    ResultSet viewMember(int memberId) throws Exception;

    void setDate(int memberid, String sbk) throws SQLException;

    void close() throws SQLException;
}