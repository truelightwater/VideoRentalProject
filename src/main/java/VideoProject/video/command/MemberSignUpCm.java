package VideoProject.video.command;

import VideoProject.video.Annotation.MemberAnnotationCheck;
import VideoProject.video.member.Member;
import VideoProject.video.member.MemberService;

import java.util.Scanner;

public class MemberSignUpCm implements Command {
    private MemberService memberService;
    public MemberAnnotationCheck annotationCheck;
    private Member member = Member.builder().build();
    Scanner scanner;

    public MemberSignUpCm(MemberService memberService, MemberAnnotationCheck annotationCheck) {
        this.memberService = memberService;
        this.annotationCheck = annotationCheck;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void execute() {
        System.out.print("성함을 입력해주세요. : ");
        String name = scanner.nextLine();
        member.setName(name);

        System.out.print("휴대폰번호를 입력해 주세요.(하이픈 포함) : ");
        String phoneNumber = scanner.nextLine();
        member.setPhoneNumber(phoneNumber);

        System.out.print("나이를 입력해주세요 : ");
        int age = scanner.nextInt();
        member.setAge(age);
        scanner.nextLine();

        boolean isTure = annotationCheck.memberValidation(member);

        if (!isTure) {
            System.out.println();
        } else {
            memberService.join(member);
        }

        System.out.println();
    }
}
