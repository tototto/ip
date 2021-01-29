package duke.exception;

/**
 * Custom error message
 * Handles user input issues
 * Used when performing String manipulation
 */
public class IncorrectInputException extends Exception {
    public IncorrectInputException(String message) {
        super(message);
    }
}
