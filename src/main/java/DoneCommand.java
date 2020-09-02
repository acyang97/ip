public class DoneCommand extends Command {
    private int indexOfTaskToBeMarkedAsDone;

    public DoneCommand(String lineInput, int indexOfTaskToBeMarkedAsDone) {
        super(lineInput);
        this.indexOfTaskToBeMarkedAsDone = indexOfTaskToBeMarkedAsDone;
    }

    public void performTask(TaskManager taskManager) {
        taskManager.markTaskAsDone(indexOfTaskToBeMarkedAsDone);
    }

}
