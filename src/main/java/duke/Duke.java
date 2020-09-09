package duke;

import duke.command.Command;

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        System.out.println("Hello! I'm duke.Duke");
        System.out.println("What can I do for you?");

        while (true) {
            try {
                String nextLine = sc.nextLine();
                LineParser lineParser = new LineParser(nextLine);
                Command command = lineParser.getTypeOfCommand();
                command.performCommand(taskManager);
                if (taskManager.getTaskManagerSaidBye()) {
                    break;
                }
            } catch (DukeException e) {
                System.out.println(e);
            }
        }
    }
}