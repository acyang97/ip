package duke.task;

public class Task {
    protected String text;
    protected boolean isDone;

    public Task(String text) {
        this.text = text;
        this.isDone = false;
    }

    public Task(String text, boolean isDone) {
        this.text = text;
        this.isDone = isDone;
    }

    public void setDone() {
        this.isDone = true;
    }

    protected String getText() {
        return this.text;
    }

    protected boolean getIsDone() {
        return this.isDone;
    }

    public String formatLine() {
        return  "";
    }
}
