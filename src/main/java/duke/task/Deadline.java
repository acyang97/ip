package duke.task;

/**
 * A child class of Task that represents a Deadline task.
 */
public class Deadline extends Task {
    /**
     * deadline String, which is the line after '/' in the given input.
     */
    private String deadline;

    /**
     * Constructor for a Deadline.
     * @param text String that represents everything before the '/' in the line input.
     * @param deadline String that represents everything after the '/' in the line input.
     */
    public Deadline(String text, String deadline) {
        super(text);
        this.deadline = deadline;
    }

    /**
     * Constructor for a Deadline.
     * @param text String that represents everything before the '/' in the line input.
     * @param isDone that represents if a Event object is done or not.
     * @param deadline String that represents everything after the '/' in the line input.
     */
    public Deadline(String text, boolean isDone, String deadline) {
        super(text, isDone);
        this.deadline = deadline;
    }

    /**
     * Method to format a Deadline to be added into a txt file.
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
        return "\nD | " + done + " | " + super.text + " | " + this.deadline;
    }

    /**
     * Helper method to format output.
     * @return a formatted string.
     */
    public String formatDeadLine() {
        String firstWord = deadline.split(" ")[0];
        return "(" + firstWord + ":" + deadline.substring(firstWord.length()) + ")";
    }

    /**
     * toString method
     * @return required representation of a Deadline object in a String.
     */
    public String toString() {
        if (super.getIsDone()) {
            return "[D][Y] " + super.getText() + " " + this.formatDeadLine();
        } else {
            return "[D][N] " + super.getText() + " " + this.formatDeadLine();
        }
    }
}