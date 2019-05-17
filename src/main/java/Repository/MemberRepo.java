package Repository;

import Models.Member;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
@Repository
public class MemberRepo {
    /**
     *
     * @param member
     */
    public void registerMember(Member member) {
        // TODO - implement MemberRepository.registerMember
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param member
     */
    public void editMember(Member member) {
        // TODO - implement MemberRepository.editMember
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param memberid
     */
    public void deleteMember(int memberid) {
        // TODO - implement MemberRepository.deleteMember
        throw new UnsupportedOperationException();
    }

    public ResultSet viewMembers() {
        // TODO - implement MemberRepository.viewMembers
        throw new UnsupportedOperationException();
    }

}

