package duke;

import duke.command.CommandHandler;
import duke.fileManager.FileManager;
import duke.input.InputHandler;
import duke.input.InputParser;
import duke.output.DisplayHandler;
import duke.storage.ListHandler;

public class Duke {
    //Instantiate Duke program components
    private DisplayHandler displayHandler = new DisplayHandler();
    private InputHandler inputHandler = new InputHandler();
    private InputParser parser = new InputParser();
    private ListHandler list = new ListHandler();
    private CommandHandler command = new CommandHandler();
    private FileManager fileManager = new FileManager("data.txt");

    /**
     * Display the opening statement of DUKE
     */
    public String displayProgramOpening() {
        return displayHandler.programOpening();
    }

    public String readDataFile() {
        return fileManager.readFile(list);
    }

    /**
     * Contains the main logic to run Duke
     */
    public String runLogic(String input) {

        String result = "";

        // Parse User input
        String keyWord = parser.extractKeyWord(input);
        String body = parser.extractKeyWordBody(input, keyWord);

        // If input is not recognised Keyword
        if (parser.checkIfKeyWord(keyWord) == false) {
            result = displayHandler.displayInvalidInput();
        }
        // Else if input is a recognised Keyword
        else {
            result = command.checkCommandType(keyWord, body, list);
        }

        fileManager.saveFile(list.getList());

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
