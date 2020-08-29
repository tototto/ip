//import jdk.internal.util.xml.impl.Input;

public class CommandHandler {

    DisplayHandler DisplayUnit = new DisplayHandler();
    InputParser InputUnit = new InputParser();

    public void checkCommandType(String KeyWord, String Body, ListHandler List) {

        KEYWORD keyword = KEYWORD.valueOf(KeyWord.toUpperCase());

        try{

            switch(keyword){
                case TODO:
                    String todoBody = InputUnit.extractTodoBody(Body);
                    List.addToDo(todoBody);
                    Task todoTaskAdded = (Task) List.GetList().lastElement();
                    DisplayUnit.ShowTaskAdded(List.GetList().size(), todoTaskAdded);
                    break;

                case DEADLINE:
                    String deadlineBody = InputUnit.extractDeadlineBody(Body);
                    String deadlineByDate = InputUnit.extractDeadlineByDay(Body);
                    String deadlineByTime = InputUnit.extractDeadlineByTime(Body);
                    List.addDeadline(deadlineBody, deadlineByDate, deadlineByTime);
                    Task deadlineTaskAdded = (Task) List.GetList().lastElement();
                    DisplayUnit.ShowTaskAdded(List.GetList().size(), deadlineTaskAdded);
                    break;

                case EVENT:
                    String eventBody = InputUnit.extractEventBody(Body);
                    String eventDay = InputUnit.extractEventAtDay(Body);;
                    String eventTime = InputUnit.extractEventAtTime(Body);
                    List.addEvent(eventBody, eventDay, eventTime);
                    Task EventTaskAdded = (Task) List.GetList().lastElement();
                    DisplayUnit.ShowTaskAdded(List.GetList().size(), EventTaskAdded);
                    break;

                case LIST:
                    DisplayUnit.DisplayList(List.GetList());
                    break;

                case DONE:
                    Task task = List.UpdateListItem(Body);
                    DisplayUnit.DisplayChanges(task);
                    break;

                case BYE:
                    DisplayUnit.ProgramEnding();
                    System.exit(0);
                    break;
            }

        } catch (Exception e){
            if(e instanceof IncorrectInputException){
                DisplayUnit.DisplayCustomException(e);
            }
            else {
                DisplayUnit.DisplayInvalidInput();
            }
        }
    }
}
