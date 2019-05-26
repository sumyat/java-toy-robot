import exception.InvalidCommandException;
import exception.InvalidDirectionException;
import utils.FileUtils;

import java.io.File;
import java.util.Scanner;

public class ToyRobotApplication {

    public static void main(String[] args) throws Exception {
        String fileName = "input.txt";

        //Step1: Setup
        ToyRobot robot = new ToyRobot();
        Table table = new Table(0, 5);

        //Step2: Get File
        File file = FileUtils.getFileFromResources(fileName);

        //Step3: Read File
        Scanner scanner = new Scanner(file);

        int lineNumber = 1;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] arguments = line.split(" ");
            Command command;

            //Step4: Validate Command
            command = validateCommand(arguments);

            validateIsFirstCommandPlace(robot, command);
            processCommand(robot, command, table, arguments);
        }
    }

    private static void validateIsFirstCommandPlace(ToyRobot robot, Command command) throws InvalidCommandException {
        if (command != Command.PLACE) {
            if (robot.getDirection() == null) {
                throw new InvalidCommandException();
            }
        }
    }

    private static Command validateCommand(String[] arguments) throws InvalidCommandException {

        Command command;
        try {
            command = Command.valueOf(arguments[0]);
        } catch (IllegalArgumentException e) {
            throw new InvalidCommandException();
        }

        return command;
    }

    private static void processCommand(ToyRobot robot, Command command, Table table, String[] arguments) throws Exception{
        switch (command) {
            case PLACE:
                try {
                    //Validate PLACE command format
                    String[] place_params = arguments[1].split(",");
                    int position_x = Integer.parseInt(place_params[0]);
                    int position_y = Integer.parseInt(place_params[1]);
                    Direction direction = Direction.valueOf(place_params[2]);
                    robot.place(position_x, position_y, direction);
                } catch (NumberFormatException e) {
                    throw new InvalidCommandException();
                } catch (IllegalArgumentException e) {
                    throw new InvalidDirectionException();
                }
                break;
            case LEFT:
            case RIGHT:
                robot.rotate(command);
                break;
            case REPORT:
                System.out.println(report(robot));
                break;
            case MOVE:
                robot.move(table);
                break;
        }
    }

    public static String report(ToyRobot robot) {
        if (robot == null) {
            return null;
        }

        return robot.getPosition_x() + "," + robot.getPosition_y() + "," + robot.getDirection().toString();
    }
}
