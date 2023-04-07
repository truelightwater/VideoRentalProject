package VideoProject.video;

import VideoProject.video.member.Member;
import VideoProject.video.member.MemberService;
import VideoProject.video.member.MemberServiceImpl;
import VideoProject.video.videostore.Genre;
import VideoProject.video.videostore.Video;
import VideoProject.video.videostore.VideoService;
import VideoProject.video.videostore.VideoServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Collection;

@SpringBootApplication
public class VideoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(VideoApplication.class, args);

		VideoService videoService = new VideoServiceImpl();

		Video video1 = new Video();
		video1.setName("kill");
		video1.setGenre(Genre.ACTION);
		video1.setRentalDate(LocalDate.now());
		video1.setReturnDate(LocalDate.of(2023, 04, 10));
		video1.setRental(true);

		videoService.signUpVideo(video1);

		Video video2 = new Video();
		video2.setName("love");
		video2.setGenre(Genre.COMEDY);
		video2.setRentalDate(LocalDate.of(2023, 04, 10));
		video2.setReturnDate(LocalDate.of(2023, 04, 17));
		video2.setRental(true);

		videoService.signUpVideo(video2);

		videoService.findByAllVideo();
		System.out.println();

		videoService.findByVideo("kill");


	}

}
