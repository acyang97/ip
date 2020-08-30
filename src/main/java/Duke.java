import java.util.Scanner;

public class Duke {
    private static Task[] listOfTasks = new Task[100];
    private static int indexOfLatestTask = 0;

    public static void printTaskList() {
        for (int i = 0; i < indexOfLatestTask; i++) {
            System.out.println(Integer.toString(i + 1) + "." + listOfTasks[i]);
        }
    }

    public static void markTaskAsDone(String nextCommand) {
        String index = nextCommand.split(" ")[1];
        int indexOfTask = Integer.parseInt(index);
        Task taskToBeMarkedAsDone = listOfTasks[indexOfTask - 1];
        taskToBeMarkedAsDone.setDone();
        listOfTasks[indexOfTask - 1] = taskToBeMarkedAsDone;
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(taskToBeMarkedAsDone);
    }

    public static String[] splitTask(String commandMethod, String nextCommand) {
        nextCommand = nextCommand.substring(commandMethod.length());
        String[] splitTaskIntoTextAndDate = nextCommand.split(" /");
        return splitTaskIntoTextAndDate;
    }

    public static void addTask(String commandMethod, String nextCommand) {
        System.out.println("Got it. I've added this task:");
        Task taskToBeAdded = null;
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
        listOfTasks[indexOfLatestTask++] = taskToBeAdded;
        System.out.println(String.format("Now you have %d tasks in the list.", indexOfLatestTask));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        String nextCommand = sc.nextLine();
        String commandMethod = nextCommand.split(" ")[0];
        while (!commandMethod.equals("bye")) {
            if (commandMethod.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                printTaskList();
            } else if (commandMethod.equals("done")) {
                markTaskAsDone(nextCommand);
            } else {
                addTask(commandMethod, nextCommand);
            }
            nextCommand = sc.nextLine();
            commandMethod = nextCommand.split(" ")[0];
        }
        System.out.println("Bye. Hope to see you again!");
    }
}
