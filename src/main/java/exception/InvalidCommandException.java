package exception;

/**
 * @desc InvalidCommandException is thrown when user enters command which in not in the Command Enum.
 */
public class InvalidCommandException extends Exception {
    public InvalidCommandException() {
        super("Invalid command!");
    }

    public InvalidCommandException(String message) {
        super(message);
    }
}
