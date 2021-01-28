package duke;

import duke.command.CommandHandler;
import duke.fileManager.FileManager;
import duke.input.InputHandler;
import duke.input.InputParser;
import duke.output.DisplayHandler;
import duke.storage.ListHandler;

import java.io.File;

public class Duke  {

    // Instantiate Duke program components
    DisplayHandler displayHandler = new DisplayHandler();
    InputHandler inputHandler = new InputHandler();
    InputParser parser = new InputParser();
    ListHandler list = new ListHandler();
    CommandHandler command = new CommandHandler();
    FileManager fileManager = new FileManager("data.txt");

    /**
     * Display the opening statement of DUKE
     */
    public String displayProgramOpening() {
        return displayHandler.ProgramOpening();
    }

    public String readDataFile() {
        return fileManager.ReadFile(list);
    }

    public String runLogic(String input) {

        String result = "";

        // Parse User input
        String keyWord = parser.extractKeyWord(input);
        String body = parser.extractKeyWordBody(input, keyWord);

        // If input is not recognised Keyword
        if (parser.checkIfKeyWord(keyWord) == false) {
            result = displayHandler.DisplayInvalidInput();
        }
        // Else if input is a recognised Keyword
        else {
            result = command.checkCommandType(keyWord, body, list);
        }

        fileManager.SaveFile(list.GetList());

        return result;
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public String getResponse(String input) {
        return "Duke: " + input;
    }
}
