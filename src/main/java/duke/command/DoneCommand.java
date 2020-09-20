package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskManager;

import java.io.IOException;

/**
 * DoneCommand that is a subclass of Command.
 * Main function is to execute the markTaskAsDone method in the TaskManager.
 */
public class DoneCommand extends Command {
    /**
     * indexOfTaskToBeMarkedAsDone int index of task to be marked as done.
     */
    private int indexOfTaskToBeMarkedAsDone;

    /**
     * Constructor for the DoneCommand Object.
     * @param lineInput
     * @param indexOfTaskToBeMarkedAsDone
     */
    public DoneCommand(String lineInput, int indexOfTaskToBeMarkedAsDone) {
        super(lineInput);
        this.indexOfTaskToBeMarkedAsDone = indexOfTaskToBeMarkedAsDone;
    }

    /**
     * Method to execute the markTaskAsDone method in the taskManager object.
     * @param taskManager
     * @param storage
     */
    public void performCommand(TaskManager taskManager, Storage storage) {
        try {
            taskManager.markTaskAsDone(indexOfTaskToBeMarkedAsDone, storage);
        } catch (DukeException | IOException e) {
            System.out.println(e);
        }
    }
}
