package VideoProject.video.command;

import VideoProject.video.member.MemberService;

import java.util.List;
import java.util.Scanner;

public class HistoryCm implements Command {
    private List<Integer> history;

    public HistoryCm() {
    }

    @Override
    public void execute() {
        System.out.println("사용자가 입력한 번호의 목록 : " + history);
        System.out.println();
    }
}
