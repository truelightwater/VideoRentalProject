package VideoProject.video.command;

public class NextHistoryCm implements Command {

    private CommandFactory commandFactory;

    public NextHistoryCm(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    @Override
    public void execute() {
        commandFactory.getNextCommand();
        System.out.println();
    }

    @Override
    public void undo() {

    }
}
