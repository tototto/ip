public class InputParser {

    // Check if First Word is Keyword
    public boolean checkIfKeyWord(String Input) {

        try {
            KEYWORD.valueOf(Input.toUpperCase());
            return true;

        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // Extract Keyword from Input
    public String extractKeyWord(String Input) {
        String[] Array = Input.split(" ");
        return Array[0];
    }

    // Extract Body from Input
    public String extractKeyWordBody(String Input, String keyword) {
        try {
            return Input.replaceFirst(keyword, "");

        } catch(ArrayIndexOutOfBoundsException e){ // May not be used anymore
            return null;
        }
    }

    // For Todos
    public String extractTodoBody(String TodoInput) throws IncorrectInputException {
        if(TodoInput.isEmpty())
            throw new IncorrectInputException(DisplayHandler.EMPTY_TODO);

        return TodoInput;
    }

    // For Deadlines
    public String extractDeadlineBody(String DeadlineInput) throws IncorrectInputException {
        String result = "";
        try{
            int indx = DeadlineInput.indexOf("/by");
            result = DeadlineInput.substring(0, indx);

        } catch (Exception e){
            if(result.length() < 1){
                throw new IncorrectInputException(DisplayHandler.EMPTY_DEADLINE_DESC);
            }
        }
        return result;
    }

    public String extractDeadlineByDay(String DeadlineInput) throws IncorrectInputException{
        String day = "";
        try{
            int indx = DeadlineInput.indexOf("/by");
            String by = DeadlineInput.substring(indx, DeadlineInput.length());
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

    public String extractDeadlineByTime(String DeadlineInput) throws IncorrectInputException {
        String time = "";
        try{
            int indx = DeadlineInput.indexOf("/by");
            String by = DeadlineInput.substring(indx);
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
    public String extractEventBody(String EventInput) throws IncorrectInputException {
        String result = "";

        try{
            int indx = EventInput.indexOf("/at");
            result = EventInput.substring(0, indx);

        }catch (Exception e){
            if(result.length() < 1){
                throw new IncorrectInputException(DisplayHandler.EMPTY_EVENT_DESC);
            }
        }

        return result;
    }

    public String extractEventAtDay(String EventInput) throws IncorrectInputException{
        String day = "";

        try {
            int indx = EventInput.indexOf("/at");
            String by = EventInput.substring(indx, EventInput.length());
            String[] array = by.split(" ");
            day = array[1];

        }catch (Exception e) {
            if(day.length() < 1){
                throw new IncorrectInputException(DisplayHandler.EMPTY_EVENT_DAY);
            }
        }
        return day;
    }

    public String extractEventAtTime(String EventInput) throws IncorrectInputException {
        String time = "";

        try{
            int indx = EventInput.indexOf("/at");
            String by = EventInput.substring(indx);
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
