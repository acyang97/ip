package duke.task;

public class Todo extends Task {
    public Todo(String text) {
        super(text);
    }

    @Override
    public String toString() {
        if (super.getIsDone()) {
            return "[T][Y]" + super.getText();
        } else {
            return "[T][N]" + super.getText();
        }
    }
}
