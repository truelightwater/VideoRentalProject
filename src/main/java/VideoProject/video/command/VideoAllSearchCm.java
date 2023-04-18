package VideoProject.video.command;

import VideoProject.video.videostore.VideoService;

import java.util.Scanner;

public class VideoAllSearchCm implements Command {
    private VideoService videoService;

    public VideoAllSearchCm(VideoService videoService) {
        this.videoService = videoService;
    }

    @Override
    public void execute() {
        videoService.findByAllVideo();
        System.out.println();
    }
}
