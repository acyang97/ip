package duke.command;

import duke.TaskManager;

public class ByeCommand extends Command {
    public ByeCommand(String lineInput) {
        super(lineInput);
    }

    public void performCommand(TaskManager taskManager) {
        taskManager.setTaskManagerSaidBye();
        System.out.println("Bye. Hope to see you again!");
    }
}
