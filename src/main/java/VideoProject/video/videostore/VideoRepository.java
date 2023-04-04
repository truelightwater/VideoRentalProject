package VideoProject.video.videostore;

public interface VideoRepository {

    // 비디오 등록
    void signUpVideo(Video video);

    // 비디오 검색
    Video findByVideo(Long videoId);

    // 비디오 리스트 조회
    Video findByAllVideo();
}
