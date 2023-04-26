package VideoProject.video.factory;

import VideoProject.video.Annotation.MemberAnnotationCheck;
import VideoProject.video.command.*;
import VideoProject.video.member.MemberService;
import VideoProject.video.member.MemberServiceImpl;
import VideoProject.video.videostore.VideoService;
import VideoProject.video.videostore.VideoServiceImpl;

public class ServiceFactory implements Factory {

    // 1. private 생성자
    private ServiceFactory() {
    }

    // 2. private static 인스턴스 변수
    private static ServiceFactory serviceFactory;

    // 프로그램이 시작되면 바로 메모리에 올라갈 수 있도록 하는 것은 아래처럼
    // private static ServiceFactory serviceFactory = new ServiceFactory();

    // 3. public static getInstance() method 구현
    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

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
        return new HistoryCm(new CommandFactory());
    }

    @Override
    public Command exit() {
        return new ExitCm();
    }


}
