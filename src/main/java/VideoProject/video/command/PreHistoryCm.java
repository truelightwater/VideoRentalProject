package VideoProject.video.command;

public class PreHistoryCm implements Command {

    private CommandFactory commandFactory;

    public PreHistoryCm(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    @Override
    public void execute() {
        commandFactory.getPreviousCommand();
        System.out.println();
    }

    @Override
    public void undo() {

    }
}
