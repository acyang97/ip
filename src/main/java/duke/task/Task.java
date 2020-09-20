package duke.task;

import java.util.ArrayList;

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

    public ArrayList<String> getWords() {
        ArrayList<String> wordList = new ArrayList<>();
        String[] wordArray = this.text.split(" ");
        for (int i = 0; i < wordArray.length; i++) {
            wordList.add(wordArray[i]);
        }
        return wordList;
    }

    public void setDone() {
        this.isDone = true;
    }

    public String getText() {
        return this.text;
    }

    protected boolean getIsDone() {
        return this.isDone;
    }

    public String formatLine() {
        return  "";
    }
}
