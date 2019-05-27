import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class CommandTest {

    @Test
    public void testIsLeft() throws Exception {
        assertThat(Command.LEFT.isLeft(Command.LEFT)).isTrue();
        assertThat(Command.LEFT.isLeft(Command.RIGHT)).isFalse();
        assertThat(Command.LEFT.isLeft(Command.MOVE)).isFalse();
        assertThat(Command.LEFT.isLeft(Command.PLACE)).isFalse();
        assertThat(Command.LEFT.isLeft(Command.REPORT)).isFalse();
    }
}