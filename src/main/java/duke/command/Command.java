package duke.command;

import duke.Storage;
import duke.TaskManager;

public abstract class Command {
    protected String command;

    public Command(String command) {
        this.command = command;
    }

    protected String getCommand() {
        return command;
    }

    public abstract void performCommand(TaskManager taskManager, Storage storage);
}
