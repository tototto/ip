package duke.command;//import jdk.internal.util.xml.impl.Input;

import duke.output.DisplayHandler;
import duke.search.TaskFinder;
import duke.storage.ListHandler;
import duke.exception.IncorrectInputException;
import duke.input.InputParser;
import duke.task.Task;

/**
 * Handles all commands that user will input
 * Commands are listed in the switch-case statement
 */
public class CommandHandler {

    DisplayHandler displayHandler = new DisplayHandler();
    InputParser inputParser = new InputParser();

    /**
     * Used to handles the different behaviors of the respective commands
     * @param KeyWord Command for duke
     * @param Body User task input
     * @param List contains the list of user Tasks
     */
    public String checkCommandType(String KeyWord, String Body, ListHandler List) {

        KEYWORD keyword = KEYWORD.valueOf(KeyWord.toUpperCase());
        String output = "";

        try{

            switch(keyword){
                case TODO:
                    String todoBody = inputParser.extractTodoBody(Body);
                    List.addToDo(todoBody);
                    Task todoTaskAdded = (Task) List.GetList().lastElement();
                    output =displayHandler.ShowTaskAdded(List.GetList().size(), todoTaskAdded);
                    break;

                case DEADLINE:
                    String deadlineBody = inputParser.extractDeadlineBody(Body);
                    String deadlineByDate = inputParser.extractDeadlineByDay(Body);
                    String deadlineByTime = inputParser.extractDeadlineByTime(Body);
                    List.addDeadline(deadlineBody, deadlineByDate, deadlineByTime);
                    Task deadlineTaskAdded = (Task) List.GetList().lastElement();
                    output =displayHandler.ShowTaskAdded(List.GetList().size(), deadlineTaskAdded);
                    break;

                case EVENT:
                    String eventBody = inputParser.extractEventBody(Body);
                    String eventDay = inputParser.extractEventAtDay(Body);;
                    String eventTime = inputParser.extractEventAtTime(Body);
                    List.addEvent(eventBody, eventDay, eventTime);
                    Task EventTaskAdded = (Task) List.GetList().lastElement();
                    output =displayHandler.ShowTaskAdded(List.GetList().size(), EventTaskAdded);
                    break;

                case LIST:
                    output =displayHandler.DisplayList(List.GetList());
                    break;

                case DONE:
                    Task taskDone = List.UpdateListItem(Body);
                    output =displayHandler.DisplayChanges(taskDone);
                    break;

                case DELETE:
                    Task taskDeleted = List.DeleteListItem(Body);
                    output =displayHandler.DisplayDeleteResult(List.GetList().size(), taskDeleted);
                    break;

                case FIND:
                    output =TaskFinder.FindTask(Body, List.GetList());
                    break;

                case BYE:
                    output =displayHandler.ProgramEnding();
                    System.exit(0);
                    break;
            }

        } catch (Exception e){
            if(e instanceof IncorrectInputException){
                output =displayHandler.DisplayCustomException(e);
            }
            else {
                output =displayHandler.DisplayInvalidInput();
            }
        }

        return output;
    }
}
