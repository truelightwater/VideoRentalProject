package VideoProject.video.command;

import VideoProject.video.Annotation.MemberAnnotationCheck;
import VideoProject.video.member.Member;
import VideoProject.video.member.MemberService;

import java.util.Scanner;

public class MemberSignUpCm implements Command {
    private MemberService memberService;
    public MemberAnnotationCheck annotationCheck;
    Member member = Member.builder().build();
    Scanner scanner;

    public MemberSignUpCm(MemberService memberService) {
        this.memberService = memberService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("성함을 입력해주세요. : ");
        member.setName(scanner.nextLine());

        System.out.print("휴대폰번호를 입력해 주세요.(하이픈 포함) : ");
        member.setPhoneNumber(scanner.nextLine());

        System.out.print("나이를 입력해주세요 : ");
        member.setAge(scanner.nextInt());
        scanner.nextLine();

        memberService.join(member);


//        boolean isTure = annotationCheck.memberValidation(member);
//
//        if (!isTure) {
//            System.out.println();
//        } else {
//            memberService.join(member);
//        }

        System.out.println();
    }
}
