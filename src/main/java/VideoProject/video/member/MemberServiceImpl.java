package VideoProject.video.member;

public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.join(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findByMember(memberId);
    }

}
