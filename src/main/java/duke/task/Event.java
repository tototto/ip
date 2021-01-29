package duke.task;

public class Event extends Task {
    protected String at;
    protected String timePeriod;
    /**
     * Constructor for the Event task
     * @param description describe the event task
     * @param at which date the event takes place
     * @param timePeriod the start till end time of the event
     */
    public Event(String description, String at, String timePeriod) {
        super(description);
        this.at = at;
        this.timePeriod = timePeriod;
    }
    @Override
    public String toString() {
        return "[E] " + super.toString() + "(at: " + at + " " + timePeriod + ")";
    }
}

