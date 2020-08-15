import java.util.Vector;
import java.util.*;

public class displayHandler {

    final private String LOGO_ICON = " ____        _        \n"
                                    + "|  _ \\ _   _| | _____ \n"
                                    + "| | | | | | | |/ / _ \\\n"
                                    + "| |_| | |_| |   <  __/\n"
                                    + "|____/ \\__,_|_|\\_\\___|\n";

    final private String GREETING_MSG = " Hello! I'm Duke\n What can I do for you?";
    final private String SUCCESS_MSG = " added: ";
    final private String DONE_MSG = " Nice! I've marked this task as done: ";
    final private String INVALID_INPUT_MSG = " That input was invalid! Try Again!";
    final private String GOODBYE_MSG = " Bye. Hope to see you again soon!";
    final private String LINE_DIVIDER = "----------------------------------------";

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
        System.out.print(SUCCESS_MSG);
    }

    private void InvalidInput(){
        System.out.println(INVALID_INPUT_MSG);
    }

    public void DisplayUserCommand(String command){
        System.out.println(command);
    }

    public void Done(){
        System.out.println(DONE_MSG);
    }

    private void ListResult(Vector result){

        Iterator iter = result.iterator();

        for(int i = 0; iter.hasNext(); i++){
            int currIndex = i + 1 ;
            Task element = (Task)iter.next();
            System.out.println(" " + currIndex + ". [" + element.getStatusIcon() + "] " + element.getTaskDescription());
        }
    }

    public void DisplayChanges(Task task){
        Divider();
        try{
            task.getStatusIcon(); // check if exception will be thrown, this line has no functional usage

            Done();
            System.out.println(" [" + task.getStatusIcon() + "] " + task.getTaskDescription());

        } catch (NullPointerException e){
            InvalidInput();
        }
        Divider();
    }

    public void DisplayList(Vector result) {
        Divider();
        ListResult(result);
        Divider();
    }

    public void echo(String command){
        Divider();
        Success(); DisplayUserCommand(command);
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
}
