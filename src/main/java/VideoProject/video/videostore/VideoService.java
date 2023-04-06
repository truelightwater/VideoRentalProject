package VideoProject.video.videostore;

import VideoProject.video.member.Member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public interface VideoService {

    // 비디오 등록
    void signUpVideo(Video video);

    // 비디오 찾기
    Video findByVideo(Long videoId);

    // 비디오 전체 조회
    Collection<Video> findByAllVideo();

    // 비디오 대여
    public void rentalVideo(Member member, Video video, LocalDate date);

    // 비디오 대여+반납 확인
    public  void findMyRentalVideo(Member member);

    // 비디오 가게 총 대여갯수
    public int getRentalVideoCount();

}
