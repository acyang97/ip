package duke.task;

public class Deadline extends Task {
    private String deadline;

    public Deadline(String text, String deadline) {
        super(text);
        this.deadline = deadline;
    }

    public Deadline(String text, boolean isDone, String deadline) {
        super(text, isDone);
        this.deadline = deadline;
    }

    @Override
    public String formatLine() {
        String done;
        if (super.isDone) {
            done = "1";
        } else {
            done = "0";
        }
        return "\nD | " + done + " | " + super.text + " | " + this.deadline;
    }

    public String formatDeadLine() {
        String firstWord = deadline.split(" ")[0];
        return "(" + firstWord + ":" + deadline.substring(firstWord.length()) + ")";
    }

    public String toString() {
        if (super.getIsDone()) {
            return "[D][Y] " + super.getText() + " " + this.formatDeadLine();
        } else {
            return "[D][N] " + super.getText() + " " + this.formatDeadLine();
        }
    }
}