package exception;

/**
 * @desc InvalidPositionException is thrown when Robot moves outside the border of the table.
 */
public class InvalidPositionException extends Exception {
    public InvalidPositionException() {
        super("Robot is on the edge!");
    }
}
