import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        Command[] listOfCommands = new Command[100];
        int indexOfCommand = 0;
        Command nextCommand = new Command(sc.nextLine());

        while (!nextCommand.equals("bye")) {
            if (nextCommand.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < indexOfCommand; i++) {
                    Command currentCommand = listOfCommands[i];
                    if (currentCommand.getIsDone()) {
                        System.out.println((i + 1) + ".[Y] " + currentCommand);
                    } else {
                        System.out.println((i + 1) + ".[N] " + currentCommand);
                    }
                }
            } else if (nextCommand.getText().substring(0,4).equals("done")) {
                String index = nextCommand.getText().split(" ")[1];
                int commandIndex = Integer.parseInt(index);
                Command command = listOfCommands[commandIndex - 1];
                command.setDone();
                listOfCommands[commandIndex - 1] = command;
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println("[Y] " + command);
            } else {
                System.out.println("added: " + nextCommand);
                listOfCommands[indexOfCommand++] = nextCommand;
            }
            nextCommand = new Command(sc.nextLine());
        }
        System.out.println("Bye. Hope to see you again!");
    }
}
