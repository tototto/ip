import java.util.*;

public class listHandler {

    private Vector ListStorage = new Vector();

    public void addToList(String Input) {
        ListStorage.add(new Task(Input));
    }

    public Vector GetList(){
        return ListStorage;
    }

    public Task UpdateListItem(String index){
        try {
            int idx = Integer.parseInt(index);
            Task task = (Task) ListStorage.get(idx - 1);
            task.markAsDone();

            return task;

        } catch (NumberFormatException e) { } catch (ArrayIndexOutOfBoundsException e) { }

        return null;
    }
}
