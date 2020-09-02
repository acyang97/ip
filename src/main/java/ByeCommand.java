public class ByeCommand extends Command {
    public ByeCommand(String lineInput) {
        super(lineInput);
    }

    public void performCommand(TaskManager taskManager) {
        taskManager.setTaskManagerSaysBye();
        System.out.println("Bye. Hope to see you again!");
    }

}
