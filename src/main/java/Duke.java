import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        String nextCommand = sc.next();
        while (!nextCommand.equals("bye")) {
            System.out.println(nextCommand);
            nextCommand = sc.next();
        }
        System.out.println("Bye. Hope to see you again!");
    }
}
