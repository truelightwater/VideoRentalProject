package VideoProject.video.videostore;

import VideoProject.video.member.Member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public interface VideoService {

    void signUpVideo(Video video);

    Video findByVideo(Long videoId);

    Collection<Video> findByAllVideo();

    public ArrayList<Video> rentalVideo(Member member, Video video, LocalDate date);

    // 비디오 대여
    public LocalDate findByRentalVideo(Long memberId);

}
