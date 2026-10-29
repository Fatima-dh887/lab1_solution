import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.InputStream;

/**
 * Reads the users file and creates a list containing
 * only users whose credentials pass the User validations.
 */
public class UsersApp {

    /**
     * Loads users from Users.txt.
     * Invalid users and lines with an incorrect format are skipped.
     *
     * @return a list of valid users
     * @throws FileNotFoundException if Users.txt cannot be found
     */
    public static ArrayList<User> loadUsers() throws FileNotFoundException {
        ArrayList<User> users = new ArrayList<>();

        InputStream input = UsersApp.class.getResourceAsStream("/Users.txt");

        if (input == null) {
            throw new FileNotFoundException("Users.txt not found");
        }

        try (Scanner reader = new Scanner(input)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.trim().split("\\s+");

                if (parts.length == 2) {
                    String username = parts[0];
                    String password = parts[1];

                    try {
                        User user = new User(username, password);
                        users.add(user);
                    } catch (IllegalArgumentException e) {
                        System.out.println(line + " " + e.getMessage());
                    }
                } else {
                    System.out.println(line + " Invalid input format");
                }
            }
        }

        return users;
    }
}