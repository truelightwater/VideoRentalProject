package VideoProject.video.factory;

import VideoProject.video.Annotation.MemberAnnotationCheck;
import VideoProject.video.command.Command;
import VideoProject.video.member.MemberService;
import VideoProject.video.videostore.VideoService;

public interface Factory {

    // Video
    VideoService createVideoServices();
    Command signUpVideo(VideoService videoService);
    Command searchVideo(VideoService videoService);
    Command searchAllVideo(VideoService videoService);
    Command rentalVideo(VideoService videoService);
    Command returnVideo(VideoService videoService);

    // Member
    MemberService createMemberServices();
    Command signUpMember(MemberService memberService, MemberAnnotationCheck annotationCheck);
    Command findMember(MemberService memberService);
    MemberAnnotationCheck createAnnotationCheck();

    // App
    Command history();
    Command exit();







}
