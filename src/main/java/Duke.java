public class Duke {
    public static void main(String[] args) {

        // Instantiate program components
        DisplayHandler displayHandler = new DisplayHandler();
        InputHandler inputHandler = new InputHandler();
        InputParser parser = new InputParser();
        ListHandler list = new ListHandler();
        CommandHandler command = new CommandHandler();

        // Uses a Facade to Manage Individual Modular Components
        displayHandler.ProgramOpening();

        while(true) {

            // Get User input
            String input = inputHandler.getUserInput();
            // Parse User input
            String keyWord = parser.extractKeyWord(input);
            String body = parser.extractKeyWordBody(input, keyWord);

            // If input is not recognised Keyword
            if(parser.checkIfKeyWord(keyWord) == false)
                displayHandler.DisplayInvalidInput();
            // If input is a recognised Keyword
            else
                command.checkCommandType(keyWord, body, list);
        }
    }
}
