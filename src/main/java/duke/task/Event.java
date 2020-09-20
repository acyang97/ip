package duke.task;

public class Event extends Task {
    private String event;

    public Event(String text, String event) {
        super(text);
        this.event = event;
    }

    public Event(String text, boolean isDone, String event) {
        super(text, isDone);
        this.event = event;
    }

    public String formatLine() {
        String done;
        if (super.isDone) {
            done = "1";
        } else {
            done = "0";
        }
        return "\nE | " + done + " | " + super.text + " | " + this.event;
    }

    public String formatEvent() {
        String firstWord = event.split(" ")[0];
        return "(" + firstWord + ":" + event.substring(firstWord.length()) + ")";
    }

    public String toString() {
        if (super.getIsDone()) {
            return "[E][Y] " + super.getText() + " " + this.formatEvent();
        } else {
            return "[E][N] " + super.getText() + " " + this.formatEvent();
        }
    }
}