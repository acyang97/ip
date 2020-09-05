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

            while (!taskManager.getTaskManagerSaysBye()) {
                command.performCommand(taskManager);
                nextLine = sc.nextLine();
                lineParser = new LineParser(nextLine);
                command = lineParser.getTypeOfCommand();
            }
            command.performCommand(taskManager);
        } catch (DukeException e) {
            System.out.println(e);
        }
    }
}