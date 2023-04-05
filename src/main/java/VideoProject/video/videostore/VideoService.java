package VideoProject.video.videostore;

import java.time.LocalDate;
import java.util.Collection;

public interface VideoService {

    void signUpVideo(Video video);

    Video findByVideo(Long videoId);

    Collection<Video> findByAllVideo();

    // 비디오 대여
    public LocalDate findByRentalVideo(Long memberId);

}
