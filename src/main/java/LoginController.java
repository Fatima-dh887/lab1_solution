import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Handles login actions and displays the Welcome screen
 * when the entered credentials match a valid user.
 */
public class LoginController {
    private ArrayList<User> users;

    // Receives the list of valid users from Main.
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    private void handleLogin() {
        // Read the username and password entered by the user.
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Search for a user with matching credentials.
        for (User user : users) {
            if (user.getName().equals(username)
                    && user.getPassword().equals(password)) {

                try {
                    // Load the Welcome screen from its FXML file.
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource("/welcome.fxml")
                    );

                    Parent root = loader.load();

                    // Pass the username to the Welcome controller.
                    WelcomeController controller = loader.getController();
                    controller.setUsername(username);

                    // Open the Welcome window and close the Login window.
                    Stage welcomeStage = new Stage();
                    welcomeStage.setTitle("Welcome");
                    welcomeStage.setScene(new Scene(root));
                    welcomeStage.show();

                    Stage loginStage = (Stage) usernameField.getScene().getWindow();
                    loginStage.close();

                } catch (Exception e) {
                    // Display an error inside the Login window if loading fails.
                    messageLabel.setText("Could not open Welcome screen.");
                    e.printStackTrace();
                }

                return;
            }
        }

        // Display an error inside the Login window if credentials are incorrect.
        messageLabel.setText("Invalid username or password.");
    }
}

