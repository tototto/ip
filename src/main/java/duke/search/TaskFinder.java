package duke.search;

import java.util.Iterator;
import java.util.Vector;

import duke.task.Task;

public class TaskFinder {
    /**
     * Find task in Duke list
     * @param searchTerm string to search for
     * @param taskList the task List to be searched
     * @return the task found
     */
    @SuppressWarnings("checkstyle:Regexp")
    public static String findTask(String searchTerm , Vector taskList) {
        Iterator taskIter = taskList.iterator();
        String output;

        output = "----------------------------------------" + '\n';
        output = output + "Here are the matching tasks in your list:" + '\n';

        for (int i = 0; taskIter.hasNext(); i++) {
            Task currTask = (Task) taskIter.next();
            String currTaskDesc = currTask.getTaskDescription();

            if (currTaskDesc.contains(searchTerm)) {
                //System.out.println(i+1 + "." + currTask);
                int indx = i + 1;
                output = output + indx + "." + currTask + '\n';
            }
        }

        output = output + "----------------------------------------" + '\n';

        return output;
    }
}
