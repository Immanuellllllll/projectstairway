package com.example.demo.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MemberRepoI {
    void registerMember(String firstName, String lastName, String street, String postalcode, String city, String email, String description) throws SQLException;

    void editMember(int memberid, String firstName, String lastName, String street, String postalcode, String city, String privatephone, String mobilephone, String workphone, String job, String fax, String email, String description, String Sidst_betalt_kontingent, String medlemsstatus, String volontørstatus) throws SQLException;

    void deleteMember(int memberId) throws SQLException;

    ResultSet viewAllMembers() throws Exception;

    ResultSet viewMember(int memberId) throws Exception;

    void setDate(int memberid, String sbk) throws SQLException;

    void close() throws SQLException;
}