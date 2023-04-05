package VideoProject.video.videostore;

import VideoProject.video.member.Member;
import VideoProject.video.member.MemberRepository;
import VideoProject.video.member.MemoryMemberRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VideoServiceImpl implements VideoService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final VideoRepository videoRepository = new MemoryVideoRepository();
    private int count = 0;

    @Override
    public Map<Integer, ArrayList> rentalVideo(Member member, Video video, LocalDate date) {

        // 비디오 총 대여 개수
        count++;

        ArrayList<Video> arrayList = new ArrayList<>();
        Map<Integer, ArrayList> rentals = new HashMap<>();

        // 빌린 사람
        Member byMember = memberRepository.findByMember(member.getId());

        // 빌린 비디오
        arrayList.add(video);
        byMember.setVideoList(arrayList);

        // 반납 날짜
        LocalDate returnDate = date.plusDays(7);

        // 비디오 대여여부
        if (video.isRental() == false) {
            video.setRental(true);
        }

        // 비디오 빌린날짜 업데이트
        if (video.getRentalDate() == null) {
            video.setRentalDate(date);
        }

        // 비디오 반납날짜 업데이트
        if (video.getReturnDate() == null) {
            video.setReturnDate(returnDate);
        }


        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        rentals.put(count, arrayList);


        return rentals;
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
    public LocalDate findByRentalVideo(Long memberId) {
        Member member = memberRepository.findByMember(memberId);
        return null;
    }
}
