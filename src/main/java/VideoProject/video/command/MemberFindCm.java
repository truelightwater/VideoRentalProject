package VideoProject.video.command;

import VideoProject.video.Annotation.MemberAnnotationCheck;
import VideoProject.video.member.Member;
import VideoProject.video.member.MemberService;

import java.util.Scanner;

public class MemberFindCm implements Command {
    private MemberService memberService;
    Scanner scanner;

    public MemberFindCm(MemberService memberService) {
        this.memberService = memberService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("회원 이름을 입력해주세요 : ");
        String name = scanner.nextLine();
        memberService.findMember(name);
        System.out.println();
    }
}
