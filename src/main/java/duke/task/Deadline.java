package duke.task;

public class Deadline extends Task {
    private String deadline;

    public Deadline(String text, String deadline) {
        super(text);
        this.deadline = deadline;
    }

    public String formatDeadLine() {
        String firstWord = deadline.split(" ")[0];
        return "(" + firstWord + ":" + deadline.substring(firstWord.length()) + ")";
    }

    public String toString() {
        if (super.getIsDone()) {
            return "[D][Y]" + super.getText() + " " + this.formatDeadLine();
        } else {
            return "[D][N]" + super.getText() + " " + this.formatDeadLine();
        }
    }
}
