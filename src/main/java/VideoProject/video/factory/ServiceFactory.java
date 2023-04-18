package VideoProject.video.factory;

import VideoProject.video.Annotation.MemberAnnotationCheck;
import VideoProject.video.command.*;
import VideoProject.video.member.MemberService;
import VideoProject.video.member.MemberServiceImpl;
import VideoProject.video.videostore.VideoService;
import VideoProject.video.videostore.VideoServiceImpl;

public class ServiceFactory implements VideoFactory, MemberFactory, AppFactory {

    //////////////// 멤버
    @Override
    public MemberService createMemberServices() { return new MemberServiceImpl(); }

    @Override
    public Command signUpMember(MemberService memberService, MemberAnnotationCheck annotationCheck) {
        return new MemberSignUpCm(memberService, annotationCheck);
    }
    @Override
    public Command findMember(MemberService memberService) {
        return new MemberFindCm(memberService);
    }
    @Override
    public MemberAnnotationCheck createAnnotationCheck() {
        return new MemberAnnotationCheck();
    }

    //////////////// 비디오
    @Override
    public VideoService createVideoServices() {
        return new VideoServiceImpl();
    }

    @Override
    public Command signUpVideo(VideoService videoService) {
        return new VideoRegistrationCm(videoService);
    }

    @Override
    public Command searchVideo(VideoService videoService) {
        return new VideoSearchCm(videoService);
    }

    @Override
    public Command searchAllVideo(VideoService videoService) {
        return new VideoAllSearchCm(videoService);
    }

    @Override
    public Command rentalVideo(VideoService videoService) {
        return new VideoRentalCm(videoService);
    }

    @Override
    public Command returnVideo(VideoService videoService) {
        return new VideoReturnCm(videoService);
    }


    //////////////// 어플리케이션
    @Override
    public Command history() {
        return new HistoryCm();
    }

    @Override
    public Command exit() {
        return new ExitCm();
    }


}
