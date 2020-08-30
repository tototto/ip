package duke.task;

public class Event extends Task{

    public Event(String description, String at, String timePeriod) {
        super(description);
        this.at = at;
        this.timePeriod = timePeriod;
    }

    protected String at;
    protected String timePeriod;

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + at + " " + timePeriod +")";
    }
}
