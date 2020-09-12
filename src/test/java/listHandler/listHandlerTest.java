package listHandler;

import duke.storage.ListHandler;
import org.junit.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class listHandlerTest {

    @Test
    public void Test_AddTodo(){
        ListHandler listHandler = new ListHandler();
        listHandler.addToDo("Read Book");

        Vector result =  listHandler.GetList();
        assertEquals(result.size(), 1);
    }

    @Test
    public void Test_AddDeadline(){
        ListHandler listHandler = new ListHandler();
        listHandler.addDeadline("Read book", "21/12/20", "1800");

        Vector result =  listHandler.GetList();
        assertEquals(result.size(), 1);
    }

    @Test
    public void Test_DeleteTask(){
        ListHandler listHandler = new ListHandler();
        listHandler.addToDo("Read Book");

        String indexToDelete = "1";
        listHandler.DeleteListItem(indexToDelete);

        Vector result =  listHandler.GetList();
        assertEquals(result.size(), 0);
    }
}
