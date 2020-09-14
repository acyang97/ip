package duke.command;

import duke.TaskManager;
import duke.DukeException;

public class DeleteCommand extends Command {
    private int indexOfTaskToBeDeleted;

    public DeleteCommand(String lineInput, int indexOfTaskToBeDeleted) {
        super(lineInput);
        this.indexOfTaskToBeDeleted = indexOfTaskToBeDeleted;
    }

    public void performCommand(TaskManager taskManager) {
        try {
            taskManager.deleteTask(indexOfTaskToBeDeleted);
        } catch (DukeException e) {
            System.out.println(e);
        }
    }
}
