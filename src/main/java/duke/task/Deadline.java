package duke.task;

public class Deadline extends Task {
    protected String by;
    protected String time;

    /**
     * constructor for the deadline
     * @param description describe the deadline task
     * @param by when it must be completed
     * @param time time it must be completed
     */
    public Deadline(String description, String by, String time) {
        super(description);
        this.by = by;
        this.time = time;
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + "(by: " + by + " " + time + ")";
    }
}
