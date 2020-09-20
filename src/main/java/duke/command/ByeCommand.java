package duke.command;

import duke.Storage;
import duke.TaskManager;

/**
 * ByeCommand class that is a subclass of Command.
 */
public class ByeCommand extends Command {
    /**
     * Constructor for a ByeCommand object.
     * @param lineInput
     */
    public ByeCommand(String lineInput) {
        super(lineInput);
    }

    /**
     * Method to help to set the taskManagerSaidBye status of the TaskManager.
     * This is to help when the user wants to exit the app.
     * @param taskManager
     * @param storage
     */
    public void performCommand(TaskManager taskManager, Storage storage) {
        taskManager.setTaskManagerSaidBye();
        System.out.println("Bye. Hope to see you again!");
    }
}
