import exception.InvalidDirectionException;
import exception.InvalidPositionException;

public class ToyRobot {
    private int position_x;
    private int position_y;
    private Direction direction;

    public ToyRobot() {
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

    private void movePositionX(int position_x) {
        this.position_x = position_x + this.position_x;
    }

    private void movePositionY(int position_y) {
        this.position_y = position_y + this.position_y;
    }

    /**
     * @desc Move the robot to one unit either position_x or position_y.
     * @param squareTable which Robot moves around.
     * @throws InvalidPositionException if Robot moves to the outside the squareTable.
     * @throws InvalidDirectionException if Robot direction is DIRECTION.NONE.
     * */
    public void move(SquareTable squareTable) throws Exception {

        switch (direction) {
            case NORTH:
                if(position_y < squareTable.getHigher_edge() - 1) {
                    movePositionY(1);
                } else {
                    throw new InvalidPositionException();
                }
                break;
            case EAST:
                if(position_x < squareTable.getHigher_edge() - 1) {
                    movePositionX(1);
                } else {
                    throw new InvalidPositionException();
                }
                break;
            case SOUTH:
                if(position_y > squareTable.getLower_edge()) {
                    movePositionY(-1);
                } else {
                    throw new InvalidPositionException();
                }
                break;
            case WEST:
                if(position_x > squareTable.getLower_edge()) {
                    movePositionX(-1);
                } else {
                    throw new InvalidPositionException();
                }
                break;
            default:
                throw new InvalidDirectionException();

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
                throw new InvalidDirectionException();
        }
    }


}
