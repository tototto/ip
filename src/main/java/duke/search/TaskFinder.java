package duke.search;

import duke.storage.ListHandler;
import duke.task.Task;

import java.util.Iterator;
import java.util.Vector;

public class TaskFinder {
    public static String FindTask(String searchTerm , Vector taskList){
        Iterator taskIter = taskList.iterator();
        String output;

        output = "----------------------------------------" + '\n';
        output = output + "Here are the matching tasks in your list:" + '\n';

        for(int i= 0; taskIter.hasNext(); i++){
             Task currTask = (Task)taskIter.next();
             String currTaskDesc = currTask.getTaskDescription();

             if(currTaskDesc.contains(searchTerm)){
                 System.out.println(i+1 + "." + currTask);
                 int indx = i+1;
                 output = output + indx + "." + currTask + '\n';
             }
        }

        output = output + "----------------------------------------" + '\n';

        return output;
    }
}
