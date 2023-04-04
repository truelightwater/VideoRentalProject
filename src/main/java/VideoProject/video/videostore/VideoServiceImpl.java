package VideoProject.video.videostore;

import VideoProject.video.member.MemberRepository;
import VideoProject.video.member.MemoryMemberRepository;

import java.time.LocalDate;

public class VideoServiceImpl implements VideoService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final VideoRepository videoRepository = new MemoryVideoRepository();
    @Override
    public LocalDate findByRentalVideo(Video video) {
        //
        //
        //

        return video.getRentalDate();
    }
}
