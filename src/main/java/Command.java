public class Command {
    private String text;
    private boolean isDone;

    public Command(String text) {
        this.text = text;
        this.isDone = false;
    }

    public void setDone() {
        this.isDone = true;
    }

    public String getText() {
        return this.text;
    }

    public boolean getIsDone() {
        return this.isDone;
    }

    public boolean equals(String otherText) {
        return this.text.equals(otherText);
    }

    @Override
    public String toString() {
        return this.text;
    }
}
