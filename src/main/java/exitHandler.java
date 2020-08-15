public class exitHandler {
    private displayHandler DisplayUnit = new displayHandler();

    public void EndProgram(){
        DisplayUnit.ProgramEnding();
        System.exit(0);
    }
}
