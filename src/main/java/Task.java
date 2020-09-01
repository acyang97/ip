public class Task {
    protected int indexOfTask;
    protected String text;
    protected boolean isDone;
    protected static int TASK_COUNTER = 1;

    public Task(String text) {
        this.indexOfTask = TASK_COUNTER;
        this.text = text;
        this.isDone = false;
        TASK_COUNTER++;
    }

    protected void setDone() {
        this.isDone = true;
    }

    protected String getText() {
        return this.text;
    }

    protected boolean getIsDone() {
        return this.isDone;
    }
}
