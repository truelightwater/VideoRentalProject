package VideoProject.video;

import VideoProject.video.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class VideoInvoker {
    private final Map<Integer, Command> commandMap = new HashMap<>();
    private final Logger log = LoggerFactory.getLogger(getClass());


    public VideoInvoker() {
    }

    public void setCommand(Integer number) {
        Command command = commandMap.get(number);

        if (command == null) {
            log.info("잘못된 명령입니다.");
            return;
        }
        command.execute();
    }
}
