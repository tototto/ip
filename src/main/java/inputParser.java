public class inputParser {

    public boolean checkIfKeyWord(String Input) {

        try {
            KEYWORD.valueOf(Input.toUpperCase());
            return true;

        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public String extractKeyWord(String Input) {
        String[] Array = Input.split(" ");
        return Array[0];
    }

    public String extractKeyWordBody(String Input) {
        try {
            String[] Array = Input.split(" ");
            return Array[1];

        } catch(ArrayIndexOutOfBoundsException e){
            return null;
        }
    }
}
