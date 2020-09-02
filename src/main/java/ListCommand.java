public class ListCommand extends Command{
    public ListCommand(String lineInput) {
        super(lineInput);
    }

    public void performTask(TaskManager taskManager) {
        taskManager.printAllTasks();
    }
}
