//import jdk.internal.util.xml.impl.Input;

public class CommandHandler {

    DisplayHandler displayHandler = new DisplayHandler();
    InputParser inputParser = new InputParser();

    public void checkCommandType(String KeyWord, String Body, ListHandler List) {

        KEYWORD keyword = KEYWORD.valueOf(KeyWord.toUpperCase());

        try{

            switch(keyword){
                case TODO:
                    String todoBody = inputParser.extractTodoBody(Body);
                    List.addToDo(todoBody);
                    Task todoTaskAdded = (Task) List.GetList().lastElement();
                    displayHandler.ShowTaskAdded(List.GetList().size(), todoTaskAdded);
                    break;

                case DEADLINE:
                    String deadlineBody = inputParser.extractDeadlineBody(Body);
                    String deadlineByDate = inputParser.extractDeadlineByDay(Body);
                    String deadlineByTime = inputParser.extractDeadlineByTime(Body);
                    List.addDeadline(deadlineBody, deadlineByDate, deadlineByTime);
                    Task deadlineTaskAdded = (Task) List.GetList().lastElement();
                    displayHandler.ShowTaskAdded(List.GetList().size(), deadlineTaskAdded);
                    break;

                case EVENT:
                    String eventBody = inputParser.extractEventBody(Body);
                    String eventDay = inputParser.extractEventAtDay(Body);;
                    String eventTime = inputParser.extractEventAtTime(Body);
                    List.addEvent(eventBody, eventDay, eventTime);
                    Task EventTaskAdded = (Task) List.GetList().lastElement();
                    displayHandler.ShowTaskAdded(List.GetList().size(), EventTaskAdded);
                    break;

                case LIST:
                    displayHandler.DisplayList(List.GetList());
                    break;

                case DONE:
                    Task task = List.UpdateListItem(Body);
                    displayHandler.DisplayChanges(task);
                    break;

                case BYE:
                    displayHandler.ProgramEnding();
                    System.exit(0);
                    break;
            }

        } catch (Exception e){
            if(e instanceof IncorrectInputException){
                displayHandler.DisplayCustomException(e);
            }
            else {
                displayHandler.DisplayInvalidInput();
            }
        }
    }
}
