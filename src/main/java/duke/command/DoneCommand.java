package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskManager;

public class DoneCommand extends Command {
    private int indexOfTaskToBeMarkedAsDone;

    public DoneCommand(String lineInput, int indexOfTaskToBeMarkedAsDone) {
        super(lineInput);
        this.indexOfTaskToBeMarkedAsDone = indexOfTaskToBeMarkedAsDone;
    }

    public void performCommand(TaskManager taskManager, Storage storage) {
        try {
            taskManager.markTaskAsDone(indexOfTaskToBeMarkedAsDone);
        } catch (DukeException e) {
            System.out.println(e);
        }
    }

}
