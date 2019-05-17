package Service;

import Models.Member;

import java.util.List;

public interface MemberServiceI {
    void registerMember(Member member);

    void editMember(Member member);

    void deleteMember(int memberid);

    List<Member> viewMembers();
}
