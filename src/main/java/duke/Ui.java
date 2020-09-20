package duke;

/**
 * A Ui class to deal with interactions with the user.
 */
public class Ui {
    /**
     * Constructor that creates a Ui Object
     */
    public Ui() {
    }

    /**
     * Prints greeting message that displays whenever user starts the app.
     */
    public void printGreeting() {
        System.out.println("Hello! I'm duke.Duke");
        System.out.println("What can I do for you?");
        System.out.println();
    }

    /**
     * Prints a line separator to produce neater and clearer outputs for the user.
     */
    public void printLineSeparator() {
        System.out.println();
    }

    /**
     * Prints header when user wants to views tasks in the list.
     */
    public static void viewTasks() {
        System.out.println("Here are your list of tasks:");
    }

    /**
     * Prints error when file does not exist.
     */
    public static void printFileNotFound() {
        System.out.println("File does not exist!");
    }

    /**
     * Prints statement when user's task list is empty.
     */
    public static void printNoTaskInList() {
        System.out.println("You don't have any tasks in your list");
    }

    /**
     * Prints header when there are tasks in the list and user wants to view them.
     */
    public static void printTaskListHeader() {
        System.out.println("Here are the tasks in your list:");
    }

    /**
     * Returns a String needed for the DukeException input.
     * Required when a description of a command is empty.
     * @param commandMethod
     * @return a string for the input of the DukeException.
     */
    public static String printEmptyDescriptionReply(String commandMethod) {
        return "OOPS!!! The description of a " + commandMethod + " cannot be empty.";
    }

    /**
     * Printed when a task is successfully added to a list.
     */
    public static void printAddTaskStartingReply() {
        System.out.println("Got it. I've added this task:");
    }

    /**
     * Printed after task is successfully added and shows user the size of his task list.
     * @param taskListSize
     */
    public static void printShowTaskListSize(int taskListSize) {
        System.out.println(String.format("Now you have %d tasks in the list.", taskListSize));
    }

    /**
     * Returns a String for the input of a DukeException error.
     * Required when index of task input by the user is greater than the size of his task list.
     * @param indexOfTask
     * @return a String.
     */
    public static String printTaskListSizeSmallerThanIndex(int indexOfTask) {
        return "Total number of tasks is less than " + indexOfTask;
    }

    /**
     * Printed when a task is successfully deleted from the task list.
     */
    public static void printRemovedTask() {
        System.out.println("Noted. I've removed this task:");
    }

    /**
     * Printed when a task is successfully marked as done in the task list.
     */
    public static void printMarkedTaskDone() {
        System.out.println("Nice! I've marked this task as done:");
    }

    /**
     * Printed when there are no matching tasks when user is finding a task that matches keyword.
     */
    public static void printNoMatchingTasks() {
        System.out.println("There are no matching tasks!");
    }

    /**
     * Printed before showing the list of task that matches keyword using the findTasks method.
     */
    public static void printShowMatchingTasksHeader() {
        System.out.println("Here are the matching tasks in your list:");
    }
}