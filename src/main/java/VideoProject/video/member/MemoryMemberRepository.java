package VideoProject.video.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
     private static Map<String, Member> store = new HashMap<String, Member>();
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void join(Member member) {
        store.put(member.getName(), member);
    }

    @Override
    public Member findByMember(String name) {

        log.info(String.valueOf(store.get(name)));
        return store.get(name);
    }
}
