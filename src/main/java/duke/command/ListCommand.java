package duke.command;

import duke.TaskManager;

public class ListCommand extends Command{
    public ListCommand(String lineInput) {
        super(lineInput);
    }

    public void performCommand(TaskManager taskManager) {
        taskManager.printAllTasks();
    }
}
