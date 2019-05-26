public class ToyRobotApplication {

    public static void main(String[] args) throws Exception{
        String input = "PLACE 0,0,NORTH";
        String regex = "(PLACE) [\\d+],[\\d+],(NORTH|WEST|EAST|SOUTH)";


        //Step1: Setup
        ToyRobot robot = new ToyRobot();
        Table table = new Table(0, 5);

        //Step2: Validate
        //Step3: Process Command
        Command command = Command.PLACE;
        processCommand(robot, command, table);

        command = Command.MOVE;
        processCommand(robot, command, table);

        command = Command.REPORT;
        processCommand(robot, command, table);

        command = Command.LEFT;
        processCommand(robot, command, table);

        command = Command.REPORT;
        processCommand(robot, command, table);

        command = Command.RIGHT;
        processCommand(robot, command, table);

        command = Command.REPORT;
        processCommand(robot, command, table);

    }

    private static void processCommand(ToyRobot robot, Command command, Table table) throws Exception{
        switch (command) {
            case PLACE:
                int position_x = 0;
                int position_y = 0;
                Direction direction = Direction.NORTH;
                robot.place(position_x, position_y, direction);
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
