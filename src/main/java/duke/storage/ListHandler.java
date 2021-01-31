package duke.storage;

import java.util.Vector;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

public class ListHandler {

    private Vector ListStorage = new Vector();

    public void addToDo(String body) {
        ListStorage.add(new Todo(body));
    }

    public void addDeadline(String body, String by, String time) {
        ListStorage.add(new Deadline(body, by, time));
    }

    public void addEvent(String body, String at, String timePeriod) {
        ListStorage.add(new Event(body, at, timePeriod));
    }

    public Vector getList() {
        return ListStorage;
    }

    /**
     * Update the task in list by index
     * @param index the identifier for the task
     * @return return updated task if sucessful NULL otherwise
     */
    public Task updateListItem(String index) {
        try {
            int idx = Integer.parseInt(index.trim());
            Task task = (Task) ListStorage.get(idx - 1);
            task.markAsDone();
            return task;
        } catch (NumberFormatException e) {
            // Do nothing
        } catch (ArrayIndexOutOfBoundsException e) {
            // Do nothing
        }

        return null;
    }

    /**
     * Delete a task based on index from task list
     * @param index the identifier for the task
     * @return
     */
    public Task deleteListItem(String index) {
        try {
            int idx = Integer.parseInt(index.trim());
            Task task = (Task) ListStorage.remove(idx - 1);
            return task;

        } catch (Exception e) {
            // Do nothing
        }

        return null;
    }
}
