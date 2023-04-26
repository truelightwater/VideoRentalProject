package VideoProject.video.command;

public class HistoryCm implements Command {

    private CommandFactory commandFactory;

    public HistoryCm(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    @Override
    public void execute() {
        System.out.println("사용자가 입력한 번호의 목록 : " +commandFactory.getCommandHistory());
        System.out.println();
    }

    @Override
    public void undo() {

    }
}
