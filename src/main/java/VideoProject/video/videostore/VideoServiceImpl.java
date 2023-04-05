package VideoProject.video.videostore;

import VideoProject.video.member.Member;
import VideoProject.video.member.MemberRepository;
import VideoProject.video.member.MemoryMemberRepository;

import java.time.LocalDate;
import java.util.Collection;

public class VideoServiceImpl implements VideoService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final VideoRepository videoRepository = new MemoryVideoRepository();


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
        return member.getRentalDate();
    }
}
