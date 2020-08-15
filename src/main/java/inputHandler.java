import java.util.Scanner;

public class inputHandler {

    public String getUserInput(){
        Scanner fromInputStream = new Scanner(System.in);
        String command = fromInputStream.nextLine();

        return command;
    }
}
