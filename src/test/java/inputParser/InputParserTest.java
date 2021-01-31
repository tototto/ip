package inputParser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import duke.exception.IncorrectInputException;
import duke.input.InputParser;

public class InputParserTest {

    @Test
    public void testKeywordChecker() {
        String keywordStub = "Hello There";

        InputParser inputParser = new InputParser();
        boolean result = inputParser.checkIfKeyWord(keywordStub);

        assertEquals(result, false);
    }

    @Test
    public void testKeywordExtraction() {
        String inputStub = "todo Buy groceries from NTUC";

        InputParser inputParser = new InputParser();
        String result = inputParser.extractKeyWord(inputStub);

        assertEquals(result, "todo");
    }

    @Test
    public void testDeadlineBodyExtraction() {
        String inputStub = "Read book /by 20/12/20 6pm";

        InputParser inputParser = new InputParser();
        String result = "";

        try {
            result = inputParser.extractDeadlineBody(inputStub);
        } catch (IncorrectInputException e) {
            fail();
        }

        assertEquals(result, "Read book ");
    }
}
