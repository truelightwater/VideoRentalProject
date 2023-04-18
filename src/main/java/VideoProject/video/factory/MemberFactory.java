package VideoProject.video.factory;

import VideoProject.video.Annotation.MemberAnnotationCheck;
import VideoProject.video.command.Command;
import VideoProject.video.member.MemberService;

public interface MemberFactory {

    MemberAnnotationCheck createAnnotationCheck();
    MemberService createMemberServices();

    Command signUpMember(MemberService memberService, MemberAnnotationCheck annotationCheck);

    Command findMember(MemberService memberService);

    Command history();

    Command exit();

}
