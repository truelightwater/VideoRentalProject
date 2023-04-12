package VideoProject.video;

import VideoProject.video.member.Member;
import VideoProject.video.member.MemberService;
import VideoProject.video.member.MemberServiceImpl;
import VideoProject.video.videostore.Genre;
import VideoProject.video.videostore.Video;
import VideoProject.video.videostore.VideoService;
import VideoProject.video.videostore.VideoServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class VideoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(VideoApplication.class, args);

		VideoService videoService = new VideoServiceImpl();
		MemberService memberService = new MemberServiceImpl();

		Video video1 = new Video("kill");
		video1.setGenre(Genre.ACTION);
		video1.setRentalDate(LocalDate.of(2023, 04, 10));
		video1.setReturnDate(LocalDate.of(2023, 04, 17));
		video1.setRental(true);

		Video video2 = new Video("love");
		video2.setGenre(Genre.ROMANTIC);
		video2.setRentalDate(LocalDate.of(2023, 04, 11));
		video2.setReturnDate(LocalDate.of(2023, 04, 18));
		video2.setRental(true);

		Video video3 = new Video("starWars");
		video3.setGenre(Genre.SF);
		video3.setRentalDate(LocalDate.of(2023, 04, 12));
		video3.setReturnDate(LocalDate.of(2023, 04, 19));
		video3.setRental(true);

		Video video4 = new Video("ost");
		video4.setGenre(Genre.COMEDY);
		video4.setRentalDate(LocalDate.of(2023, 04, 13));
		video4.setReturnDate(LocalDate.of(2023, 04, 20));
		video4.setRental(true);

		videoService.signUpVideo(video1);
		videoService.signUpVideo(video2);
		videoService.signUpVideo(video3);
		videoService.signUpVideo(video4);

		Member member = Member.builder()
				.name("kim")
				.phoneNumber("010-1234-1234")
				.age(34)
				.build();
		memberService.join(member);

		Member member1 = Member.builder()
						.name("yun")
						.phoneNumber("010-5678-5678")
						.age(31)
						.build();
		memberService.join(member1);

		memberService.findMember("kim");
	}

}
