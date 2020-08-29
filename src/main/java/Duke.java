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

    public static void addTask(String commandMethod, String nextCommand) {
        System.out.println("Got it. I've added this task:");
        // there are three possible command methods,
        // todo
        if (commandMethod.equals("todo")) {
            Todo todo = new Todo(nextCommand.substring(4, nextCommand.length()));

        }
        // deadline
        // event
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
            } else { // now there are 3 seperate classes
                Task nextTask = new Task(nextCommand);
                System.out.println("added: " + nextTask.getText());
                listOfTasks[indexOfLatestTask++] = nextTask;
            }
            nextCommand = sc.nextLine();
            commandMethod = nextCommand.split(" ")[0];
        }
        System.out.println("Bye. Hope to see you again!");
    }
}
