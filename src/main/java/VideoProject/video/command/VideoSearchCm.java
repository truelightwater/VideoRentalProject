package VideoProject.video.command;

import VideoProject.video.videostore.Video;
import VideoProject.video.videostore.VideoService;

import java.util.Scanner;

public class VideoSearchCm implements Command {
    private VideoService videoService;
    Scanner scanner;

    public VideoSearchCm(VideoService videoService) {
        this.videoService = videoService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("검색하고자 하는 비디오 이름을 입력해주세요.(대소문자 구분) : ");
        videoService.findByVideo(scanner.nextLine());

        System.out.println();
    }
}
