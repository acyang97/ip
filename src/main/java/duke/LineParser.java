package duke;

import duke.command.*;

public class LineParser {
    private String lineInput;

    public LineParser(String lineInput) {
        this.lineInput = lineInput;
    }

    public Command getTypeOfCommand() throws DukeException {
        Command command;
        String commandMethod = lineInput.split(" ")[0];
        if (commandMethod.equals("bye")) {
            command = new ByeCommand(this.lineInput);
        } else if (commandMethod.equals("list")) {
            command = new ListCommand(this.lineInput);
        } else if (commandMethod.equals("done")) {
            String indexOfTaskToBeMarkAsDone = lineInput.split(" ")[1];
            int indexInInteger = Integer.parseInt(indexOfTaskToBeMarkAsDone);
            command = new DoneCommand(this.lineInput, indexInInteger);
        } else if (commandMethod.equals("delete")) {
            String indexOfTaskToDeleted = lineInput.split(" ")[1];
            int indexInInteger = Integer.parseInt(indexOfTaskToDeleted);
            command = new DeleteCommand(this.lineInput, indexInInteger);
        } else if (checkAddCommand(commandMethod)) {
            command = new AddTaskCommand(this.lineInput, commandMethod);
        } else {
            throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
        return command;
    }

    private boolean checkAddCommand(String command) {
        return command.equals("todo") || command.equals("event") || command.equals("deadline");
    }
}