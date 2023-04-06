package VideoProject.video;

import VideoProject.video.member.*;
import VideoProject.video.videostore.*;

import java.time.LocalDate;

public class VideoApp {
    public static void main(String[] args) {

        VideoService videoService = new VideoServiceImpl();
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

        videoService.signUpVideo(video1);
        videoService.signUpVideo(video2);
        videoService.signUpVideo(video3);
        videoService.signUpVideo(video4);
        videoService.signUpVideo(video5);

/*        Video findVideo = videoService.findByVideo(2L);
        Collection<Video> AllVideo = videoService.findByAllVideo();

        System.out.println("new Video = " + video1);
        System.out.println("find Video = " + findVideo);
        System.out.println("All Video = " + AllVideo);*/

        // 대여하는 사람, 비디오, 대여날짜 (member1)
        videoService.rentalVideo(member1, video1, LocalDate.parse("2023-03-30"));
        videoService.rentalVideo(member1, video2, LocalDate.now());

//        videoService.rentalVideo(member2 ,video3, LocalDate.parse("2023-03-30"));
//        videoService.rentalVideo(member2, video4, LocalDate.now());


        // 비디오 대여 및 반납 확인
        videoService.findMyRentalVideo(member1);


    }
}
