package duke.task;

/**
 * A child class of Task that represents a Todo task.
 */
public class Todo extends Task {
    /**
     * Constructor for a Todo.
     * @param text String that represents a line input.
     */
    public Todo(String text) {
        super(text);
    }

    /**
     * Constructor of a Todo.
     * @param text String that represents a line input.
     * @param isDone that represents if a Todo object is done or not.
     */
    public Todo(String text, boolean isDone) {
        super(text, isDone);
    }

    /**
     * Method to format a Todo to be added into a txt file.
     * @return String that is formatted.
     */
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

    /**
     * toString method
     * @return required representation of a Todo object in a String.
     */
    @Override
    public String toString() {
        if (super.getIsDone()) {
            return "[T][Y] " + super.getText();
        } else {
            return "[T][N] " + super.getText();
        }
    }
}
