package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskManager;

import java.io.IOException;

public class FindCommand extends Command {
    private String keyWord;

    public FindCommand(String lineInput, String keyWord) {
        super(lineInput);
        this.keyWord = keyWord;
    }

    @Override
    public void performCommand(TaskManager taskManager, Storage storage) {
        taskManager.findTasks(this.keyWord, storage);
    }
}
