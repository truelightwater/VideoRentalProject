package VideoProject.video.member;

import java.util.Optional;

public interface MemberRepository {
    void join(Member member);
    Member findByMember(String name);
}
