package duke.output;

import duke.task.Task;

import java.util.Vector;
import java.util.*;

public class DisplayHandler {

    final private String LOGO_ICON = " ____        _        \n"
                                    + "|  _ \\ _   _| | _____ \n"
                                    + "| | | | | | | |/ / _ \\\n"
                                    + "| |_| | |_| |   <  __/\n"
                                    + "|____/ \\__,_|_|\\_\\___|\n";

    final private String GREETING_MSG = " Hello! I'm duke.Duke\n What can I do for you?";
    final private String SUCCESS_MSG = " Got it. I've added this task: ";
    final private String LIST_MSG = " Here are the tasks in your list:";
    final private String LIST_NUMBER = " Now you have %d tasks in the list.\n";
    final private String DONE_MSG = " Nice! I've marked this task as done: ";
    final private String INVALID_INPUT_MSG = " OOPS!!! I'm sorry, but I don't know what that means :-(";
    final private String DELETE_TASK = " Noted. I've removed this task:";
    final private String GOODBYE_MSG = " Bye. Hope to see you again soon!";
    final private String LINE_DIVIDER = "----------------------------------------";
    final static public String EMPTY_TODO = " OOPS!!! The description of a todo cannot be empty";
    final static public String EMPTY_DEADLINE_DESC = " OOPS!!! The description of a duke Deadline cannot be empty & must be accompanied by Date and Time";
    final static public String EMPTY_DEADLINE_DAY = " OOPS!!! The description of duke's Deadline Day cannot be empty";
    final static public String EMPTY_DEADLINE_TIME = " OOPS!!! The description of duke's Deadline Time cannot be empty";
    final static public String EMPTY_EVENT_DESC = " OOPS!!! The description of a duke Event cannot be empty & must be accompanied by Date and Time Range";
    final static public String EMPTY_EVENT_DAY = " OOPS!!! The description of a duke's Event Day cannot be empty";
    final static public String EMPTY_EVENT_TIME = " OOPS!!! The description of a duke's Event Time cannot be empty";
    final static public String READ_DATA = "Reading data file: ";
    final static public String FILE_NOT_EXISTS = "File does not exists yet : ";
    final static public String FILE_CANNOT_BE_READ = "File cannot be read : ";
    final static public String UNRECOGNISED_TEXT_FORMAT = "There is a unrecognised text format in DUKE data file";
    final static public String WRITE_FILE_ERROR = "Error writing to file: ";
    final static public String CREATED_FILE_SUCCESS = "Created/Updated data file at: ";
    final static public String CLEAR_FILE_ERROR = "Unable to clear file content: ";

    public static void ClearFileFailure(String errorMsg){
        System.out.println(CLEAR_FILE_ERROR + errorMsg);
    }

    public static void CreatedFile(String fileAbsolutePath){
        System.out.println(CREATED_FILE_SUCCESS+fileAbsolutePath);
    }

    public static void WriteFileError(String errorMsg){
        System.out.println(WRITE_FILE_ERROR+errorMsg);
    }

    public static void EncounterWrongFormat(){
        System.out.println(UNRECOGNISED_TEXT_FORMAT);
    }

    public static void CannotReadFile(String errorMsg){
        System.out.println(FILE_CANNOT_BE_READ+ errorMsg);
    }

    public static void FileNotFound(String errorMsg) {
        System.out.println(FILE_NOT_EXISTS+errorMsg);
    }

    public static void ReadDataMsg(String absolutePath){
        System.out.println(READ_DATA + absolutePath);
    }

    private void Greeter(){
        System.out.println(GREETING_MSG);
    }

    private void Goodbye(){
        System.out.println(GOODBYE_MSG);
    }

    private void Divider(){
        System.out.println(LINE_DIVIDER);
    }

    private void Logo(){
        System.out.println(LOGO_ICON);
    }

    private void Success(){
        System.out.println(SUCCESS_MSG);
    }

    private void InvalidInput(){
        System.out.println(INVALID_INPUT_MSG);
    }

    private void ShowListMsg() { System.out.println(LIST_MSG); }

    public void DisplayNumAddedTask(int listNum) {
        System.out.printf(LIST_NUMBER, listNum);
    }

    public void Done(){
        System.out.println(DONE_MSG);
    }

    public void PrintDeleteMsg() {
        System.out.println(DELETE_TASK);
    }

    public void DisplayIndividualTask(Task task){
        System.out.println("   " + task);
    }

    private void ListResult(Vector result){

        ShowListMsg();
        Iterator iter = result.iterator();

        for(int i = 0; iter.hasNext(); i++){
            int currIndex = i + 1 ;
            Task element = (Task)iter.next();
            System.out.println(" " + currIndex + "." + element);
        }
    }

    public void DisplayInvalidInput(){
        InvalidInput();
    }

    public void DisplayChanges(Task task) {
        Divider();
        try{
            task.getStatusIcon(); // check if exception will be thrown, this line has no functional usage

            Done();
            System.out.println(task);

        } catch (NullPointerException e) {
            InvalidInput();
        }
        Divider();
    }

    public void DisplayDeleteResult(int ListNum, Task task) {
        Divider();
        PrintDeleteMsg();
        System.out.println(task);
        DisplayNumAddedTask(ListNum);
        Divider();
    }

    public void DisplayList(Vector result) {
        Divider();
        ListResult(result);
        Divider();
    }

    public void ShowTaskAdded(int ListNum, Task task){
        Divider();
        Success();
        DisplayIndividualTask(task);
        DisplayNumAddedTask(ListNum);
        Divider();
    }

    public void ProgramOpening(){
        // User Interface Display Section
        Divider();
        Logo();
        Greeter();
        Divider();
    }

    public void ProgramEnding(){
        Divider();
        Goodbye();
        Divider();
    }

    public void DisplayCustomException(Exception e) {
        System.out.println(e.getMessage());
    }
}
