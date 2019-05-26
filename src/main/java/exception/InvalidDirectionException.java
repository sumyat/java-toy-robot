package exception;

/**
 * @desc InvalidDirectionException is thrown when Direction.NONE is used.
 */
public class InvalidDirectionException extends Exception {
    public InvalidDirectionException() {
        super("Invalid Direction!");
    }
}
