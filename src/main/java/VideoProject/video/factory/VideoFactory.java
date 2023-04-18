package VideoProject.video.factory;

import VideoProject.video.Annotation.MemberAnnotationCheck;
import VideoProject.video.command.Command;
import VideoProject.video.member.MemberService;
import VideoProject.video.videostore.VideoService;

public interface VideoFactory {
    VideoService createVideoServices();
    Command signUpVideo(VideoService videoService);
    Command searchVideo(VideoService videoService);
    Command searchAllVideo(VideoService videoService);
    Command rentalVideo(VideoService videoService);
    Command returnVideo(VideoService videoService);


}
