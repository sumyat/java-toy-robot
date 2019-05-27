import exception.InvalidCommandException;
import exception.InvalidDirectionException;
import exception.InvalidPositionException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class GameTest {
    SquareTable table = new SquareTable(0, 5);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = InvalidCommandException.class)
    public void testIncorrectCommand() throws Exception {
        Game game = new Game(table);
        game.play("abc def");
    }

    @Test(expected = InvalidCommandException.class)
    public void testFirstCommandIsNotPlace() throws Exception {
        Game game = new Game(table);
        game.play("MOVE");
    }

    @Test(expected = InvalidCommandException.class)
    public void testPlaceCommandNotNumber() throws Exception {
        Game game = new Game(table);
        game.play("PLACE def,hik,NORTH");
    }

    @Test(expected = InvalidDirectionException.class)
    public void testPlaceCommandInvalidDirection() throws Exception {
        Game game = new Game(table);
        game.play("PLACE 0,0,TADA");
    }

    @Test
    public void testSuccessfulPlaceCommand() throws Exception {
        Game game = new Game(table);
        game.play("PLACE 0,0,NORTH");
    }

    @Test
    public void testLeftCommand() throws Exception {
        Game game = new Game(table);
        game.play("PLACE 0,0,NORTH");
        game.play("LEFT");
        assertThat(game.robot.getDirection()).isEqualTo(Direction.WEST);

        game.play("LEFT");
        assertThat(game.robot.getDirection()).isEqualTo(Direction.SOUTH);

        game.play("LEFT");
        assertThat(game.robot.getDirection()).isEqualTo(Direction.EAST);

        game.play("LEFT");
        assertThat(game.robot.getDirection()).isEqualTo(Direction.NORTH);

    }

    @Test
    public void testRightCommand() throws Exception {
        Game game = new Game(table);
        game.play("PLACE 0,0,NORTH");
        game.play("RIGHT");
        assertThat(game.robot.getDirection()).isEqualTo(Direction.EAST);

        game.play("RIGHT");
        assertThat(game.robot.getDirection()).isEqualTo(Direction.SOUTH);

        game.play("RIGHT");
        assertThat(game.robot.getDirection()).isEqualTo(Direction.WEST);

        game.play("RIGHT");
        assertThat(game.robot.getDirection()).isEqualTo(Direction.NORTH);

    }

    @Test
    public void testReport() throws Exception {
        Game game = new Game(table);
        ToyRobot robot = new ToyRobot();
        robot.place(3, 4, Direction.NORTH);
        assertThat(game.report(robot)).isEqualTo("3,4,NORTH");
    }

    @Test
    public void testMoveCommand() throws Exception {
        Game game = new Game(table);
        game.play("PLACE 4,4,NORTH");

        assertThatExceptionOfType(InvalidPositionException.class)
                .isThrownBy(() -> game.play("MOVE"));

        game.play("PLACE 4,4,EAST");
        assertThatExceptionOfType(InvalidPositionException.class)
                .isThrownBy(() -> game.play("MOVE"));

        game.play("PLACE 0,0,WEST");
        assertThatExceptionOfType(InvalidPositionException.class)
                .isThrownBy(() -> game.play("MOVE"));

        game.play("PLACE 0,0,SOUTH");
        assertThatExceptionOfType(InvalidPositionException.class)
                .isThrownBy(() -> game.play("MOVE"));

        game.play("PLACE 0,0,EAST");
        game.play("MOVE");
        assertThat(game.robot.getPosition_x()).isEqualTo(1);
        assertThat(game.robot.getPosition_y()).isEqualTo(0);
    }
}