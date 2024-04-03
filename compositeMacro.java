
public abstract class Command {
    ...
}

public class PasteCommand extends Command {
    public execute() {
        // whatever paste does
    }
}

public class CopyCommand extends Command {
    public execute() {
        // whatever copy does
    }
}

public class MacroCommand extends Command {
    Commands[] commands;

    public MacroCommand(Commands[] commands) {
        this.commands = commands;
    }
    
    public execute() {
        for (int i = 0; i < this.commands.length; i++) {
            this.commands[i].execute();
        }
    }

}
