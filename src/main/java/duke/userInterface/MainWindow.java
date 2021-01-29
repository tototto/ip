package duke.userInterface;

import duke.Duke;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Duke duke;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setDuke(Duke d) {
        duke = d;
        startDuke();
    }

    private void startDuke() {
        displayDukeResponse(duke.displayProgramOpening());
        displayDukeResponse(duke.readDataFile());
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {

        // Get and display user input
        String input = getInput();
        displayUserInput(input);

        String dukeResponse = duke.runLogic(input);
        //System.out.println(dukeResponse);
        displayDukeResponse(dukeResponse);

        userInput.clear();
    }

    private String getInput() {
        return userInput.getText();
    }

    /**
     * Creates dialog boxes containing Duke's reply and then appends them to
     * the dialog container.
     */
    private void displayDukeResponse(String response) {
        String dukeText = duke.getResponse(response);
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog(dukeText, dukeImage)
        );
    }

    /**
     * Creates dialog boxes containing User's Input and then appends them to
     * the dialog container.
     */
    private void displayUserInput(String input) {
        String userText = input;
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, userImage)
        );
    }
}
