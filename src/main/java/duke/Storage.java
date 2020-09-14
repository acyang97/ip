package duke;

import duke.task.Task;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.io.FileWriter;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void emptyFile() throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.close();
    }

    public void addTask(Task task) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        String line = task.formatLine();
        fileWriter.write(line);
        fileWriter.close();
    }

    public void addTasks(TaskManager taskManager) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        List<Task> listOfTasks = taskManager.getListOfTasks();
        for (int i = 0; i < listOfTasks.size(); i++) {
            String line = listOfTasks.get(i).formatLine();
            fileWriter.write(line);
        }
        fileWriter.close();
    }

    public void listTasks() {
        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            System.out.println("Here are your list of tasks:");
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
}
