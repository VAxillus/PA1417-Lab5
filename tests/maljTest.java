import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.core.IsEqual.equalTo;

public class maljTest {
    @Rule
    public ErrorCollector collector = new ErrorCollector();
/*
    @Test
    public void multipleStrikesTest() {
        Game game = new Game();
        int nrOfFrames = 10;
        Frame[] playedFrames = new Frame[nrOfFrames];

        playedFrames[9] = new Frame(2, 6);
        playedFrames[8] = new Frame(3, 6);
        playedFrames[7] = new Frame(7, 2);
        playedFrames[6] = new Frame(3, 6);
        playedFrames[5] = new Frame(5, 3);
        playedFrames[4] = new Frame(5, 4);
        playedFrames[3] = new Frame(10, 0);
        playedFrames[2] = new Frame(10, 0);
        playedFrames[1] = new Frame(8, 0);
        playedFrames[0] = new Frame(8, 0);

        game.setFrames(playedFrames, nrOfFrames);

        collector.checkThat("Testing getScore for a game containing a strike (should be 112)",
                game.getScore(), Matchers.equalTo(112));


        // checks the frames for sequential strikes


    }
*/
}