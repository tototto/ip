public class InputParser {

    // Check if First Word is Keyword
    public boolean checkIfKeyWord(String input) {

        try {
            KEYWORD.valueOf(input.toUpperCase());
            return true;

        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // Extract Keyword from Input
    public String extractKeyWord(String input) {
        String[] Array = input.split(" ");
        return Array[0];
    }

    // Extract Body from Input
    public String extractKeyWordBody(String input, String keyword) {
        try {
            return input.replaceFirst(keyword, "");

        } catch(ArrayIndexOutOfBoundsException e){ // May not be used anymore
            return null;
        }
    }

    // For Todos
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
