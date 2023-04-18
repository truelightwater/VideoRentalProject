package VideoProject.video;

import VideoProject.video.command.Command;
import VideoProject.video.command.VideoReturnCm;
import VideoProject.video.member.Member;
import VideoProject.video.member.MemberService;
import VideoProject.video.member.MemberServiceImpl;
import VideoProject.video.videostore.Genre;
import VideoProject.video.videostore.Video;
import VideoProject.video.videostore.VideoService;
import VideoProject.video.videostore.VideoServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Scanner;

@SpringBootApplication
public class VideoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(VideoApplication.class, args);

		VideoService videoService = new VideoServiceImpl();
		Scanner scanner = new Scanner(System.in);

		Command videoReturnCm = new VideoReturnCm(videoService);
		videoReturnCm.execute();



	}

}
