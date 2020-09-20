package duke.command;

import duke.Storage;
import duke.TaskManager;

/**
 * An abstract class that represents a Command object.
 */
public abstract class Command {
    /**
     * command String that is the command to be taken.
     */
    protected String command;

    /**
     * constructor for a Command object
     * @param command string that represents command to be taken.
     */
    public Command(String command) {
        this.command = command;
    }

    /**
     * Getter method.
     * @return the command.
     */
    protected String getCommand() {
        return command;
    }

    /**
     * method to perform the command.
     * @param taskManager
     * @param storage
     */
    public abstract void performCommand(TaskManager taskManager, Storage storage);
}
