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
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(taskToBeMarkedAsDone);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        String nextCommand = sc.nextLine();

        while (!nextCommand.equals("bye")) {
            if (nextCommand.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                printTaskList();
            } else if (nextCommand.substring(0,4).equals("done")) {
                markTaskAsDone(nextCommand);
            } else {
                Task nextTask = new Task(nextCommand);
                System.out.println("added: " + nextTask.getText());
                listOfTasks[indexOfLatestTask++] = nextTask;
            }
            nextCommand = sc.nextLine();
        }
        System.out.println("Bye. Hope to see you again!");
    }
}
