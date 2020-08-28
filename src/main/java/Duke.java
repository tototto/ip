public class Duke {
    public static void main(String[] args) {

        // Instantiate program components
        DisplayHandler DisplayUnit = new DisplayHandler();
        InputHandler InputUnit = new InputHandler();
        InputParser Parser = new InputParser();
        ListHandler List = new ListHandler();
        CommandHandler Command = new CommandHandler();

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
