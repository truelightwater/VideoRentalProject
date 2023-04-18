package VideoProject.video.member;

public interface MemberRepository {
    void join(Member member);
    Member findByMember(String name);
}
