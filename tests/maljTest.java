import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.core.IsEqual.equalTo;

public class maljTest {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void multipleStrikesTest() {
        int[][] defaultFrames = {{8, 0}, {8, 0}, {10, 0}, {10, 0}, {5, 4}, {5, 3}, {3, 6}, {7, 2}, {3, 6}, {2, 6}};
        int nrOfFrames = 10;
        Game game = new Game(defaultFrames, nrOfFrames);

        collector.checkThat("Testing getScore for a game containing a multiple strike (should be 112)",
                game.getScore(), Matchers.equalTo(112));
    }
    @Test
    public void lastFrameStrikeTest() {
        int[][] defaultFrames = {{8, 0}, {8, 0}, {10, 0}, {10, 0}, {5, 4}, {5, 3}, {3, 6}, {7, 2}, {3, 6}, {10, 0}, {4}, {4}};
        int nrOfFrames = 12;
        Game game = new Game(defaultFrames, nrOfFrames);

        collector.checkThat("Testing getScore for a game containing a strike at the last frame (should be 122)",
                game.getScore(), Matchers.equalTo(122));
    }

}