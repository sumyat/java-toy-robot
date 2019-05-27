import exception.InvalidCommandException;
import exception.InvalidDirectionException;

public class Game {

    ToyRobot robot;
    SquareTable squareTable;

    public Game(SquareTable squareTable) {
        this.robot =  new ToyRobot();
        this.squareTable = squareTable;
    }

    public void play(String line) throws Exception {
        String[] arguments = line.split(" ");
        Command command = validateCommand(arguments);

        validateIsFirstCommandPlace(robot, command);
        processCommand(robot, command, squareTable, arguments);
    }

    private void validateIsFirstCommandPlace(ToyRobot robot, Command command) throws InvalidCommandException {
        if (command != Command.PLACE) {
            if (robot.getDirection() == null) {
                throw new InvalidCommandException();
            }
        }
    }

    private Command validateCommand(String[] arguments) throws InvalidCommandException {

        Command command;
        try {
            command = Command.valueOf(arguments[0]);
        } catch (IllegalArgumentException e) {
            throw new InvalidCommandException();
        }

        return command;
    }

    private void processCommand(ToyRobot robot, Command command, SquareTable squareTable, String[] arguments) throws Exception{
        switch (command) {
            case PLACE:
                processPlaceCommand(robot, arguments[1]);
                break;
            case LEFT:
            case RIGHT:
                robot.rotate(command);
                break;
            case REPORT:
                System.out.println(report(robot));
                break;
            case MOVE:
                robot.move(squareTable);
                break;
        }
    }

    private void processPlaceCommand(ToyRobot robot, String argument) throws InvalidCommandException, InvalidDirectionException {
        try {
            //Validate PLACE command format
            String[] place_params = argument.split(",");
            int position_x = Integer.parseInt(place_params[0]);
            int position_y = Integer.parseInt(place_params[1]);
            Direction direction = Direction.valueOf(place_params[2]);
            robot.place(position_x, position_y, direction);
        } catch (NumberFormatException e) {
            throw new InvalidCommandException();
        } catch (IllegalArgumentException e) {
            throw new InvalidDirectionException();
        }
    }

    public String report(ToyRobot robot) {
        if (robot == null) {
            return null;
        }

        return robot.getPosition_x() + "," + robot.getPosition_y() + "," + robot.getDirection().toString();
    }
}
