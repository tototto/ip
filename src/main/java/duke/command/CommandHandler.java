package duke.command;

import duke.exception.IncorrectInputException;
import duke.input.InputParser;
import duke.output.DisplayHandler;
import duke.search.TaskFinder;
import duke.storage.ListHandler;
import duke.task.Task;

/**
 * Handles all commands that user will input
 * Commands are listed in the switch-case statement
 */
public class CommandHandler {

    private DisplayHandler displayHandler = new DisplayHandler();
    private InputParser inputParser = new InputParser();

    /**
     * Used to handles the different behaviors of the respective commands
     * @param KeyWord Command for duke
     * @param Body User task input
     * @param List contains the list of user Tasks
     */
    public String checkCommandType(String KeyWord, String Body, ListHandler List) {

        keyword keyword = duke.command.keyword.valueOf(KeyWord.toUpperCase());
        String output = "";

        try {
            switch(keyword) {
            case TODO:
                String todoBody = inputParser.extractTodoBody(Body);
                List.addToDo(todoBody);
                Task todoTaskAdded = (Task) List.getList().lastElement();
                output = displayHandler.showTaskAdded(List.getList().size(), todoTaskAdded);
                break;

            case DEADLINE:
                String deadlineBody = inputParser.extractDeadlineBody(Body);
                String deadlineByDate = inputParser.extractDeadlineByDay(Body);
                String deadlineByTime = inputParser.extractDeadlineByTime(Body);
                List.addDeadline(deadlineBody, deadlineByDate, deadlineByTime);
                Task deadlineTaskAdded = (Task) List.getList().lastElement();
                output = displayHandler.showTaskAdded(List.getList().size(), deadlineTaskAdded);
                break;

            case EVENT:
                String eventBody = inputParser.extractEventBody(Body);
                String eventDay = inputParser.extractEventAtDay(Body);;
                String eventTime = inputParser.extractEventAtTime(Body);
                List.addEvent(eventBody, eventDay, eventTime);
                Task EventTaskAdded = (Task) List.getList().lastElement();
                output = displayHandler.showTaskAdded(List.getList().size(), EventTaskAdded);
                break;

            case LIST:
                output = displayHandler.displayList(List.getList());
                break;

            case DONE:
                Task taskDone = List.updateListItem(Body);
                output = displayHandler.displayChanges(taskDone);
                break;

            case DELETE:
                Task taskDeleted = List.deleteListItem(Body);
                output = displayHandler.displayDeleteResult(List.getList().size(), taskDeleted);
                break;

            case FIND:
                output = TaskFinder.findTask(Body, List.getList());
                break;

            case HELP:
                output = displayHandler.displayHelp();
                break;
            case BYE:
                output = displayHandler.programEnding();
                System.exit(0);
                break;

            default:
                break;
            }

        } catch (Exception e) {
            if (e instanceof IncorrectInputException) {
                output = displayHandler.displayCustomException(e);
            }
            else {
                output = displayHandler.displayInvalidInput();
            }
        }

        return output;
    }
}
