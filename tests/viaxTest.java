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
        Game[] games = new Game[10];
        Frame[] frames = new Frame[10];
        for (int i = 0; i < 10; i++) {
           games[i] = new Game();

           collector.checkThat("Testing that a game contains 10 frames",
                   games[i].getNrOfFrames(), equalTo(10));


           frames = games[i].getFrames();

           for (int j = 0; j < 10; j++) {
               collector.checkThat("Testing that a game contains 10 frames",
                       frames[j].getScore(), equalTo(-1));
           }



        }

    }

    @Test
    public void gameScoreTest() {
        Game game = new Game();

        int nrOfFrames = 10;
        Frame[] playedFrames = new Frame[nrOfFrames];

        // Default score = 81
        playedFrames[0] = new Frame(1, 5);
        playedFrames[1] = new Frame(3, 6);
        playedFrames[2] = new Frame(7, 2);
        playedFrames[3] = new Frame(3, 6);
        playedFrames[4] = new Frame(4, 4);
        playedFrames[5] = new Frame(5, 3);
        playedFrames[6] = new Frame(3, 3);
        playedFrames[7] = new Frame(4, 5);
        playedFrames[8] = new Frame(8, 1);
        playedFrames[9] = new Frame(2, 6);


        game.setFrames(playedFrames, nrOfFrames);

        collector.checkThat("Testing getScore for a game (should be 81)",
                game.getScore(), equalTo(81));

        playedFrames[0] = new Frame(0, 0);
        playedFrames[1] = new Frame(0, 0);
        playedFrames[2] = new Frame(0, 0);
        playedFrames[3] = new Frame(0, 0);
        playedFrames[4] = new Frame(0, 0);
        playedFrames[5] = new Frame(0, 0);
        playedFrames[6] = new Frame(0, 0);
        playedFrames[7] = new Frame(0, 0);
        playedFrames[8] = new Frame(0, 0);
        playedFrames[9] = new Frame(0, 0);

        collector.checkThat("Testing getScore for a game (should be 81)",
                game.getScore(), equalTo(81));

        for (int i = 0; i < 10; i++) {
            playedFrames[i] = new Frame();
        }


        collector.checkThat("Testing getScore for a game (should be 81)",
                game.getScore(), equalTo(81));

        playedFrames = null;

        collector.checkThat("Passing in a nullpointer to setFrames (should be false",
                game.setFrames(playedFrames, 10), equalTo(false));


    }

    @Test
    public void strikeTest() {
        Game game = new Game();
        int nrOfFrames = 10;
        Frame[] playedFrames = new Frame[nrOfFrames];

        // Default score = 81
        playedFrames[0] = new Frame(2, 6);
        playedFrames[1] = new Frame(3, 6);
        playedFrames[2] = new Frame(7, 2);
        playedFrames[3] = new Frame(3, 6);
        playedFrames[4] = new Frame(4, 4);
        playedFrames[5] = new Frame(5, 3);
        playedFrames[6] = new Frame(3, 3);
        playedFrames[7] = new Frame(4, 5);
        playedFrames[8] = new Frame(8, 1);
        playedFrames[9] = new Frame(10, 0);

        game.setFrames(playedFrames, nrOfFrames);

        collector.checkThat("Testing getScore for a game containing a strike (should be 94)",
                game.getScore(), equalTo(94));


        playedFrames[5] = new Frame(0, 10);
        game.setFrames(playedFrames, nrOfFrames);
        collector.checkThat("Testing getScore for a game containing a strike (should be 104)",
                game.getScore(), equalTo(100));




    }


    @Test
    public void spareTest() {
        Game game = new Game();
        int nrOfFrames = 10;
        Frame[] playedFrames = new Frame[nrOfFrames];

        playedFrames[0] = new Frame(2, 6);
        playedFrames[1] = new Frame(3, 6);
        playedFrames[2] = new Frame(7, 2);
        playedFrames[3] = new Frame(3, 6);
        playedFrames[4] = new Frame(4, 4);
        playedFrames[5] = new Frame(5, 3);
        playedFrames[6] = new Frame(3, 3);
        playedFrames[7] = new Frame(4, 5);
        playedFrames[8] = new Frame(8, 1);
        playedFrames[9] = new Frame(1, 9);

        game.setFrames(playedFrames, nrOfFrames);

        collector.checkThat("Testing getScore for a game containing a spare (should be 88)",
                game.getScore(), equalTo(93));


    }


    @Test
    public void strikeAndSpareTest() {
        Game game = new Game();
        int nrOfFrames = 10;
        Frame[] playedFrames = new Frame[nrOfFrames];

        playedFrames[9] = new Frame(10, 0);
        playedFrames[8] = new Frame(4, 6);
        playedFrames[7] = new Frame(7, 2);
        playedFrames[6] = new Frame(3, 6);
        playedFrames[5] = new Frame(4, 4);
        playedFrames[4] = new Frame(5, 3);
        playedFrames[3] = new Frame(3, 3);
        playedFrames[2] = new Frame(4, 5);
        playedFrames[1] = new Frame(8, 1);
        playedFrames[0] = new Frame(2, 6);

        game.setFrames(playedFrames, nrOfFrames);

        collector.checkThat("Testing getScore for a gaming containing a strike followed by a spare",
                game.getScore(), equalTo(103));




    }
    @Test
    public void mulitpleSpareTest() {
        Game game = new Game();
        int nrOfFrames = 10;
        Frame[] playedFrames = new Frame[nrOfFrames];

        playedFrames[9] = new Frame(8, 2);
        playedFrames[8] = new Frame(5, 5);
        playedFrames[7] = new Frame(7, 2);
        playedFrames[6] = new Frame(3, 6);
        playedFrames[5] = new Frame(4, 4);
        playedFrames[4] = new Frame(5, 3);
        playedFrames[3] = new Frame(3, 3);
        playedFrames[2] = new Frame(4, 5);
        playedFrames[1] = new Frame(8, 1);
        playedFrames[0] = new Frame(2, 6);

        game.setFrames(playedFrames, nrOfFrames);

        collector.checkThat("Testing getScore for a gaming containing a strike followed by a spare",
                game.getScore(), equalTo(98));


    }


    @Test
    public void spareLastFrameTest() {
        Game game = new Game();
        int nrOfFrames = 11;
        Frame[] playedFrames = new Frame[nrOfFrames];

        playedFrames[0] = new Frame(1, 5);
        playedFrames[1] = new Frame(3, 6);
        playedFrames[2] = new Frame(7, 2);
        playedFrames[3] = new Frame(3, 6);
        playedFrames[4] = new Frame(4, 4);
        playedFrames[5] = new Frame(5, 3);
        playedFrames[6] = new Frame(3, 3);
        playedFrames[7] = new Frame(4, 5);
        playedFrames[8] = new Frame(8, 1);
        playedFrames[9] = new Frame(2, 8);
        playedFrames[10] = new Frame(7, 0);

        game.setFrames(playedFrames, nrOfFrames);

        collector.checkThat("Testing getScore for a gaming containing a strike followed by a spare",
                game.getScore(), equalTo(90));

    }




}
