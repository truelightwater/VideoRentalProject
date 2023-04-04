package VideoProject.video.videostore;

import java.time.LocalDate;

public interface VideoService {

    // 비디오 대여
    LocalDate findByRentalVideo(Video video);
}
