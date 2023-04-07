package VideoProject.video.videostore;

import java.util.Collection;

public interface VideoRepository {

    // 비디오 등록
    void signUpVideo(Video video);

    // 비디오 검색
    Video findByVideo(String name);

    // 비디오 리스트 조회
    Collection<Video> findByAllVideo();

}
