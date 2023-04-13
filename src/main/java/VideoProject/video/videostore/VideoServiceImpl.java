package VideoProject.video.videostore;

import VideoProject.video.member.Member;
import VideoProject.video.member.MemberService;
import VideoProject.video.member.MemberServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.*;

public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository = new MemoryVideoRepository();
    private final MemberService memberService = new MemberServiceImpl();
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final Map<Member, ArrayList<Video>> memberVideo = new HashMap<>();
    ArrayList<Video> arrayList = new ArrayList<>();

    @Override
    public void signUpVideo(Video video) {
        videoRepository.signUpVideo(video);
        System.out.println();
    }

    @Override
    public Video findByVideo(String name) {
        return videoRepository.findByVideo(name);
    }

    @Override
    public Collection<Video> findByAllVideo() {
        return videoRepository.findByAllVideo();
    }

    @Override
    public void booleanRental(Video video) {
        if (video.getRental() == false) {
            video.setRental(true);
        } else {
            video.setRental(false);
        }
    }

    @Override
    public void singUpGenre(int genreNumber, Video video) {
        switch (genreNumber) {
            case 1:
                video.setGenre(Genre.ROMANTIC); break;
            case 2:
                video.setGenre(Genre.SF); break;
            case 3:
                video.setGenre(Genre.COMEDY); break;
            case 4:
                video.setGenre(Genre.HORROR); break;
            case 5:
                video.setGenre(Genre.ACTION); break;
        }
    }

    @Override
    public void rentalVideo(String memberName, String videoName) {

        LocalDate today = LocalDate.now();

        Member rentalMember = memberService.findMember(memberName);
        Video rentalVideo = videoRepository.findByVideo(videoName);

        if (rentalMember == null || rentalVideo == null) {
            return;
        }

        // 대여날짜
        rentalVideo.setRentalDate(today);

        // 반납날짜
        rentalVideo.setReturnDate(today.plusDays(7));

        // 비디오 대여여부 체크
        rentalVideo.setRental(true);


        // 대여한 멤버 + 대여한 비디오 등록
        arrayList.add(rentalVideo);
        rentalMember.setArrayList(arrayList);
        addValueToMap(memberVideo, rentalMember, rentalVideo);
    }

    public void addValueToMap(Map<Member, ArrayList<Video>> map, Member member, Video video) {
        if (map.containsKey(member)) {
            map.get(member).add(video);
        } else {
            ArrayList<Video> list = new ArrayList<>();
            list.add(video);
            map.put(member, list);
        }
    }

    @Override
    public void returnVideo(String memberName) {
        Member rentalMember = memberService.findMember(memberName);

        Optional.ofNullable(memberVideo.get(rentalMember))
                .ifPresentOrElse(videoArrayList -> videoArrayList.forEach(System.out::println),
                        () -> log.info("**** 대여 한 비디오가 없습니다. ****"));
    }
}
