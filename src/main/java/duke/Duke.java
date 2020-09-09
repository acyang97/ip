package duke;

import duke.command.Command;

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            TaskManager taskManager = new TaskManager();
            System.out.println("Hello! I'm duke.Duke");
            System.out.println("What can I do for you?");
            String nextLine = sc.nextLine();
            LineParser lineParser = new LineParser(nextLine);
            Command command = lineParser.getTypeOfCommand();

            while (true) {
                command.performCommand(taskManager);
                if (taskManager.getTaskManagerSaidBye()) {
                    break;
                }
                nextLine = sc.nextLine();
                lineParser = new LineParser(nextLine);
                command = lineParser.getTypeOfCommand();
            }
        } catch (DukeException e) {
            System.out.println(e);
        }
    }
}