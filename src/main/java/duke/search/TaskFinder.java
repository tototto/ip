package duke.search;

import duke.storage.ListHandler;
import duke.task.Task;

import java.util.Iterator;
import java.util.Vector;

public class TaskFinder {
    public static void FindTask(String searchTerm , Vector taskList){
        Iterator taskIter = taskList.iterator();

        System.out.println("----------------------------------------");
        System.out.println("Here are the matching tasks in your list:");

        for(int i= 0; taskIter.hasNext(); i++){
             Task currTask = (Task)taskIter.next();
             String currTaskDesc = currTask.getTaskDescription();

             if(currTaskDesc.contains(searchTerm)){
                 System.out.println(i+1 + "." + currTask);
             }
        }

        System.out.println("----------------------------------------");
    }
}
