package duke;

import duke.command.Command;

import java.io.File;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String filePath = "taskList.txt";
        File file = new File(filePath);
        Scanner sc = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        Storage storage = new Storage(filePath);
        Ui ui = new Ui();
        ui.printGreeting();

        if (file.exists()) {
            storage.listTasks();
            taskManager.addTasksToTaskManagerFromFile(file);
            ui.printLineSeparator();
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
            ui.printLineSeparator();
        }
    }
}