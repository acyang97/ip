package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> listOfTasks;
    private boolean taskManagerSaidBye;

    public TaskManager() {
        this.listOfTasks = new ArrayList<>();
        this.taskManagerSaidBye = false;
    }

    public void setTaskManagerSaidBye() {
        this.taskManagerSaidBye = true;
    }

    public boolean getTaskManagerSaidBye() {
        return this.taskManagerSaidBye;
    }

    public int getSizeOfList() {
        return this.listOfTasks.size();
    }

    public void printAllTasks() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < this.getSizeOfList(); i++) {
            System.out.println((i + 1) + "." + this.listOfTasks.get(i));
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
        this.listOfTasks.add(taskToBeAdded);
        System.out.println(String.format("Now you have %d tasks in the list.", this.getSizeOfList()));
    }

    public void markTaskAsDone(int indexOfTask) throws DukeException {
        if (indexOfTask > this.getSizeOfList()) {
            throw new DukeException("Total number of tasks is less than " + indexOfTask);
        } else {
            Task taskToBeMarkedAsDone = this.listOfTasks.get(indexOfTask - 1);
            taskToBeMarkedAsDone.setDone();
            this.listOfTasks.set(indexOfTask - 1, taskToBeMarkedAsDone);
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(taskToBeMarkedAsDone);
        }
    }

    public void deleteTask(int indexOfTask) throws DukeException {
        if (indexOfTask > this.getSizeOfList()) {
            throw new DukeException("Total number of tasks is less than " + indexOfTask);
        } else {
            System.out.println("Noted. I've removed this task:");
            System.out.println(this.listOfTasks.get(indexOfTask - 1));
            this.listOfTasks.remove(indexOfTask - 1);
            System.out.println(String.format("Now you have %d tasks in the list.", this.getSizeOfList()));
        }
    }
}
