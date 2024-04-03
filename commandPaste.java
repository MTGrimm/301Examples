public class PasteCommand extends Command {
    private Document document; // model
    private int position;
    private String text;
    ...

    public PasteCommand (Document document, int position, String text) {
        this.document = document;
        this.position = position;
        this.text = text;
    }

    public void execute() {
        document.insertText(position, text);
    }
    public void unexecute() {
        document.deleteText(position, text.length());
    }
    public boolean isReversible() {
        return true;
    }
}

public class CommandManager {
    private LinkedList<Command> historyList;
    private LinkedList<Command> redoList;

    private CommandManager() {
        historylist = new LinkedList<command>();
        redoList = new LinkedList<command>();
    }

    public void invokerCommand (Command command) {
        command.execute();

        if (command.isReversible()) {
            historyList.addFirst(command);
        } else {
            historyList.clear();
        }

        if (redoList.size() > 0) {
            redoList.clear();
        }
    }


    public void undo() {
        if (historyList.size() > 0) {
            Command command = historyList.removefirst();
            command.unexecute();
            redoList.addFirst(command);
        }
    }

    public void redo() {
        if (redoList.size() > 0) {
            Command command = redoList.removeFirst();
            command.execute();
            historyList.addFirst(command);
        }
    }


    // CommandManager is a singleton
    private static final CommandManager instance = new CommandManager();
    public static CommandManager getInstance() {
        return instance;
    }
}

// somewhere in an invoker
CommandManager commandManager = CommandManager.getInstance();
Command command = new PasteCommand(aDocument, aPosition, aText);
commandManager.invokeCommand(command);




