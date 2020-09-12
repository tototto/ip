package inputParser;

import duke.exception.IncorrectInputException;
import duke.input.InputParser;
import duke.output.DisplayHandler;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class inputParserTest {

    @Test
    public void Test_KeywordChecker(){
        String keywordStub = "Hello There";

        InputParser inputParser = new InputParser();
        boolean result = inputParser.checkIfKeyWord(keywordStub);

        assertEquals(result, false);
    }

    @Test
    public void Test_KeywordExtraction(){
        String inputStub = "todo Buy groceries from NTUC";

        InputParser inputParser = new InputParser();
        String result = inputParser.extractKeyWord(inputStub);

        assertEquals(result, "todo");
    }

    @Test
    public void Test_DeadlineBodyExtraction(){
        String inputStub = "Read book /by 20/12/20 6pm";

        InputParser inputParser = new InputParser();
        String result = "";

        try{
            result = inputParser.extractDeadlineBody(inputStub);
        }catch (IncorrectInputException e) {
            fail();
        }

        assertEquals(result, "Read book ");
    }
}
