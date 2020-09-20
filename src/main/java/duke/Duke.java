package duke;

import duke.command.Command;

import java.io.File;
import java.util.Scanner;

/**
 * A Duke class that contains the main method to run the program.
 */
public class Duke {
    /**
     * Main method to run the Duke program.
     * @param args the inputs of the user.
     */
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