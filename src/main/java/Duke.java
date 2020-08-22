import java.util.Vector;

public class Duke {
    public static void main(String[] args) {

        // Instantiate program components
        displayHandler DisplayUnit = new displayHandler();
        inputHandler InputUnit = new inputHandler();
        inputParser Parser = new inputParser();
        listHandler List = new listHandler();
        commandHandler Command = new commandHandler();

        // Uses a Facade to Manage Individual Modular Components
        DisplayUnit.ProgramOpening();

        while(true) {

            // Get User Input
            String Input = InputUnit.getUserInput();
            // Parse User Input
            String Keyword = Parser.extractKeyWord(Input);
            String Body = Parser.extractKeyWordBody(Input, Keyword);

            // If Input is not recognised Keyword
            if(Parser.checkIfKeyWord(Keyword) == false)
                DisplayUnit.DisplayInvalidInput();
            // If Input is a recognised Keyword
            else
                Command.checkCommandType(Keyword, Body, List);
        }
    }
}
