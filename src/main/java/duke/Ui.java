package duke;

public class Ui {
    public Ui() {
    }

    public void printGreeting() {
        System.out.println("Hello! I'm duke.Duke");
        System.out.println("What can I do for you?");
        System.out.println();
    }

    public void printLineSeparator() {
        System.out.println();
    }

    public static void viewTasks() {
        System.out.println("Here are your list of tasks:");
    }

    public static void printFileNotFound() {
        System.out.println("File does not exist!");
    }

    public static void printNoTaskInList() {
        System.out.println("You don't have any tasks in your list");
    }

    public static void printTaskListHeader() {
        System.out.println("Here are the tasks in your list:");
    }

    public static String printEmptyDescriptionReply(String commandMethod) {
        return "OOPS!!! The description of a " + commandMethod + " cannot be empty.";
    }

    public static void printAddTaskStartingReply() {
        System.out.println("Got it. I've added this task:");
    }

    public static void printShowTaskListSize(int taskListSize) {
        System.out.println(String.format("Now you have %d tasks in the list.", taskListSize));
    }

    public static void printAddTaskEndReply(int sizeOfList) {
        System.out.println(String.format("Now you have %d tasks in the list.", sizeOfList));
    }

    public static String printTaskListSizeSmallerThanIndex(int indexOfTask) {
        return "Total number of tasks is less than " + indexOfTask;
    }

    public static void printRemovedTask() {
        System.out.println("Noted. I've removed this task:");
    }

    public static void printMarkedTaskDone() {
        System.out.println("Nice! I've marked this task as done:");
    }
}
