public class AddTaskCommand extends Command {
    private String commandMethod;

    public AddTaskCommand(String lineInput, String commandMethod) {
        super(lineInput);
        this.commandMethod = commandMethod;
    }

    public void performCommand(TaskManager taskManager) {
        try {
            taskManager.addTask(this.commandMethod, super.getCommand());
        } catch (DukeException e) {
            e.printStackTrace();
        }
    }
}
