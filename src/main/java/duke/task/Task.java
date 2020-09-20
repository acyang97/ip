package duke.task;

import java.util.ArrayList;

/**
 * A superclass that represents a Task.
 */
public class Task {
    /**
     * text String that represents the line input of the user.
     */
    protected String text;
    /**
     * isDone boolean that represents if a task is done or not.
     */
    protected boolean isDone;

    /**
     * Constructor for a Task Object.
     * @param text String that represents a line input.
     */
    public Task(String text) {
        this.text = text;
        this.isDone = false;
    }

    /**
     * Constructor for a Task Object.
     * @param text String that represents a line input.
     * @param isDone that represents if a task is done or not.
     */
    public Task(String text, boolean isDone) {
        this.text = text;
        this.isDone = isDone;
    }

    /**
     * Method to obtain a list of words in the text that is split up.
     * @return the list of splitted words.
     */
    public ArrayList<String> getWords() {
        ArrayList<String> wordList = new ArrayList<>();
        String[] wordArray = this.text.split(" ");
        for (int i = 0; i < wordArray.length; i++) {
            wordList.add(wordArray[i]);
        }
        return wordList;
    }

    /**
     * Setter method to set a task to be done.
     */
    public void setDone() {
        this.isDone = true;
    }

    /**
     * Getter method that gets the text in the Task Object.
     * @return the text.
     */
    public String getText() {
        return this.text;
    }

    /**
     * Getter method that gets the isDone.
     * @return true if task isDone.
     */
    protected boolean getIsDone() {
        return this.isDone;
    }

    /**
     * Dummy method just to be overridden by the child classes.
     * This method will never be executed in the superclass.
     * @return an empty string.
     */
    public String formatLine() {
        return  "";
    }
}
