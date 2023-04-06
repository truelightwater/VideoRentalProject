package VideoProject.video;

import VideoProject.video.member.Member;
import VideoProject.video.member.MemberService;
import VideoProject.video.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();

        Member member1 = new Member(1L, "member1", "1234-1234", "영등포구", 34);
        Member member2 = new Member(2L, "member2", "5345-3412", "관악구", 31);
        Member member3 = new Member(3L, "member3", "9012-5724", "양천구", 26);
        Member member4 = new Member(4L, "member4", "6755-2567", "강서구", 21);
        Member member5 = new Member(5L, "member5", "3355-1677", "강남구", 24);

        memberService.join(member1);
        memberService.join(member2);
        memberService.join(member3);
        memberService.join(member4);
        memberService.join(member5);

        Member findMember = memberService.findMember(2L);
        System.out.println("new member = " + member1);
        System.out.println("find member = " + findMember);

    }
}
