package VideoProject.video.command;

import VideoProject.video.videostore.Video;
import VideoProject.video.videostore.VideoService;

import java.util.Scanner;

public class VideoRegistrationCm implements Command {
    private VideoService videoService;
    Scanner scanner;

    public VideoRegistrationCm(VideoService videoService) {
        this.videoService = videoService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("비디오 제목을 입력해주세요. : ");
        String videoName = scanner.nextLine();

        System.out.println("비디오 장르를 입력해주세요. (1)로맨스 (2)SF (3)코미디 (4)호러 (5)액션");
        System.out.print("비디오 장르는 번호를 입력해주세요 : ");
        int genre = scanner.nextInt();
        scanner.nextLine();

        // 비디오 생성자
        Video newVideo = new Video(videoName);
        newVideo.setName(videoName);

        // 비디오 장르 등록
        videoService.singUpGenre(genre, newVideo);

        // 비디오 등록
        videoService.signUpVideo(newVideo);

        System.out.println();
    }

    @Override
    public void undo() {

    }
}
