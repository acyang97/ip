package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskManager;

import java.io.IOException;

/**
 * AddTaskCommand that is a subclass of Command.
 * Main function is to execute the method to add a task.
 */
public class AddTaskCommand extends Command {
    /**
     * commandMethod that could be todo, event or deadline.
     */
    private String commandMethod;

    /**
     * Constructor for a AddTaskCommand object.
     * @param lineInput
     * @param commandMethod
     */
    public AddTaskCommand(String lineInput, String commandMethod) {
        super(lineInput);
        this.commandMethod = commandMethod;
    }

    /**
     * method to perform the command to add task to the taskManager object.
     * @param taskManager
     * @param storage
     */
    public void performCommand(TaskManager taskManager, Storage storage) {
        try {
            taskManager.addTask(this.commandMethod, super.getCommand(), storage);
        } catch (DukeException | IOException e) {
            System.out.println(e);
        }
    }
}
