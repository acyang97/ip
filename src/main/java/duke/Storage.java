package duke;

import duke.task.Task;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.io.FileWriter;

/**
 * A Storage object to deal with saving the tasks into a file.
 */
public class Storage {
    private String filePath;

    /**
     * A constructor for the Storage object.
     * @param filePath name of the filePath.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Method to empty a txt file.
     * @throws IOException when filePath is invalid.
     */
    public void emptyFile() throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.close();
    }

    /**
     * Method to add tasks from the list in the TaskManager object to the file.
     * @param taskManager that contains the list of tasks.
     * @throws IOException when the file path does not exist.
     */
    public void addTasks(TaskManager taskManager) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        List<Task> listOfTasks = taskManager.getListOfTasks();
        for (int i = 0; i < listOfTasks.size(); i++) {
            String line = listOfTasks.get(i).formatLine();
            fileWriter.write(line);
        }
        fileWriter.close();
    }

    /**
     * method to list the tasks in the file.
     */
    public void listTasks() {
        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            Ui.viewTasks();
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            Ui.printFileNotFound();
        }
    }
}