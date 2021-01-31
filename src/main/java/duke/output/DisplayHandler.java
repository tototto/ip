package duke.output;

import java.util.Iterator;
import java.util.Vector;

import duke.task.Task;

public class DisplayHandler {

    public static final String EMPTY_TODO = " OOPS!!! The description of a todo cannot be empty";
    public static final String EMPTY_DEADLINE_DESC = " OOPS!!! The description of a duke Deadline "
                                                        + "cannot be empty & must be accompanied by Date and Time";
    public static final String EMPTY_DEADLINE_DAY = " OOPS!!! The description of duke's Deadline Day cannot be empty";
    public static final String EMPTY_DEADLINE_TIME = " OOPS!!! The description of duke's Deadline Time cannot be empty";
    public static final String EMPTY_EVENT_DESC = " OOPS!!! The description of a duke Event "
                                                    + "cannot be empty & must be accompanied by Date and Time Range";
    public static final String EMPTY_EVENT_DAY = " OOPS!!! The description of a duke's Event Day cannot be empty";
    public static final String EMPTY_EVENT_TIME = " OOPS!!! The description of a duke's Event Time cannot be empty";
    public static final String FILE_NOT_EXISTS = "File does not exists yet : ";
    public static final String FILE_CANNOT_BE_READ = "File cannot be read : ";
    public static final String UNRECOGNISED_TEXT_FORMAT = "There is a unrecognised text format in DUKE data file";
    public static final String WRITE_FILE_ERROR = "Error writing to file: ";
    public static final String CREATED_FILE_SUCCESS = "Created/Updated data file at: ";
    public static final String CLEAR_FILE_ERROR = "Unable to clear file content: ";
    public static final String WRONG_COMMAND = "OOPS!!! No such command exists";

    private final String logoIcon = " ____        _        \n"
                                    + "|  _ \\ _   _| | _____ \n"
                                    + "| | | | | | | |/ / _ \\\n"
                                    + "| |_| | |_| |   <  __/\n"
                                    + "|____/ \\__,_|_|\\_\\___|\n";

    private final String greetingMsg = " Hello! I'm duke.Duke\n What can I do for you?";
    private final String successMsg = " Got it. I've added this task: ";
    private final String listMsg = " Here are the tasks in your list:";
    private final String doneMsg = " Nice! I've marked this task as done: ";
    private final String invalidInputMsg = " OOPS!!! I'm sorry, but I don't know what that means :-(";
    private final String deleteTask = " Noted. I've removed this task:";
    private final String goodbyeMsg = " Bye. Hope to see you again soon!";
    private final String lineDivider = "----------------------------------------";

    public static void clearFileFailure(String errorMsg) {
        System.out.println(CLEAR_FILE_ERROR + errorMsg);
    }

    public static void createdFile(String fileAbsolutePath) {
        System.out.println(CREATED_FILE_SUCCESS + fileAbsolutePath);
    }

    public static void writeFileError(String errorMsg) {
        System.out.println(WRITE_FILE_ERROR + errorMsg);
    }

    public static void encounterWrongFormat() {
        System.out.println(UNRECOGNISED_TEXT_FORMAT);
    }

    public static void cannotReadFile(String errorMsg) {
        System.out.println(FILE_CANNOT_BE_READ + errorMsg);
    }

    public static void fileNotFound(String errorMsg) {
        System.out.println(FILE_NOT_EXISTS + errorMsg);
    }

    private void greeter() {
        System.out.println(greetingMsg);
    }

    private String goodbye() {
        return goodbyeMsg;
    }

    private String divider() {
        return (lineDivider);
    }

    private void logo() {
        System.out.println(logoIcon);
    }

    private void success() {
        System.out.println(successMsg);
    }

    private String invalidInput() {
        return invalidInputMsg;
    }

    private String showListMsg() {
        return listMsg;
    }

    public String displayNumAddedTask(int listNum) {
        return "Now you have " + listNum + " task in the list";
    }

    public String done() {
        return doneMsg;
    }

    public String printDeleteMsg() {
        return deleteTask;
    }

    public String displayIndividualTask(Task task) {
        return "   " + task;
    }

    private String listResult(Vector result) {

        String output = "";
        output = output + showListMsg() + '\n';
        Iterator iter = result.iterator();

        for (int i = 0; iter.hasNext(); i++) {
            int currIndex = i + 1;
            Task element = (Task) iter.next();
            output = output + " " + currIndex + "." + element + '\n';
        }

        return output;
    }

    public String displayInvalidInput() {
        return invalidInputMsg;
    }

    /**
     * Output the new state of the task that was updated
     * @param task to be updated
     * @return result of the update
     */
    public String displayChanges(Task task) {

        try {
            task.getStatusIcon(); // check if exception will be thrown, this line has no functional usage
            return lineDivider + '\n' + done() + task + '\n' + lineDivider;

        } catch (NullPointerException e) {
            return invalidInput();
        }

    }

    /**
     * Output the result of the deletion
     * @param ListNum ID of the deletion
     * @param task the task to be deleted
     * @return result of the deletion
     */
    public String displayDeleteResult(int ListNum, Task task) {
        try {
            task.getStatusIcon(); // check if exception will be thrown, this line has no functional usage
            return lineDivider + '\n'
                    + printDeleteMsg()
                    + task + '\n'
                    + displayNumAddedTask(ListNum)
                    + '\n' + lineDivider;
        } catch (NullPointerException e) {
            return invalidInput();
        }
    }

    public String displayList(Vector result) {
        return '\n' + lineDivider + '\n' + listResult(result) + '\n' + lineDivider;
    }

    /**
     * Display the task that was added to duke
     * @param ListNum ID of new task
     * @param task task data
     * @return the result of the added task
     */
    public String showTaskAdded(int ListNum, Task task) {
        return '\n'
                + lineDivider
                + '\n'
                + successMsg
                + displayIndividualTask(task)
                + '\n'
                + displayNumAddedTask(ListNum)
                + '\n' + lineDivider;
    }

    public String programOpening() {
        return '\n' + lineDivider + '\n' + logoIcon + '\n' + greetingMsg + '\n' + lineDivider;
    }

    public String programEnding() {
        return '\n' + lineDivider + '\n' + goodbye() + '\n' + lineDivider;
    }

    public String displayCustomException(Exception e) {
        return e.getMessage();
    }

    /**
     * Display Help guide to user
     * @return list of command usage details
     */
    public String displayHelp() {
        return "TODO : todo <task desc> "
                + " \n DEADLINE: deadline <task desc> /by <date> <time> "
                + " \n EVENT: event <event desc> /at <date> <time period>"
                + " \n LIST: list"
                + " \n DONE: done <task id>"
                + " \n DELETE: delete <id>"
                + " \n FIND: find <Search String>"
                + " \n BYE: bye";
    }
}
