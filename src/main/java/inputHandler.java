import java.util.Scanner;

public class inputHandler {

    static private Scanner fromInputStream = new Scanner(System.in);

    public String getUserInput(){

        String command = fromInputStream.nextLine();

        return command;
    }
}
