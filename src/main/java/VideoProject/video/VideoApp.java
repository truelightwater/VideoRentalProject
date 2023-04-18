package VideoProject.video;

import VideoProject.video.command.Command;
import VideoProject.video.member.MemberService;
import VideoProject.video.member.MemberServiceImpl;
import VideoProject.video.videostore.VideoService;
import VideoProject.video.videostore.VideoServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VideoApp {
    public static void main(String[] args) {

        VideoService videoService = new VideoServiceImpl();
        MemberService memberService = new MemberServiceImpl();

        List<Integer> history = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int choice = 1;

        CommandFactory commandFactory
                = new CommandFactory(videoService, memberService);

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

                // 입력한 숫자를 ArrayList()로 add
                history.add(choice);

                Command command = commandFactory.createCommand(choice);
                command.execute();

            } while (choice < 1 || choice > 9);

        }
    }
}
