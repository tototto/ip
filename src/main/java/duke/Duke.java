package duke;

import duke.command.CommandHandler;
import duke.fileManager.FileManager;
import duke.input.InputHandler;
import duke.input.InputParser;
import duke.output.DisplayHandler;
import duke.storage.ListHandler;

import java.io.File;

public class Duke {
    public static void main(String[] args) {

        // Instantiate program components
        DisplayHandler displayHandler = new DisplayHandler();
        InputHandler inputHandler = new InputHandler();
        InputParser parser = new InputParser();
        ListHandler list = new ListHandler();
        CommandHandler command = new CommandHandler();
        FileManager fileManager = new FileManager("data.txt");

        // Uses a Facade to Manage Individual Modular Components
        displayHandler.ProgramOpening();
        // Read from a file
        fileManager.ReadFile(list);

        while(true) {

            // Get User input
            String input = inputHandler.getUserInput();
            // Parse User input
            String keyWord = parser.extractKeyWord(input);
            String body = parser.extractKeyWordBody(input, keyWord);

            // If input is not recognised Keyword
            if (parser.checkIfKeyWord(keyWord) == false) {
                displayHandler.DisplayInvalidInput();
            }
            // If input is a recognised Keyword
            else {
                command.checkCommandType(keyWord, body, list);
            }
            fileManager.SaveFile(list.GetList());
        }
    }
}
