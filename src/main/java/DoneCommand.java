public class DoneCommand extends Command {
    private int indexOfTaskToBeMarkedAsDone;

    public DoneCommand(String lineInput, int indexOfTaskToBeMarkedAsDone) {
        super(lineInput);
        this.indexOfTaskToBeMarkedAsDone = indexOfTaskToBeMarkedAsDone;
    }

    public void performCommand(TaskManager taskManager) {
        try {
            taskManager.markTaskAsDone(indexOfTaskToBeMarkedAsDone);
        } catch (DukeException e) {
            e.printStackTrace();
        }
    }

}
