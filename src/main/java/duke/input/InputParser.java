package duke.input;

import duke.output.DisplayHandler;
import duke.command.KEYWORD;
import duke.exception.IncorrectInputException;

/**
 * Handles and transform user input
 * Turns input into format accepted by DUKE
 */
public class InputParser {

    /**
     * Determine if user entered a Task
     * @param input value to be checked
     * @return returns true if keyword, false otherwise
     */
    public boolean checkIfKeyWord(String input) {

        try {
            KEYWORD.valueOf(input.toUpperCase());
            return true;

        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Get Task keyWord from user input line
     * @param input value to be parsed
     * @return return keyword from @param input
     */
    public String extractKeyWord(String input) {
        String[] Array = input.split(" ");
        return Array[0];
    }

    /**
     * Get Task body from user's input
     * @param input full line of user input
     * @param keyword keyword of user
     * @return return extracted body
     */
    public String extractKeyWordBody(String input, String keyword) {
        try {
            return input.replaceFirst(keyword, "");

        } catch(ArrayIndexOutOfBoundsException e){ // May not be used anymore
            return null;
        }
    }

    /**
     * Extract body from Todo
     * @param todoInput take input line from a todo
     * @return extracted body
     * @throws IncorrectInputException for wrong input format
     */
    public String extractTodoBody(String todoInput) throws IncorrectInputException {
        if(todoInput.isEmpty())
            throw new IncorrectInputException(DisplayHandler.EMPTY_TODO);

        return todoInput;
    }

    // For Deadlines
    public String extractDeadlineBody(String deadlineInput) throws IncorrectInputException {
        String result = "";
        try{
            int indx = deadlineInput.indexOf("/by");
            result = deadlineInput.substring(0, indx);

        } catch (Exception e){
            if(result.length() < 1){
                throw new IncorrectInputException(DisplayHandler.EMPTY_DEADLINE_DESC);
            }
        }
        return result;
    }

    public String extractDeadlineByDay(String deadlineInput) throws IncorrectInputException{
        String day = "";
        try{
            int indx = deadlineInput.indexOf("/by");
            String by = deadlineInput.substring(indx, deadlineInput.length());
            String[] array = by.split(" ");
            day = array[1];
            return day;

        }catch (Exception e) {
            if(day.length() < 1){
                throw new IncorrectInputException(DisplayHandler.EMPTY_DEADLINE_DAY);
            }
        }

        return day;
    }

    public String extractDeadlineByTime(String deadlineInput) throws IncorrectInputException {
        String time = "";
        try{
            int indx = deadlineInput.indexOf("/by");
            String by = deadlineInput.substring(indx);
            String[] array = by.split(" ");
            time = array[2];

        } catch (Exception e) {
            if(time.length() < 1){
                throw new IncorrectInputException(DisplayHandler.EMPTY_DEADLINE_TIME);
            }
        }

        return time;
    }

    // For Events
    public String extractEventBody(String eventInput) throws IncorrectInputException {
        String result = "";

        try{
            int indx = eventInput.indexOf("/at");
            result = eventInput.substring(0, indx);

        }catch (Exception e){
            if(result.length() < 1){
                throw new IncorrectInputException(DisplayHandler.EMPTY_EVENT_DESC);
            }
        }

        return result;
    }

    public String extractEventAtDay(String eventInput) throws IncorrectInputException{
        String day = "";

        try {
            int indx = eventInput.indexOf("/at");
            String by = eventInput.substring(indx, eventInput.length());
            String[] array = by.split(" ");
            day = array[1];

        }catch (Exception e) {
            if(day.length() < 1){
                throw new IncorrectInputException(DisplayHandler.EMPTY_EVENT_DAY);
            }
        }
        return day;
    }

    public String extractEventAtTime(String eventInput) throws IncorrectInputException {
        String time = "";

        try{
            int indx = eventInput.indexOf("/at");
            String by = eventInput.substring(indx);
            String[] array = by.split(" ");
            time = array[2];

        } catch (Exception e) {
            if(time.length() < 1){
                throw new IncorrectInputException(DisplayHandler.EMPTY_EVENT_TIME);
            }
        }

        return time;
    }
}
