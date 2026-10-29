import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

/**
 * Main class that starts the JavaFX application
 * and displays the login screen.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Load the login screen from its FXML file.
        FXMLLoader loader = new FXMLLoader(
                Main.class.getResource("/login.fxml")
        );

        Parent root = loader.load();

        // Pass the list of valid users to the login controller.
        LoginController controller = loader.getController();
        controller.setUsers(UsersApp.loadUsers());

        // Create and display the login window.
        Scene scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Start the JavaFX application.
        launch(args);
    }
}
