public class ToyRobot {
    private int position_x;
    private int position_y;
    private Direction direction;

    public ToyRobot() {
        setDefault();
    }

    public void place(int position_x, int position_y, Direction direction) {
        this.position_x = position_x;
        this.position_y = position_y;
        this.direction = direction;
    }

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private void setDefault() {
        position_x = 0;
        position_y = 0;
        direction = Direction.NONE;
    }

    /**
     * @desc Move the robot to one unit either position_x or position_y.
     * @param table which Robot moves around.
     * @throws InvalidPositionException if Robot moves to the outside the table.
     * @throws InvalidDirectionException if Robot direction is DIRECTION.NONE.
     * */
    public void move(Table table) throws Exception {
        switch (direction) {
            case NORTH:
                if(position_y < table.getHigher_edge() - 2) {
                    position_y++;
                } else {
                    throw new InvalidPositionException("Robot is on the edge!");
                }
                break;
            case EAST:
                if(position_x < table.getHigher_edge() - 2) {
                    position_x++;
                } else {
                    throw new InvalidPositionException("Robot is on the edge!");
                }
                break;
            case SOUTH:
                if(position_y > table.getLower_edge()) {
                    position_y--;
                } else {
                    throw new InvalidPositionException("Robot is on the edge!");
                }
                break;
            case WEST:
                if(position_x > table.getLower_edge()) {
                    position_x--;
                } else {
                    throw new InvalidPositionException("Robot is on the edge!");
                }
                break;
            default:
                throw new InvalidDirectionException("Invalid Orientation");

        }
    }

    /**
    * @desc Rotate the robot to 90 degree according to the direction.
    * @param command Robot LEFT or RIGHT
    * */
    public void rotate(Command command) throws Exception {
        switch (direction) {
            case NORTH:
                direction = command.isLeft(command) ? Direction.WEST : Direction.EAST;
                break;
            case EAST:
                direction = command.isLeft(command) ? Direction.NORTH : Direction.SOUTH;
                break;
            case SOUTH:
                direction = command.isLeft(command) ? Direction.EAST : Direction.WEST;
                break;
            case WEST:
                direction = command.isLeft(command) ? Direction.SOUTH : Direction.NORTH;
                break;
            default:
                throw new InvalidDirectionException("Invalid Orientation");
        }
    }


}
