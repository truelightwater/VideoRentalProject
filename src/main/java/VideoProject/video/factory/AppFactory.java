package VideoProject.video.factory;

import VideoProject.video.command.Command;

public interface AppFactory {
    Command history();

    Command exit();
}
