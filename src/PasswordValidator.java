/** This program is a command-line tool for determining whether a password is a strong password.
 * 
 * @author Jaskaran Singh
 */
public class PasswordValidator {
    /**
    * Prints the text with a new line before and after the text.
    * @param text The text to print.
    */
    private static void printLnTextLn(String text) {
        System.out.println();
        System.out.println(text);
    }

    /**
    * Prints information about the specified exception and exits out of the program.
    * 
    * @param exception The exception to print information about.
    */
    public static void printExceptionInformationAndExit(Exception exception) {
        // Print information about the exception.
        System.out.println();
        exception.printStackTrace();
        // System.out.println();
        // System.out.println(exception.getMessage());
        System.out.println();

        // Exit out of the program.
        System.exit(0);
    }

    /**
     * Prints a message to the user to let them know whether their password is a secure password.
     * 
     */
    private static void printPasswordValidityMessage(boolean isPasswordValid) {
        if (isPasswordValid) {
            printLnTextLn("Your password is a valid password.");
        } else {
            printLnTextLn("Your password is not a valid password.");
        }
    }

    /**
    * Main method of this class.
    * 
    * @param args User-specified password.
    * @throws Exception
    */
    public static void main(String[] args) throws Exception {
        // Declare a variable to store the user specified password.
        String password = null;

        // Assume that the user specified the password as the first argument. Ignore any additional arguments.
        if (args.length > 0) {
            password = args[0];
        } else {
            System.out.println();
            System.out.println(
                    "No password was specified.\n" +
                            "Please rerun this program with your password as an argument.");
            System.exit(0);
        }

        // Check the password length.
        if (password.length() < 8 || password.length() > 16) {
            printPasswordValidityMessage(false);
            System.out.println(
                    "The password must have at least 8 characters and no more than 16 characters.");
            System.exit(0);
        }

        // Check if the password is a combination of at least three out of the following four categories.
        // (1) lower case letters, i.e., a-z
        // (2) upper case letters, i.e., A-Z
        // (3) numbers, i.e., 0-9
        // (4) the following special symbols: ~!@#$%^&*()-=+_
        int hasLowerCaseLetter = 0;
        int hasUpperCaseLetter = 0;
        int hasDigit = 0;
        int hasAllowedSpecialSymbol = 0;
        String allowedSpecialSymbols = "~!@#$%^&*()-=+_";
        for (int i = 0; i < password.length(); i++) {
            // Get a character from the password.
            Character character = password.charAt(i);

            // Store whether the password has a lower case letter.
            if (Character.isLowerCase(character)) {
                hasLowerCaseLetter = 1;
            }
            // Store whether the password has a upper case letter.
            else if (Character.isUpperCase(character)) {
                hasUpperCaseLetter = 1;
            }
            // Store whether the password has a numeric.
            else if (Character.isDigit(character)) {
                hasDigit = 1;
            }
            // Store whether the password has a numeric.
            else if (Character.isDigit(character)) {
                hasDigit = 1;
            }
            // Store whether the password has an allowed special symbol.
            else if (allowedSpecialSymbols.contains(character.toString())) {
                hasAllowedSpecialSymbol = 1;
            }
            // The password contains an unallowed character. 
            else {
                printPasswordValidityMessage(false);
                System.out.println(
                                "The password can only consist of characters that are lower case letters, upper case letters, digits, or any of these special characters: ~!@#$%^&*()-=+_");
            }
        }

        // Store the number of categories of characters are in the password.
        int numberOfCategoriesInPassword = hasLowerCaseLetter + hasUpperCaseLetter + hasDigit + hasAllowedSpecialSymbol;

        // If the password met at least three out of the four character categories, the password is secure.
        if (numberOfCategoriesInPassword >= 3) {
            printPasswordValidityMessage(true);
        }
        else {
            printPasswordValidityMessage(false);
            System.out.println("The password must be a combination of at least three out of the following four categories.\n" +
            "\t(1) lower case letters, i.e., a-z\n" +
            "\t(2) upper case letters, i.e., A-Z\n" +
            "\t(3) numbers, i.e., 0-9\n" +
            "\t(4) the following special symbols: ~!@#$%^&*()-=+_");
        }
    }
}
