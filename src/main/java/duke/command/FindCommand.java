package duke.command;

import duke.Storage;
import duke.TaskManager;

/**
 * FindCommand class that is a subclass of Command.
 * Main function is to perform the findTask method in the TaskManager.
 */
public class FindCommand extends Command {
    /**
     * keyWord String to check if any task contains this keyword.
     */
    private String keyWord;

    /**
     * Constructor for the FindCommand Object.
     * @param lineInput
     * @param keyWord
     */
    public FindCommand(String lineInput, String keyWord) {
        super(lineInput);
        this.keyWord = keyWord;
    }

    /**
     * method to execute the findTasks method in the TaskManager.
     * @param taskManager
     * @param storage
     */
    @Override
    public void performCommand(TaskManager taskManager, Storage storage) {
        taskManager.findTasks(this.keyWord, storage);
    }
}
