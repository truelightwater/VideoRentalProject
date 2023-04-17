package VideoProject.video;

import VideoProject.video.member.MemberService;
import VideoProject.video.videostore.*;

public class VideoApp {
    public static void main(String[] args) {

        // 팩토리 패턴
        ServiceFactory factory = new ServiceFactory();
        MemberService memberService = factory.createMemberServices();
        VideoService videoService = factory.createVideoServices();

        whileRunner result = new whileRunner();
        result.loop(memberService, videoService);

    }
}
