import org.junit.Test;

public class ToyRobotTest {

    @Test
    public void testDefaultRobotPosition() throws Exception {

    }

    @Test
    public void testMoveToNorth() throws Exception {
    }

    @Test
    public void testMoveToInvalidNorth() throws Exception {
        //Should throws InvalidPositionException
    }

    @Test
    public void testMoveToEast() throws Exception {
    }

    @Test
    public void testMoveToInvalidEast() throws Exception {
        //Should throws InvalidPositionException
    }

    @Test
    public void testMoveToSouth() throws Exception {
    }

    @Test
    public void testMoveToInvalidSouth() throws Exception {
        //Should throws InvalidPositionException
    }

    @Test
    public void testMoveToWest() throws Exception {
    }

    @Test
    public void testMoveToInvalidWest() throws Exception {
        //Should throws InvalidPositionException
    }

    @Test
    public void testMoveToNone() throws Exception {
        //Should throws InvalidDirectionException
    }

    @Test
    public void testNorthRotateLeftRight() throws Exception {
        //Should not change direction
    }

    @Test
    public void testEastRotateLeftRight() throws Exception {
        //Should not change direction
    }

    @Test
    public void testSouthRotateLeftRight() throws Exception {
        //Should not change direction
    }

    @Test
    public void testWestRotateLeftRight() throws Exception {
        //Should not change direction
    }
}