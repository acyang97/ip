public class LineParser {
    private String lineInput;

    public LineParser(String lineInput) {
        this.lineInput = lineInput;
    }

    public Command getTypeOfCommand() {
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
        } else {
            command = new AddTaskCommand(this.lineInput, commandMethod);
        }
        return command;
    }
}
