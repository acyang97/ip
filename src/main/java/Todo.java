public class Todo extends Task {
    public Todo(String text) {
        super(text);
    }

    @Override
    public String toString() {
        if (super.getIsDone()) {
            return super.getIndexOfTask() + ".[T][Y] " + super.getText();
        } else {
            return super.getIndexOfTask() + ".[T][N] " + super.getText();
        }
    }
}
