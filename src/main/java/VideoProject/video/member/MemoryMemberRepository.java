package VideoProject.video.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<String, Member> store = new HashMap<>();

    @Override
    public void join(Member member) {
        store.put(member.getName(), member);
    }

    @Override
    public Member findByMember(String name) {
        System.out.println(store.get(name));
        return store.get(name);
    }

}
