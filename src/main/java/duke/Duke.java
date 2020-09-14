package duke;

import duke.command.Command;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) throws IOException {
        String filePath = "taskList.txt";
        File file = new File(filePath);

        Scanner sc = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        Storage storage = new Storage(filePath);
        System.out.println("Hello! I'm duke.Duke");
        System.out.println("What can I do for you?");

        if (file.exists()) {
            System.out.println("Here are your list of tasks:");
            storage.listTasks();
            taskManager.addTasksToTaskManagerFromFile(file);
        }

        while (true) {
            try {
                String nextLine = sc.nextLine();
                LineParser lineParser = new LineParser(nextLine);
                Command command = lineParser.getTypeOfCommand();
                command.performCommand(taskManager, storage);
            } catch (DukeException e) {
                System.out.println(e);
            }
            if (taskManager.getTaskManagerSaidBye()) {
                break;
            }
        }
    }
}
