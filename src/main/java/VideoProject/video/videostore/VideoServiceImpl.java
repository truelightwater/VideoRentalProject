package VideoProject.video.videostore;

import VideoProject.video.member.Member;
import VideoProject.video.member.MemberRepository;
import VideoProject.video.member.MemoryMemberRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class VideoServiceImpl implements VideoService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final VideoRepository videoRepository = new MemoryVideoRepository();
    private int RentalVideoCount = 0;

    ArrayList<Video> rentalList = new ArrayList<>();

    @Override
    public void rentalVideo(Member member, Video video, LocalDate date) {

        // 비디오 총 대여 개수
        RentalVideoCount++;

        // 빌린 사람
        Member byMember = memberRepository.findByMember(member.getId());

        // 비디오 대여여부
        booleanRental(video);

        // 비디오 빌린날짜 업데이트
        updateRentalDate(video, date);

        // 비디오 반납날짜 업데이트
        updateReturnDate(video, date);

        // 빌린 비디오
        rentalList.add(video);
        byMember.setVideoList(rentalList);

    }

    public void checkOverdueDate(Video video) {
        if (video.getReturnDate().isAfter(LocalDate.now())) {
            System.out.println("이 비디오는 연체가 되었습니다.");
        }
    }

    public void updateReturnDate(Video video, LocalDate date) {
        LocalDate returnDate = date.plusDays(7);

        if (video.getReturnDate() == null) {
            video.setReturnDate(returnDate);
        }
    }

    public void updateRentalDate(Video video, LocalDate date) {
        if (video.getRentalDate() == null) {
            video.setRentalDate(date);
        }
    }

    public void booleanRental(Video video) {
        if (video.isRental() == false) {
            video.setRental(true);
        }
    }

    @Override
    public void signUpVideo(Video video) {
        videoRepository.signUpVideo(video);
    }

    @Override
    public Video findByVideo(Long videoId) {
        return videoRepository.findByVideo(videoId);
    }

    @Override
    public Collection<Video> findByAllVideo() {
        return videoRepository.findByAllVideo();
    }

    @Override
    public int getRentalVideoCount() {
        return RentalVideoCount;
    }

    @Override
    public void findMyRentalVideo(Member member) {

        for (int i = 0; i < member.getVideoList().size(); i++) {
            System.out.println(member.getVideoList().get(i));
        }
    }
}
