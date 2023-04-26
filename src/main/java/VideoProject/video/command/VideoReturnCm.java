package VideoProject.video.command;

import VideoProject.video.videostore.VideoService;

import java.util.Scanner;

public class VideoReturnCm implements Command {
    private VideoService videoService;
    Scanner scanner;

    public VideoReturnCm(VideoService videoService) {
        this.videoService = videoService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("회원 이름을 입력하세요 : ");
        videoService.returnVideo(scanner.nextLine());
        System.out.println();
    }

    @Override
    public void undo() {

    }
}
