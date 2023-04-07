package VideoProject.video.videostore;

import java.util.Collection;

public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository = new MemoryVideoRepository();

    @Override
    public void signUpVideo(Video video) {
        videoRepository.signUpVideo(video);
        System.out.println();
    }

    @Override
    public Video findByVideo(String name) {
        return videoRepository.findByVideo(name);
    }

    @Override
    public Collection<Video> findByAllVideo() {
        return videoRepository.findByAllVideo();
    }

    @Override
    public void booleanRental(Video video) {
        if (video.getRental() == false) {
            video.setRental(true);
        }
    }
}
