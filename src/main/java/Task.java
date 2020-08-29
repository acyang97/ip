public class Task {
    private int indexOfTask;
    private String text;
    private boolean isDone;
    private static int TASK_COUNTER = 1;

    public Task(String text) {
        this.indexOfTask = TASK_COUNTER;
        this.text = text;
        this.isDone = false;
        TASK_COUNTER++;
    }

    public void setDone() {
        this.isDone = true;
    }

    public int getIndexOfTask() {
        return this.indexOfTask;
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
        if (this.isDone) {
            return this.indexOfTask + ".[Y] " + this.text;
        } else {
            return this.indexOfTask + ".[N] " + this.text;
        }
    }
}
