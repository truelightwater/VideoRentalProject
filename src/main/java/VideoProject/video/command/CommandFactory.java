package VideoProject.video.command;

import VideoProject.video.Annotation.MemberAnnotationCheck;
import VideoProject.video.member.MemberService;
import VideoProject.video.videostore.VideoService;

import java.util.*;

public class CommandFactory {
    private final Map<Integer, Command> commandMap = new HashMap<>();
    private final List<Integer> commandHistory = new ArrayList<>();
    private int currentIndex = -1;

    public CommandFactory() {
    }

    public CommandFactory(VideoService videoService, MemberService memberService,
                          MemberAnnotationCheck annotationCheck) {

        commandMap.put(1, new VideoRegistrationCm(videoService));
        commandMap.put(2, new VideoSearchCm(videoService));
        commandMap.put(3, new VideoAllSearchCm(videoService));
        commandMap.put(4, new VideoRentalCm(videoService));
        commandMap.put(5, new VideoReturnCm(videoService));
        commandMap.put(6, new MemberSignUpCm(memberService, annotationCheck));
        commandMap.put(7, new MemberFindCm(memberService));
        commandMap.put(8, new HistoryCm(this));
        commandMap.put(9, new PreHistoryCm(this));
        commandMap.put(10, new NextHistoryCm(this));
        commandMap.put(11, new ExitCm());
    }

    public Command createCommand(int choice) {
        commandHistory.add(choice);
        currentIndex = commandHistory.size() - 1;
        return commandMap.get(choice);
    }

    public List<Integer> getCommandHistory() {
        return commandHistory;
    }

    public void getPreviousCommand() {
        if (currentIndex > 0) {
            currentIndex--;
            Command previousCommand = commandMap.get(commandHistory.get(currentIndex));
            previousCommand.execute();
        }
    }

    public void getNextCommand() {
        if (currentIndex < commandHistory.size() - 1) {
            currentIndex++;
            Command nextCommand = commandMap.get(commandHistory.get(currentIndex));
            nextCommand.execute();
        }
    }

}
