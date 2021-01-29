package duke.input;

import java.util.Scanner;

/**
 * Used to obtain user input from Input Stream
 */
public class InputHandler {

    private static Scanner fromInputStream = new Scanner(System.in);

    /**
     * Used to get user input
     * @return a line of user input e.g. todo Birthday Celebration
     */
    public String getUserInput() {
        String command = fromInputStream.nextLine();
        return command;
    }
}
