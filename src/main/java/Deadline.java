import java.util.Date;

public class Deadline extends Task {

    public Deadline(String description, String by, String time) {
        super(description);
        this.by = by;
        this.time = time;
    }

    protected String by;
    protected String time;

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + by + " " + time +")";
    }
}