package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskManager;

import java.io.IOException;

/**
 * DeleteCommand that is a subclass of Command.
 * Main function is to execute the method to delete a task.
 */
public class DeleteCommand extends Command {
    /**
     * indexOfTaskToBeDeleted int which is index of task to be deleted in the
     * task list of the taskManager.
     */
    private int indexOfTaskToBeDeleted;

    /**
     * Constructor for a DeleteCommand method.
     * @param lineInput
     * @param indexOfTaskToBeDeleted
     */
    public DeleteCommand(String lineInput, int indexOfTaskToBeDeleted) {
        super(lineInput);
        this.indexOfTaskToBeDeleted = indexOfTaskToBeDeleted;
    }

    /**
     * method to execute the deleteTask method in the taskManager object.
     * @param taskManager
     * @param storage
     */
    public void performCommand(TaskManager taskManager, Storage storage) {
        try {
            taskManager.deleteTask(indexOfTaskToBeDeleted, storage);
        } catch (DukeException | IOException e) {
            System.out.println(e);
        }
    }
}
