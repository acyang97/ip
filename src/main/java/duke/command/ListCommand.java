package duke.command;

import duke.Storage;
import duke.TaskManager;

/**
 * ListCommand class that is a subclass of Command.
 * Main function is to perform the printAllTasks method in the TaskManager.
 */
public class ListCommand extends Command{
    /**
     * Constuctor for a ListCommand object.
     * @param lineInput
     */
    public ListCommand(String lineInput) {
        super(lineInput);
    }

    /**
     * method to help perform the printAllTasks method of the TaskManager object.
     * @param taskManager
     * @param storage
     */
    public void performCommand(TaskManager taskManager, Storage storage) {
        taskManager.printAllTasks();
    }
}
