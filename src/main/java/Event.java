public class Event extends Task {
    private String event;

    public Event(String text, String event) {
        super(text);
        this.event = event;
    }

    public String formatEvent() {
        String firstWord = event.split(" ")[0];
        return "(" + firstWord + ":" + event.substring(firstWord.length()) + ")";
    }

    public String toString() {
        if (super.getIsDone()) {
            return "[D][Y] " + super.getText() + " " + this.formatEvent();
        } else {
            return "[D][N] " + super.getText() + " " + this.formatEvent();
        }
    }

}
