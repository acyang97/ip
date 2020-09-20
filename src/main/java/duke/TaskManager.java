package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * A TaskManager to manage the list of Tasks in the app.
 * This is the TaskList class that is required for the project.
 */
public class TaskManager {
    /**
     * listOfTasks list that stores the tasks in a list.
     */
    private ArrayList<Task> listOfTasks;
    /**
     * boolean that indicates whether a user wants to exit the app.
     */
    private boolean taskManagerSaidBye;

    /**
     * Constructor for a TaskManager to create a TaskManager object.
     */
    public TaskManager() {
        this.listOfTasks = new ArrayList<>();
        this.taskManagerSaidBye = false;
    }

    /**
     * Setter method.
     */
    public void setTaskManagerSaidBye() {
        this.taskManagerSaidBye = true;
    }

    /**
     * Getter method.
     * @return true if taskManagerSaidBye is true.
     */
    public boolean getTaskManagerSaidBye() {
        return this.taskManagerSaidBye;
    }

    /**
     * Getter method to get size of list.
     * @return size of list.
     */
    public int getSizeOfList() {
        return this.listOfTasks.size();
    }

    /**
     * Method to print all the tasks in the list.
     */
    public void printAllTasks() {
        if (this.listOfTasks.size() == 0) {
            Ui.printNoTaskInList();
        } else {
            Ui.printTaskListHeader();
            for (int i = 0; i < this.getSizeOfList(); i++) {
                System.out.println((i + 1) + "." + this.listOfTasks.get(i));
            }
        }
    }

    /**
     * Method to get the list of tasks.
     * @return the list of tasks.
     */
    public ArrayList<Task> getListOfTasks() {
        return this.listOfTasks;
    }

    /**
     * helper method to split a task when there is date involved
     * @param commandMethod
     * @param nextCommand
     * @return a string array with the splitted task.
     */
    private String[] splitTask(String commandMethod, String nextCommand) {
        nextCommand = nextCommand.substring(commandMethod.length() + 1);
        return nextCommand.split(" /");
    }

    /**
     * Method to help add a task
     * @param commandMethod the first word of the line input.
     * @param nextCommand the whole line input.
     * @param storage storage to store the lines in a txt file.
     * @throws DukeException when an there is an empty description.
     * @throws IOException when there is an error handling the file.
     */
    public void addTask(String commandMethod, String nextCommand, Storage storage) throws DukeException, IOException {
        if (commandMethod.length() == nextCommand.length()) {
            throw new DukeException(Ui.printEmptyDescriptionReply(commandMethod));
        }
        Ui.printAddTaskStartingReply();
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
        Ui.printShowTaskListSize(this.getSizeOfList());
    }

    /**
     * Method to mark a task as done
     * @param indexOfTask index of task to be marked as done
     * @param storage storage to store the lines in a txt file.
     * @throws DukeException when index is greater than size of list.
     * @throws IOException when there is an error handling the file.
     */
    public void markTaskAsDone(int indexOfTask, Storage storage) throws DukeException, IOException {
        if (indexOfTask > this.getSizeOfList()) {
            throw new DukeException(Ui.printTaskListSizeSmallerThanIndex(indexOfTask));
        } else {
            Task taskToBeMarkedAsDone = this.listOfTasks.get(indexOfTask - 1);
            taskToBeMarkedAsDone.setDone();
            this.listOfTasks.set(indexOfTask - 1, taskToBeMarkedAsDone);
            Ui.printMarkedTaskDone();
            storage.addTasks(this);
            System.out.println(taskToBeMarkedAsDone);
        }
    }

    /**
     *
     * @param indexOfTask index of task in the list to be deleted.
     * @param storage storage to store the lines in a txt file.
     * @throws DukeException when index is greater than size of list.
     * @throws IOException when there is an error handling the file.
     */
    public void deleteTask(int indexOfTask, Storage storage) throws DukeException, IOException {
        if (indexOfTask > this.getSizeOfList()) {
            throw new DukeException(Ui.printTaskListSizeSmallerThanIndex(indexOfTask));
        } else {
            Ui.printRemovedTask();
            System.out.println(this.listOfTasks.get(indexOfTask - 1));
            this.listOfTasks.remove(indexOfTask - 1);
            storage.emptyFile();
            storage.addTasks(this);
            Ui.printShowTaskListSize(this.getSizeOfList());
        }
    }

    /**
     * Helper method to convert a line to a Task object when
     * we are reading lines from a txt file.
     * @param line line to be read.
     * @return a Task Object.
     */
    private Task convertLineInTaskListToTask(String line) {
        String[] components = line.split("\\|");
        for (int i = 0; i < components.length; i++) {
            components[i] = components[i].trim();
        }
        boolean isDone = components[1].equals("1");
        if (components[0].equals("T")) {
            return new Todo(components[2], isDone);
        } else if (components[0].equals("D")) {
            return new Deadline(components[2], isDone, components[3]);
        } else {
            return new Event(components[2], isDone, components[3]);
        }
    }

    /**
     * Helper method to add tasks to a taskList of the TaskManager
     * when reading lines from a txt file.
     * @param task task to be added
     */
    private void addTask(Task task) {
        this.listOfTasks.add(task);
    }

    /**
     * Method to add tasks from a File object to the listOfTasks.
     * @param file File to be read that contains lines to be parsed into a Task.
     */
    public void addTasksToTaskManagerFromFile(File file) {
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Task task = convertLineInTaskListToTask(line);
                this.addTask(task);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            Ui.printFileNotFound();
        } catch (NoSuchElementException e) {
            Ui.printNoTaskInList();
        }
    }

    /**
     * Method to find Tasks that contains a keyword specified by the use.
     * @param keyWord specified by the user.
     * @param storage storage to store the lines in a txt file.
     */
    public void findTasks(String keyWord, Storage storage) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : this.listOfTasks) {
            if (task.getWords().contains(keyWord)) {
                matchingTasks.add(task);
            }
        }
        if (matchingTasks.size() == 0) {
            Ui.printNoMatchingTasks();
        } else {
            Ui.printShowMatchingTasksHeader();
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println((i + 1) + "." + matchingTasks.get(i));
            }
        }
     }
}

