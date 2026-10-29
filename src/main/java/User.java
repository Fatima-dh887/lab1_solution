/**
 * Represents a user with a username and password.
 * Validates the username and password before storing them.
 */
public class User {
    private String username;
    private String password;

    /**
     * Creates a user after validating the username and password.
     *
     * @param username the user's email address
     * @param password the user's password
     * @throws IllegalArgumentException if the username or password is invalid
     */
    public User(String username, String password) {
        // Check that the username is not too long.
        if (username != null && username.length() > 50)
            throw new IllegalArgumentException(
                    "Username is too long, try something shorter");

        int atIndex = username.indexOf("@");
        int dotIndex = username.lastIndexOf(".");

        // Check that the username contains a valid email structure.
        if (atIndex <= 0 || atIndex == username.length() - 1)
            throw new IllegalArgumentException(
                    "Please enter a valid Email as username");

        // Check that there is exactly one @ symbol.
        if (username.indexOf('@') != username.lastIndexOf('@'))
            throw new IllegalArgumentException(
                    "Please enter a valid Email as username");

        // Ensure that the domain suffix contains at least two letters.
        if (dotIndex <= atIndex + 1 || dotIndex >= username.length() - 2)
            throw new IllegalArgumentException(
                    "Please enter a valid Email as username");

        // Check that all characters after the last dot are letters.
        for (int i = dotIndex + 1; i < username.length(); i++) {
            char c = username.charAt(i);

            if (!((c >= 'a' && c <= 'z') ||
                    (c >= 'A' && c <= 'Z'))) {
                throw new IllegalArgumentException(
                        "Please enter a valid Email as username");
            }
        }

        // Validate the part of the email address before @.
        for (int i = 0; i < atIndex; i++) {
            char c = username.charAt(i);

            boolean isLetter = (c >= 'a' && c <= 'z') ||
                    (c >= 'A' && c <= 'Z');

            boolean isDigit = (c >= '0' && c <= '9');

            boolean isSpecial = c == '.' || c == '_' ||
                    c == '%' || c == '+' || c == '-';

            if (!isLetter && !isDigit && !isSpecial) {
                throw new IllegalArgumentException(
                        "Please enter a valid Email as username");
            }
        }

        // Ensure that the domain starts with a letter or digit.
        char firstChar = username.charAt(atIndex + 1);

        boolean isLetter = (firstChar >= 'a' && firstChar <= 'z') ||
                (firstChar >= 'A' && firstChar <= 'Z');

        boolean isDigit = (firstChar >= '0' && firstChar <= '9');

        if (!isLetter && !isDigit) {
            throw new IllegalArgumentException(
                    "Please enter a valid Email as username");
        }

        // Validate the remaining characters of the email domain.
        for (int i = atIndex + 1; i < dotIndex; i++) {
            char c = username.charAt(i);

            isLetter = (c >= 'a' && c <= 'z') ||
                    (c >= 'A' && c <= 'Z');

            isDigit = (c >= '0' && c <= '9');

            boolean isSpecial = c == '-' || c == '.';

            if (!isLetter && !isDigit && !isSpecial) {
                throw new IllegalArgumentException(
                        "Please enter a valid Email as username");
            }
        }

        // Store the username after it passes validation.
        this.username = username;

        // Check that the password is not too short.
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException(
                    "Your password is too short, add more characters");
        }

        // Check that the password is not too long.
        if (password.length() > 12) {
            throw new IllegalArgumentException(
                    "Your password is too long, try a shorter one ");
        }

        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // Check the characters and required character types in the password.
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if ((c >= 'a' && c <= 'z') ||
                    (c >= 'A' && c <= 'Z')) {
                hasLetter = true;
            }
            else if (c >= '0' && c <= '9') {
                hasDigit = true;
            }
            else if (c == '!' || c == '@' || c == '^' ||
                    (c >= '#' && c <= '+')) {
                hasSpecial = true;
            }
            else {
                throw new IllegalArgumentException(
                        "Please enter a valid password");
            }
        }

        // Ensure that the password contains all required character types.
        if (!hasLetter || !hasDigit || !hasSpecial) {
            throw new IllegalArgumentException(
                    "Please enter a valid password");
        }

        // Store the password after it passes validation.
        this.password = password;
    }

    /**
     * Returns the username.
     *
     * @return the user's username
     */
    public String getName() {
        return username;
    }

    /**
     * Returns the password.
     *
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the username and password as a single string.
     *
     * @return the username followed by the password
     */
    @Override
    public String toString() {
        return username + " " + password;
    }
}