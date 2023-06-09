package VideoProject.video.videostore;


import java.util.Collection;


public interface VideoService {

    // 비디오 등록
    void signUpVideo(Video video);

    // 비디오 찾기
    Video findByVideo(String name);

    // 비디오 전체 조회
    Collection<Video> findByAllVideo();

    // 비디오 대여여부 체크
    void booleanRental(Video video);

    // 비디오 장르 등록
    void singUpGenre(int genreNumber, Video video);

    // 비디오 대여
    void rentalVideo(String memberName, String videoName);

    // 비디오 반납 확인
    void returnVideo(String memberName);



}
