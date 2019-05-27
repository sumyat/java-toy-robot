import exception.InvalidCommandException;
import exception.InvalidDirectionException;
import org.junit.Test;

import java.io.FileNotFoundException;

public class ToyRobotApplicationTest {

    @Test
    public void testReadFileAndPlaySuccessfully() throws Exception {
        ToyRobotApplication.fileName = "success_commands.txt";
        String[] args = new String[1];
        ToyRobotApplication.main(args);
    }

    @Test(expected = FileNotFoundException.class)
    public void testThrowFileNotFoundException() throws Exception {
        ToyRobotApplication.fileName = "abc";
        String[] args = new String[1];
        ToyRobotApplication.main(args);
    }

    @Test(expected = InvalidDirectionException.class)
    public void testIncorrectPlaceCommand() throws Exception {
        ToyRobotApplication.fileName = "incorrect_place_command.txt";
        String[] args = new String[1];
        ToyRobotApplication.main(args);
    }

    @Test(expected = InvalidCommandException.class)
    public void testIncorrectCommand() throws Exception {
        ToyRobotApplication.fileName = "incorrect_command.txt";
        String[] args = new String[1];
        ToyRobotApplication.main(args);
    }


}