package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskManager;

import java.io.IOException;

public class DeleteCommand extends Command {
    private int indexOfTaskToBeDeleted;

    public DeleteCommand(String lineInput, int indexOfTaskToBeDeleted) {
        super(lineInput);
        this.indexOfTaskToBeDeleted = indexOfTaskToBeDeleted;
    }


    public void performCommand(TaskManager taskManager, Storage storage) {
        try {
            taskManager.deleteTask(indexOfTaskToBeDeleted, storage);
        } catch (DukeException | IOException e) {
            System.out.println(e);
        }
    }
}
