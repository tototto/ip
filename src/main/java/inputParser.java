public class inputParser {

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
    // For Deadlines
    public String extractDeadlineBody(String DeadlineInput){
        int indx = DeadlineInput.indexOf("/by");
        return DeadlineInput.substring(0, indx);
    }

    public String extractDeadlineByDay(String DeadlineInput){
        int indx = DeadlineInput.indexOf("/by");
        String by = DeadlineInput.substring(indx, DeadlineInput.length());
        String[] array = by.split(" ");
        return array[1];
    }

    public String extractDeadlineByTime(String DeadlineInput){
        try{
            int indx = DeadlineInput.indexOf("/by");
            String by = DeadlineInput.substring(indx);
            String[] array = by.split(" ");
            return array[2];
        }catch (Exception e)
        {
            return "";
        }
    }
    // For Events
    public String extractEventBody(String EventInput){
        int indx = EventInput.indexOf("/at");
        return EventInput.substring(0, indx);
    }

    public String extractEventAtDay(String EventInput){
        int indx = EventInput.indexOf("/at");
        String by = EventInput.substring(indx, EventInput.length());
        String[] array = by.split(" ");
        return array[1];
    }

    public String extractEventAtTime(String EventInput){
        try{
            int indx = EventInput.indexOf("/at");
            String by = EventInput.substring(indx);
            String[] array = by.split(" ");
            return array[2];
        }catch (Exception e)
        {
            return "";
        }
    }

}
