package duke.task;

public class Todo extends Task {
    public Todo(String text) {
        super(text);
    }

    public Todo(String text, boolean isDone) {
        super(text, isDone);
    }

    @Override
    public String formatLine() {
        String done = (super.isDone) ? "1" : "0";
        return "\nT | " + done + " | " + this.text;
    }

    @Override
    public String toString() {
        if (super.getIsDone()) {
            return "[T][Y] " + super.getText();
        } else {
            return "[T][N] " + super.getText();
        }
    }
}
