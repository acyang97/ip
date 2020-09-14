package duke.command;

import duke.Storage;
import duke.TaskManager;

public class ListCommand extends Command{
    public ListCommand(String lineInput) {
        super(lineInput);
    }

    public void performCommand(TaskManager taskManager, Storage storage) {
        taskManager.printAllTasks();
    }
}
