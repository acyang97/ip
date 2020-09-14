package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskManager;

import java.io.IOException;

public class AddTaskCommand extends Command {
    private String commandMethod;

    public AddTaskCommand(String lineInput, String commandMethod) {
        super(lineInput);
        this.commandMethod = commandMethod;
    }

    public void performCommand(TaskManager taskManager, Storage storage) {
        try {
            taskManager.addTask(this.commandMethod, super.getCommand(), storage);
        } catch (DukeException | IOException e) {
            System.out.println(e);
        }
    }
}
