package VideoProject.video;

import VideoProject.video.member.*;
import VideoProject.video.videostore.Genre;
import VideoProject.video.videostore.MemoryVideoRepository;
import VideoProject.video.videostore.Video;
import VideoProject.video.videostore.VideoRepository;

import java.util.Collection;

public class VideoApp {
    public static void main(String[] args) {

        VideoRepository videoRepository = new MemoryVideoRepository();
        MemberService memberService = new MemberServiceImpl();

        Video video1 = new Video(1L, "길복순", 137, Genre.ACTION);
        Video video2 = new Video(2L, "승리호", 136, Genre.SF);
        Video video3 = new Video(3L, "콘스탄틴", 120, Genre.HORROR);
        Video video4 = new Video(4L, "헤어질 결심", 138, Genre.ROMANTIC);
        Video video5 = new Video(5L, "에브리씽 에브리웨어 올앳원스", 139, Genre.COMEDY);

        Member member1 = new Member(1L, "member1", "1234-1234", "영등포구", 34);
        Member member2 = new Member(2L, "member2", "5345-3412", "관악구", 31);
        Member member3 = new Member(3L, "member3", "9012-5724", "양천구", 26);
        Member member4 = new Member(4L, "member4", "6755-2567", "강서구", 21);
        Member member5 = new Member(5L, "member5", "3355-1677", "강남구", 24);

        memberService.join(member1);
        memberService.join(member2);
        memberService.join(member3);
        memberService.join(member4);
        memberService.join(member5);

        videoRepository.signUpVideo(video1);
        videoRepository.signUpVideo(video2);
        videoRepository.signUpVideo(video3);
        videoRepository.signUpVideo(video4);
        videoRepository.signUpVideo(video5);

        Video findVideo = videoRepository.findByVideo(2L);
        Collection<Video> AllVideo = videoRepository.findByAllVideo();

        System.out.println("new Video = " + video1);
        System.out.println("find Video = " + findVideo);
        System.out.println("All Video = " + AllVideo);

    }
}
