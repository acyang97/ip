package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public List<Task> getListOfTasks() {
        return this.listOfTasks;
    }

    private String[] splitTask(String commandMethod, String nextCommand) {
        nextCommand = nextCommand.substring(commandMethod.length() + 1);
        String[] splitTaskIntoTextAndDate = nextCommand.split(" /");
        return splitTaskIntoTextAndDate;
    }

    public void addTask(String commandMethod, String nextCommand, Storage storage) throws DukeException, IOException {
        if (commandMethod.length() == nextCommand.length()) {
            throw new DukeException("OOPS!!! The description of a " + commandMethod + " cannot be empty.");
        }
        System.out.println("Got it. I've added this task:");
        Task taskToBeAdded;
        if (commandMethod.equals("todo")) {
            taskToBeAdded = new Todo(nextCommand.substring(commandMethod.length() + 1));
        } else if (commandMethod.equals("deadline")) {
            String[] splitTask = splitTask(commandMethod, nextCommand);
            taskToBeAdded = new Deadline(splitTask[0], splitTask[1]);
        } else {
            String[] splitTask = splitTask(commandMethod, nextCommand);
            taskToBeAdded = new Event(splitTask[0], splitTask[1]);
        }
        System.out.println(taskToBeAdded);
        this.listOfTasks.add(taskToBeAdded);
        storage.addTasks(this);
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

    private Task convertLineInTaskListToTask(String line) {
        String[] components = line.split("\\|");
        for (int i = 0; i < components.length; i++) {
            components[i] = components[i].trim();
        }
        boolean isDone = components[1].equals("1") ? true : false;
        if (components[0].equals("T")) {
            return new Todo(components[2], isDone);
        } else if (components[0].equals("D")) {
            return new Deadline(components[2], isDone, components[3]);
        } else {
            return new Event(components[2], isDone, components[3]);
        }
    }

    public void addTask(Task task) {
        this.listOfTasks.add(task);
    }

    public void addTasksToTaskManagerFromFile(File file) {
        try {
            //File file = new File(filePath);
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Task task = convertLineInTaskListToTask(line);
                this.addTask(task);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            e.printStackTrace();
        }
    }
}
