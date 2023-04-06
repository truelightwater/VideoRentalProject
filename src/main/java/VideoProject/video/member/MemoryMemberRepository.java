package VideoProject.video.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void join(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findByMember(Long memberId) {
        return store.get(memberId);
    }

}
