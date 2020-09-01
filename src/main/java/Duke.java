import javax.sound.sampled.Line;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        System.out.println("Hello! I'm Duke");
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
        sc.close();
    }
}