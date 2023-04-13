package VideoProject.video.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<String, Member> store = new HashMap<>();
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void join(Member member) {
        store.put(member.getName(), member);
    }

    @Override
    public Member findByMember(String name) {
        return Optional.ofNullable(store.get(name))
                .map(member -> {
                    log.info(String.valueOf(store.get(name)));
                    return member;
                })
                .orElseGet(() -> {
                    log.info("**** 조회한 회원이 없습니다. ****");
                   return null;
                });
    }
}
