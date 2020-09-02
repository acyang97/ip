public abstract class Command {
    protected String command;

    public Command(String command) {
        this.command = command;
    }

    protected String getCommand() {
        return command;
    }

    protected abstract void performTask(TaskManager taskManager);
}
