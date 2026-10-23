public class User {
    private String username;
    private String password;
    public User (String username, String password)
    {
        // checking if the username is valid befor assigning
        if(username!=null&& username.length()>50) //check username length
            throw new IllegalArgumentException(
                "Username is too long, try something shorter");

        int atIndex=username.indexOf("@");
        int dotIndex=username.lastIndexOf(".");
        
        if (atIndex<=0||atIndex==username.length()-1)//check if username consists of 3 parts
            throw new IllegalArgumentException(
                "Please enter a valid Email as username");
        
        if (username.indexOf('@') != username.lastIndexOf('@')) // check if there is more than one @
            throw new IllegalArgumentException(
                "Please enter a valid Email as username");

        if (dotIndex <= atIndex + 1 || dotIndex >= username.length() - 2) //make sure no less than 2 letters after the dot
            throw new IllegalArgumentException(
                "Please enter a valid Email as username");

        for (int i = dotIndex + 1; i < username.length(); i++) {//make sure tha last 2 are indeed letters

            char c = username.charAt(i);

            if (!((c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z'))) {

                throw new IllegalArgumentException(
                    "Please enter a valid Email as username"
                );
            }
        }

        for (int i = 0; i < atIndex; i++) {//make sure the first part of the email is valid
            char c = username.charAt(i);

            boolean isLetter = (c >= 'a' && c <= 'z') ||
                            (c >= 'A' && c <= 'Z');

            boolean isDigit = (c >= '0' && c <= '9');

            boolean isSpecial = c == '.' || c == '_' ||
                                c == '%' || c == '+' || c == '-';

            if (!isLetter && !isDigit && !isSpecial) {
                throw new IllegalArgumentException(
                    "Please enter a valid Email as username"
                );
            }
        }

        char firstChar = username.charAt(atIndex + 1);// make sure the first charac after the @ is a letter or a num
        boolean isLetter = (firstChar >= 'a' && firstChar <= 'z') ||
                        (firstChar >= 'A' && firstChar <= 'Z');

        boolean isDigit = (firstChar >= '0' && firstChar <= '9');
        if (!isLetter && !isDigit) {
            throw new IllegalArgumentException(
                "Please enter a valid Email as username"
            );
        }
    
        for (int i = atIndex + 1; i < dotIndex; i++) {// checking the rest of the the second part
            char c = username.charAt(i);
            isLetter = (c >= 'a' && c <= 'z') ||
                            (c >= 'A' && c <= 'Z');

            isDigit = (c >= '0' && c <= '9');

            boolean isSpecial = c == '-' || c == '.';
            if (!isLetter && !isDigit && !isSpecial) {
                throw new IllegalArgumentException(
                    "Please enter a valid Email as username"
                );
            }
        }

        this.username=username;// if the username is valid then assign

        /////////////////////////////////////////////////////////////////////////////

        //checking if the password is valid 
        if (password == null || password.length() < 8) {// check if password is too short
            throw new IllegalArgumentException(
                "Your password is too short, add more characters"
            );
        }

        if (password.length() > 12) {// check if password is too long
            throw new IllegalArgumentException(
                "Your password is too long, try a shorter one "
            );
        }

        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
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

            else{
                throw new IllegalArgumentException(
                    "Please enter a valid password"
                );
            }
        }
        // Check that all required character types exist
        if (!hasLetter || !hasDigit || !hasSpecial) {
            throw new IllegalArgumentException(
                "Please enter a valid password"
            );
        }

        this.password=password;//if the password is valid then assign




    }

    public String getName()
    {
        return username;
    }

    public String toString() {
    return username + " " + password;
    }
    
}
