package VideoProject.video;

import VideoProject.video.command.*;
import VideoProject.video.member.MemberService;
import VideoProject.video.videostore.VideoService;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private final Map<Integer, Command> commandMap = new HashMap<>();

    public CommandFactory(VideoService videoService, MemberService memberService) {
        commandMap.put(1, new VideoRegistrationCm(videoService));
        commandMap.put(2, new VideoSearchCm(videoService));
        commandMap.put(3, new VideoAllSearchCm(videoService));
        commandMap.put(4, new VideoRentalCm(videoService));
        commandMap.put(5, new VideoReturnCm(videoService));
        commandMap.put(6, new MemberSignUpCm(memberService));
        commandMap.put(7, new MemberFindCm(memberService));
        commandMap.put(8, new HistoryCm());
        commandMap.put(9, new ExitCm());
    }

    public Command createCommand(int choice) {
        return commandMap.get(choice);
    }
}
