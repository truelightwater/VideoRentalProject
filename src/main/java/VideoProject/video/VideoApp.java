package VideoProject.video;

import VideoProject.video.Annotation.MemberAnnotationCheck;
import VideoProject.video.member.Member;
import VideoProject.video.member.MemberService;
import VideoProject.video.member.MemberServiceImpl;
import VideoProject.video.videostore.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class VideoApp {
    public static void main(String[] args) {

        VideoService videoService = new VideoServiceImpl();
        MemberService memberService = new MemberServiceImpl();
        MemberAnnotationCheck annotationCheck = new MemberAnnotationCheck();
        List<Integer> history = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int choice = 1;

        while (true) {

            do {
                System.out.println("(1)비디오 등록 (2)비디오 검색 (3)비디오 전체조회 " +
                        "(4)비디오 대여 (5)비디오 반납목록 (6)회원가입 (7)회원조회 (8)히스토리 (9)종료");
                System.out.print("원하는 번호를 입력하세요 : ");

                // 입력값이 숫자가 아닌 경우
                while (!scanner.hasNextInt()) {
                    System.out.print("잘못 입력하셨습니다. 1~8 중에 숫자만 입력해주세요. : ");
                    scanner.nextLine();
                }

                // 입력한 값이 1~9가 아닌 경우
                if (choice < 1 || choice > 9) {
                    System.out.print("숫자가 아닌 다른 입력을 하셨습니다. 다시 입력해주세요.");
                    System.out.println();
                }

                choice = scanner.nextInt();
                scanner.nextLine();

                // 입력한 숫자를 ArrayList()로 add
                history.add(choice);

            } while (choice < 1 || choice > 9);


            switch (choice) {
                case 1:
                    System.out.print("비디오 제목을 입력해주세요. : ");
                    String videoName = scanner.nextLine();

                    System.out.println("비디오 장르를 입력해주세요. (1)로맨스 (2)SF (3)코미디 (4)호러 (5)액션");
                    System.out.print("비디오 장르는 번호를 입력해주세요 : ");
                    int genre = scanner.nextInt();

                    // 비디오 생성자
                    Video newVideo = new Video(videoName);
                    newVideo.setName(videoName);

                    // 비디오 장르 등록
                    videoService.singUpGenre(genre, newVideo);

                    // 비디오 등록
                    videoService.signUpVideo(newVideo);

                    System.out.println();
                    break;

                case 2:
                    System.out.print("검색하고자 하는 비디오 이름을 입력해주세요. : ");
                    videoName = scanner.nextLine();

                    videoService.findByVideo(videoName);
                    System.out.println();
                    break;


                case 3:
                    videoService.findByAllVideo();
                    System.out.println();
                    break;

                case 4:
                    System.out.print("대여 할 회원을 입력해주세요. : ");
                    String rentalMemberName = scanner.nextLine();

                    System.out.print("대여 할 비디오를 입력하세요 : ");
                    String rentalVideoName = scanner.nextLine();

                    // 비디오 대여 (대여한 사람, 대여할 비디오)
                    videoService.rentalVideo(rentalMemberName, rentalVideoName);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("회원 이름을 입력하세요 : ");
                    String memberName = scanner.nextLine();
                    videoService.returnVideo(memberName);
                    System.out.println();
                    break;

                case 6:

                    Member member = Member.builder().build();

                    System.out.print("성함을 입력해주세요. : ");
                    String name = scanner.nextLine();
                    member.setName(name);

                    System.out.print("휴대폰번호를 입력해 주세요.(하이픈 포함) : ");
                    String phoneNumber = scanner.nextLine();
                    member.setPhoneNumber(phoneNumber);

                    System.out.print("나이를 입력해주세요 : ");
                    int age = scanner.nextInt();
                    member.setAge(age);

                    annotationCheck.memberValidation(member);

                    memberService.join(member);
                    System.out.println();
                    break;

                case 7:
                    System.out.print ("회원 이름을 입력해주세요 : ");
                    name = scanner.nextLine();
                    memberService.findMember(name);
                    System.out.println();
                    break;

                case 8:
                    System.out.println("사용자가 입력한 번호의 목록 : " +history);
                    System.out.println();
                    break;


                case 9:
                    System.exit(0);
                    break;
            }
        }
    }
}
