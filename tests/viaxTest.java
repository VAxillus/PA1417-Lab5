import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import static org.hamcrest.Matchers.*;

public class viaxTest {

    @Rule
    public ErrorCollector collector = new ErrorCollector();


    @Test
    public void frameTest() {
        Frame[] frames =  new Frame[100];
        int[] oneTurn = new int[2];

        for (int i = 0; i < 100; i++) {
            frames[i] = new Frame();
            oneTurn = frames[i].oneTurn();

            //Check that the pointer isn't null
            //collector.checkThat("", oneTurn, notNullValue());

            for (int j = 0; j < 2; j++) {
                collector.checkThat("Testing that an individual score of a throw is <=10",
                        oneTurn[j], lessThanOrEqualTo(10));
                collector.checkThat("Testing that an individual score of a throw is >=0",
                        oneTurn[j], greaterThanOrEqualTo(0));
            }


        }
    }

    @Test
    public void frameScoreTest() {
        Frame[] frames = new Frame[100];
        int[] oneTurn = new int[2];

        for (int i = 0; i < 100; i++) {
            frames[i] = new Frame();

            collector.checkThat("Testing getScore for a frame that hasn't been played",
                    frames[i].getScore(), equalTo(-1));

            oneTurn = frames[i].oneTurn();
            collector.checkThat("Testing getScore for a frame that has been played",
                    frames[i].getScore(), equalTo(oneTurn[0] + oneTurn[1]));

        }

    }

    @Test
    public void GameTest() {
        Game[] games = new Game[100];
    }
}
