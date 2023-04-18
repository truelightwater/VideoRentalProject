package VideoProject.video.command;

public class ExitCm implements Command {


    @Override
    public void execute() {
        System.exit(0);
    }
}
