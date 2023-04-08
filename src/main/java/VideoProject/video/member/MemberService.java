package VideoProject.video.member;

import java.time.LocalDate;

public interface MemberService {

    void join(Member member);

    Member findMember(String name);

}
