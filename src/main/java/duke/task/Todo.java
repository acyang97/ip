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
        String done;
        if (super.isDone) {
            done = "1";
        } else {
            done = "0";
        }
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
