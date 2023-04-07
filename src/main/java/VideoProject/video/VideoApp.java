package VideoProject.video;

import VideoProject.video.member.*;
import VideoProject.video.videostore.*;

import java.time.LocalDate;
import java.util.Scanner;

public class VideoApp {
    public static void main(String[] args) {

        VideoService videoService = new VideoServiceImpl();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {

            do {
                System.out.println("(1)비디오 등록 (2)비디오 검색 (3)비디오 전체조회 (4)비디오 대여 (5)종료");
                System.out.print("원하는 번호를 입력하세요 : ");
                choice = scanner.nextInt();
            } while (choice < 1 || choice > 5);

            switch (choice) {
                case 1:
                    // 생성자 초기화
                    Video newVideo = new Video();
                    String name = "";
                    int genre = 0;
                    LocalDate today = LocalDate.now();

                    System.out.print("비디오 제목을 입력해주세요. : ");
                    newVideo.setName(scanner.next());

                    System.out.println("비디오 장르를 입력해주세요.");
                    System.out.println("(1)로맨스 (2)SF (3)코미디 (4)호러 (5)액션 ");
                    System.out.print("비디오 장르는 번호를 입력해주세요 : ");
                    genre = scanner.nextInt();

                    switch (genre) {
                        case 1:
                            newVideo.setGenre(Genre.ROMANTIC); break;
                        case 2:
                            newVideo.setGenre(Genre.SF); break;
                        case 3:
                            newVideo.setGenre(Genre.COMEDY); break;
                        case 4:
                            newVideo.setGenre(Genre.HORROR); break;
                        case 5:
                            newVideo.setGenre(Genre.ACTION); break;
                    }

                    // 대여날짜
                    newVideo.setRentalDate(today);

                    // 반납날짜
                    newVideo.setReturnDate(today.plusDays(7));

                    // 비디오 등록
                    videoService.signUpVideo(newVideo);

                    // 비디오 대여여부 체크
                    videoService.booleanRental(newVideo);
                    System.out.println();
                    break;


                case 2:
                    System.out.print("검색하고자 하는 비디오 이름을 입력해주세요. : ");
                    name = scanner.next();

                    videoService.findByVideo(name);
                    System.out.println();
                    break;


                case 3:
                    videoService.findByAllVideo();
                    System.out.println();
                    break;


                case 4:
                    break;


                case 5:

                    break;

            }



        }


    }
}
