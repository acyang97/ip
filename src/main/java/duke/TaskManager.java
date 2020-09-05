package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

public class TaskManager {
    private Task[] listOfTasks;
    private int indexOfLatestTask;
    private boolean taskManagerSaysBye;

    public TaskManager() {
        this.listOfTasks = new Task[100];
        this.indexOfLatestTask = 0;
        this.taskManagerSaysBye = false;
    }

    public void setTaskManagerSaysBye() {
        this.taskManagerSaysBye = true;
    }

    public boolean getTaskManagerSaysBye() {
        return this.taskManagerSaysBye;
    }

    public void printAllTasks() {
        for (int i = 0; i < this.indexOfLatestTask; i++) {
            System.out.println((i + 1) + "." + this.listOfTasks[i]);
        }
    }

    private String[] splitTask(String commandMethod, String nextCommand) {
        nextCommand = nextCommand.substring(commandMethod.length());
        String[] splitTaskIntoTextAndDate = nextCommand.split(" /");
        return splitTaskIntoTextAndDate;
    }

    public void addTask(String commandMethod, String nextCommand) throws DukeException {
        if (commandMethod.length() == nextCommand.length()) {
            throw new DukeException("OOPS!!! The description of a " + commandMethod + " cannot be empty.");
        }
        System.out.println("Got it. I've added this task:");
        Task taskToBeAdded;
        if (commandMethod.equals("todo")) {
            taskToBeAdded = new Todo(nextCommand.substring(commandMethod.length()));
        } else if (commandMethod.equals("deadline")) {
            String[] splitTask = splitTask(commandMethod, nextCommand);
            taskToBeAdded = new Deadline(splitTask[0], splitTask[1]);
        } else {
            String[] splitTask = splitTask(commandMethod, nextCommand);
            taskToBeAdded = new Event(splitTask[0], splitTask[1]);
        }
        System.out.println(taskToBeAdded);
        this.listOfTasks[indexOfLatestTask++] = taskToBeAdded;
        System.out.println(String.format("Now you have %d tasks in the list.", indexOfLatestTask));
    }

    public void markTaskAsDone(int indexOfTask) throws DukeException {
        if (indexOfTask > indexOfLatestTask) {
            throw new DukeException("Total number of task is less than " + indexOfTask);
        }
        Task taskToBeMarkedAsDone = this.listOfTasks[indexOfTask - 1];
        taskToBeMarkedAsDone.setDone();
        this.listOfTasks[indexOfTask - 1] = taskToBeMarkedAsDone;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(taskToBeMarkedAsDone);
    }
}
