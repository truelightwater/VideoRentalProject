package VideoProject.video.command;

import VideoProject.video.videostore.VideoService;

import java.util.Scanner;

public class VideoRentalCm implements Command {
    private VideoService videoService;
    Scanner scanner;

    public VideoRentalCm(VideoService videoService) {
        this.videoService = videoService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("대여 할 회원을 입력해주세요. : ");
        String rentalMemberName = scanner.nextLine();

        System.out.print("대여 할 비디오를 입력하세요 : ");
        String rentalVideoName = scanner.nextLine();

        // 비디오 대여 (대여한 사람, 대여할 비디오)
        videoService.rentalVideo(rentalMemberName, rentalVideoName);
        System.out.println();
    }
}
