package Service;

import Models.Member;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberService implements MemberServiceI {

    @Override
    public void registerMember(Member member) {
        // TODO - implement MemberService.registerMember
        throw new UnsupportedOperationException();
    }


    @Override
    public void editMember(Member member) {
        // TODO - implement MemberService.editMember
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteMember(int memberid) {
        // TODO - implement MemberService.deleteMember
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Member> viewMembers() {
        // TODO - implement MemberService.viewMembers
        throw new UnsupportedOperationException();
    }

}
