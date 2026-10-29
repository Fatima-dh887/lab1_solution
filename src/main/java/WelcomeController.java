import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controls the Welcome screen and displays the username
 * of the user who logged in successfully.
 */
public class WelcomeController {

    @FXML
    private Label welcomeLabel;

    // Updates the Welcome message with the username.
    public void setUsername(String username) {
        welcomeLabel.setText("Welcome, " + username + "!");
    }
}