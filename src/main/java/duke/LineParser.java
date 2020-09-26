package duke;

import duke.command.*;

/**
 * The LineParser class represents a parser that helps to parse a line.
 * It's main function is to help to return a Command object given a line input.
 * This is the Parser class as required for the project.
 */
public class LineParser {
    /**
     * lineInput String that is the line input of the user.
     */
    private String lineInput;

    /**
     * Creates a LineParser object.
     * @param lineInput String denoting the line input of the user.
     */
    public LineParser(String lineInput) {
        this.lineInput = lineInput;
    }

    /**
     * Method that returns a Command object depending on the type of Command.
     * @return a Command Object depending on type of Command.
     * @throws DukeException when the Command is an invalid Command.
     */
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
        } else if (commandMethod.equals("find")) {
            String keyWord = lineInput.split(" ")[1];
            command = new FindCommand(this.lineInput, keyWord);
        } else if (checkAddCommand(commandMethod)) {
            command = new AddTaskCommand(this.lineInput, commandMethod);
        } else {
            throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
        return command;
    }

    /**
     * A private helper method to check if it is a command to add a Task.
     * @param command line to be parsed.
     * @return true if it is a type of command to add a Task.
     */
    private boolean checkAddCommand(String command) {
        return command.equals("todo") || command.equals("event") || command.equals("deadline");
    }
}