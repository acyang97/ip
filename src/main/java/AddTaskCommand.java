public class AddTaskCommand extends Command {
    private String commandMethod;

    public AddTaskCommand(String lineInput, String commandMethod) {
        super(lineInput);
        this.commandMethod = commandMethod;
    }

    public void performTask(TaskManager taskManager) {
        taskManager.addTask(this.commandMethod, super.getCommand());
    }
}
