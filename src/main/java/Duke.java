import java.util.Vector;

public class Duke {
    public static void main(String[] args) {

        displayHandler DisplayUnit = new displayHandler();
        inputHandler InputUnit = new inputHandler();
        inputParser Parser = new inputParser();
        listHandler List = new listHandler();
        commandHandler Command = new commandHandler();
        exitHandler exitUnit = new exitHandler();

        // Uses a Facade to Manage Individual Modular Components
        DisplayUnit.ProgramOpening();

        while(true) {

            // Get & Sort user Input
            String Input = InputUnit.getUserInput();
            String Keyword = Parser.extractKeyWord(Input);
            String Body = Parser.extractKeyWordBody(Input);

            // If user decides to Quit
            if(Input.toLowerCase().equals("bye")) exitUnit.EndProgram();

            // Program Logic
            if(Parser.checkIfKeyWord(Keyword) == false) {
                // Add input to Duke List
                List.addToList(Input);
                DisplayUnit.echo(Input);
            }
            else {
                // Check user command & perform associated function
                Command.checkCommandType(Keyword, Body, List);
            }

        }
    }
}
