package VideoProject.video;

import VideoProject.video.member.MemberService;
import VideoProject.video.member.MemberServiceImpl;
import VideoProject.video.videostore.VideoService;
import VideoProject.video.videostore.VideoServiceImpl;

public class ServiceFactory implements VideoFactory {
    @Override
    public MemberService createMemberServices() {
        return new MemberServiceImpl();
    }

    @Override
    public VideoService createVideoServices() {
        return new VideoServiceImpl();
    }
}
