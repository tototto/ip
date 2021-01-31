package listHandler;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Vector;

import org.junit.jupiter.api.Test;

import duke.storage.ListHandler;

public class ListHandlerTest {

    @Test
    public void testAddTodo() {
        ListHandler listHandler = new ListHandler();
        listHandler.addToDo("Read Book");

        Vector result = listHandler.getList();
        assertEquals(result.size(), 1);
    }

    @Test
    public void testAddDeadline() {
        ListHandler listHandler = new ListHandler();
        listHandler.addDeadline("Read book", "21/12/20", "1800");

        Vector result = listHandler.getList();
        assertEquals(result.size(), 1);
    }

    @Test
    public void testDeleteTask() {
        ListHandler listHandler = new ListHandler();
        listHandler.addToDo("Read Book");

        String indexToDelete = "1";
        listHandler.deleteListItem(indexToDelete);

        Vector result = listHandler.getList();
        assertEquals(result.size(), 0);
    }
}
