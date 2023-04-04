package VideoProject.video.member;

public interface MemberRepository {
    void save(Member member);

    Member findByMember(Long memberId);
}
