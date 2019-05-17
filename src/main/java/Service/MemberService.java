package Service;

import Models.Member;
import Repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class MemberService {
    @Autowired
    MemberRepo pr;

    public void registerMember(Member member) throws SQLException {
        pr.createPatient(patient.getCpr(),patient.getFirst_name(),patient.getLast_name(),patient.getAge(),patient.getAddress(),patient.getDob(),patient.getHeight(),patient.getWeight(),patient.isPenicillinallergy(),patient.isLactoseallergy(),patient.isGlutenallergy());
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
