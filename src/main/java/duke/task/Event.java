package duke.task;

/**
 * A child class of Task that represents a Event task.
 */
public class Event extends Task {
    /**
     * event String, which is the line after '/' in the given input.
     */
    private String event;

    /**
     * Constructor for a Event.
     * @param text String that represents everything before the '/' in the line input.
     * @param event String that represents everything after the '/' in the line input.
     */
    public Event(String text, String event) {
        super(text);
        this.event = event;
    }

    /**
     * Constructor for a Event.
     * @param text String that represents everything before the '/' in the line input.
     * @param isDone that represents if a Event object is done or not.
     * @param event String that represents everything after the '/' in the line input.
     */
    public Event(String text, boolean isDone, String event) {
        super(text, isDone);
        this.event = event;
    }

    /**
     * Method to format a Event to be added into a txt file.
     * @return String that is formatted.
     */
    public String formatLine() {
        String done;
        if (super.isDone) {
            done = "1";
        } else {
            done = "0";
        }
        return "\nE | " + done + " | " + super.text + " | " + this.event;
    }

    /**
     * Helper method to format output.
     * @return a formatted string.
     */
    private String formatEvent() {
        String firstWord = event.split(" ")[0];
        return "(" + firstWord + ":" + event.substring(firstWord.length()) + ")";
    }

    /**
     * toString method
     * @return required representation of a Event object in a String.
     */
    public String toString() {
        if (super.getIsDone()) {
            return "[E][Y] " + super.getText() + " " + this.formatEvent();
        } else {
            return "[E][N] " + super.getText() + " " + this.formatEvent();
        }
    }
}