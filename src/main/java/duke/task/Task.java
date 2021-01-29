package duke.task;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor for the Task
     * @param description describe the task to be done
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String getTaskDescription() {
        return description;
    }

    public void markAsDone() {
        isDone = !isDone;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "]" + "" + getTaskDescription();
    }
}
