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

    @Override
    public void singUpGenre(int genreNumber, Video video) {

        switch (genreNumber) {
            case 1:
                video.setGenre(Genre.ROMANTIC); break;
            case 2:
                video.setGenre(Genre.SF); break;
            case 3:
                video.setGenre(Genre.COMEDY); break;
            case 4:
                video.setGenre(Genre.HORROR); break;
            case 5:
                video.setGenre(Genre.ACTION); break;
        }
    }
}
