package VideoProject.video.command;

import VideoProject.video.Annotation.MemberAnnotationCheck;
import VideoProject.video.member.Member;
import VideoProject.video.member.MemberService;

import java.util.Scanner;

public class MemberSignUpCm implements Command {

    public Scanner scanner;
    private MemberService memberService;
    public MemberAnnotationCheck annotationCheck;

    // call by reference, call by value
    // 얕은복사 -> 주소값을 가지게 되어 자바의 객체를 복사하게 되면은 동기화처럼 된다.
    // 깊은복사 -> 객체에 새로운 값을 가지게 된다. Cloneable
    // hashMap 에서 value 의 값이 참조형자료가 들어가게 되기 때문에 주소값을 가지게 된다.
    // private Member member = Member.builder().build();


    public MemberSignUpCm(MemberService memberService, MemberAnnotationCheck annotationCheck) {
        this.memberService = memberService;
        this.annotationCheck = annotationCheck;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        Member member = Member.builder().build();

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

    @Override
    public void undo() {

    }
}
