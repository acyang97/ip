import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        String[] listOfCommands = new String[100];
        int indexOfCommand = 0;
        String nextCommand = sc.nextLine();

        while (!nextCommand.equals("bye")) {
            if (!nextCommand.equals("list")) {
                System.out.println("added: " + nextCommand);
                listOfCommands[indexOfCommand++] = nextCommand;
            } else {
                for (int i = 0; i < indexOfCommand; i++) {
                    System.out.println((i+1) + ". " + listOfCommands[i]);
                }
            }
            nextCommand = sc.nextLine();
        }

        System.out.println("Bye. Hope to see you again!");
    }
}
