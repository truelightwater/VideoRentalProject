package VideoProject.video;

import VideoProject.video.member.MemberService;
import VideoProject.video.videostore.VideoService;

public interface VideoFactory {
    MemberService createMemberServices();
    VideoService createVideoServices();
}
