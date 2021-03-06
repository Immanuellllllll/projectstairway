package com.example.demo.Service;

import com.example.demo.Models.Member;
import com.example.demo.Repository.MemberRepo;
import com.example.demo.Repository.MemberRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class MemberService implements MemberServiceI{
    @Autowired
    MemberRepoI mr;
    //De næste tre metoder sender blot arbejdet videre til mr.
    public void registerMember(Member member) throws SQLException {
        mr.registerMember(member);
    }

    public void editMember(Member member) throws SQLException {
        mr.editMember(member);
    }

    public void deleteMember(int memberId) throws SQLException {
        mr.deleteMember(memberId);
    }
    //Modtager et ResultSet objekt fra mr og laver en liste af medlemmer ud fra det. Returnerer listen til Membercontroller objektet.
    public List<Member> viewMembers() throws Exception {

        ResultSet rs = mr.viewAllMembers();

        List<Member> memberList = new ArrayList<Member>();


        while (rs.next()) {
            int memberId = rs.getInt("memberid");
            String firstName = rs.getString("firstname");
            String lastName = rs.getString("surname");
            String street = rs.getString("street");
            String postalcode = rs.getString("postalcode");
            String city = rs.getString("city");
            String email = rs.getString("email");
            String privatephone = rs.getString("privatephone");
            String workphone = rs.getString("workphone");
            String mobilephone = rs.getString("mobilephone");
            String job  = rs.getString("job");
            String fax = rs.getString("fax");
            String description = rs.getString("description");
            String lastpayed =rs.getString("Sidst_betalt_kontingent");
            String memberStatus = rs.getString("medlemsstatus");
            String volunteersstatus = rs.getString("volontørstatus");
            Member member = new Member(memberId, firstName, lastName, street, postalcode, city, email,description, privatephone, mobilephone, workphone, job
            , fax, lastpayed, memberStatus,volunteersstatus);
            memberList.add(member);
        }
        mr.close();
        return memberList;
    }
    //Instantierer et Member objekt ud fra et ResultSet og returnerer det til controller objektet.
    public Member viewMember(int memberId) throws Exception {

        ResultSet rs= mr.viewMember(memberId);
        rs.next();
        String firstName = rs.getString("firstname");
        String lastName = rs.getString("surname");
        String street = rs.getString("street");
        String postalcode = rs.getString("postalcode");
        String city = rs.getString("city");
        String email = rs.getString("email");
        String privatephone = rs.getString("privatephone");
        String workphone = rs.getString("workphone");
        String mobilephone = rs.getString("mobilephone");
        String job  = rs.getString("job");
        String fax = rs.getString("fax");
        String description = rs.getString("description");
        String lastpayed =rs.getString("Sidst_betalt_kontingent");
        String memberStatus = rs.getString("medlemsstatus");
        String volunteersstatus = rs.getString("volontørstatus");
        Member member = new Member(memberId, firstName, lastName, street, postalcode, city, email,description, privatephone, mobilephone, workphone, job
                , fax, lastpayed, memberStatus,volunteersstatus);
        mr.close();
        return member;
    }

    @Override
    //Finder året fra den nuværende dato og bruger det sammen med det valgte memberid som argumenter i setDate kaldet.
    public void setDate(int memberid) throws SQLException {
        LocalDate d = LocalDate.now();
        Integer.valueOf(d.toString().substring(0,4));
        mr.setDate(memberid,d.toString());

    }
}