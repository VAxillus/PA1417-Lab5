import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import static org.hamcrest.Matchers.*;

public class viaxTest {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void frameTest() {
        Frame frame = new Frame(2, 4);

        collector.checkThat("Testing getscore for frame [2,4]",
                frame.getScore(), equalTo(6));
    }

    @Test
    public void frameScoreTest() {
        Frame frame1 = new Frame(2, 6);
        Frame frame2 = new Frame(0, 9);
        Frame frame3 = new Frame(4, 4);
        Frame frame4 = new Frame(3, 4);

        collector.checkThat("Testing getScore for frame [2, 6]",
                frame1.getScore(), equalTo(8));


        collector.checkThat("Testing getScore for frame [0, 9]",
                frame2.getScore(), equalTo(9));

        collector.checkThat("Testing getScore for frame [4, 4] (should be 8)",
                frame3.getScore(), equalTo(8));

        collector.checkThat("Testing getScore for frame [3, 4] (should be 7)",
                frame4.getScore(), equalTo(7));

        }

    @Test
    public void GameTest() {
      Game game = new Game();
      int[][] defaultFrames = {{1, 5}, {3, 6}, {7, 2}, {3, 6}, {4, 4}, {5, 3}, {3, 3}, {4, 5}, {8, 1}, {2, 6}};

      game.setFrames(defaultFrames, 10, 0);
      collector.checkThat("Testing getNrOfFrames for a game (should be 10)",
              game.getNrOfFrames(), equalTo(10));

      int[][] emptyFrames = {{}};
      collector.checkThat("Testing setFrames for an empty frame (should be false)",
              game.setFrames(emptyFrames, 0, 0), equalTo(false));


    }
    @Test
    public void gameScoreTest() {
        Game game = new Game();
        //Default score = 81
        int[][] defaultFrames = {{1, 5}, {3, 6}, {7, 2}, {3, 6}, {4, 4}, {5, 3}, {3, 3}, {4, 5}, {8, 1}, {2, 6}};
        int nrOfFrames = 10;


        game.setFrames(defaultFrames, nrOfFrames, 0);
        collector.checkThat("Testing getScore for a game (should be 81)",
                game.getScore(), equalTo(81));

        defaultFrames = null;
        collector.checkThat("Passing in a nullpointer to setFrames (should be false)",
                game.setFrames(defaultFrames, 10, 0), equalTo(false));


    }
    @Test
    public void strikeTest() {
        int[][] defaultFrames = {{10, 0}, {3, 6}, {7, 2}, {3, 6}, {4, 4}, {5, 3}, {3, 3}, {4, 5}, {8, 1}, {2, 6}};
        int nrOfFrames = 10;
        Game game = new Game(defaultFrames, nrOfFrames);

        collector.checkThat("Testing getScore for a game containing a strike (should be 94)",
                game.getScore(), equalTo(94));

    }

    @Test
    public void spareTest() {
        int[][] defaultFrames = {{1, 9}, {3, 6}, {7, 2}, {3, 6}, {4, 4}, {5, 3}, {3, 3}, {4, 5}, {8, 1}, {2, 6}};
        int nrOfFrames = 10;
        Game game = new Game(defaultFrames, nrOfFrames);

        collector.checkThat("Testing getScore for a game containing a spare (should be 88)",
                game.getScore(), equalTo(88));


    }

    @Test
    public void strikeAndSpareTest() {
        int[][] defaultFrames = {{10, 0}, {4, 6}, {7, 2}, {3, 6}, {4, 4}, {5, 3}, {3, 3}, {4, 5}, {8, 1}, {2, 6}};
        int nrOfFrames = 10;
        Game game = new Game(defaultFrames, nrOfFrames);

        collector.checkThat("Testing getScore for a game containing a strike followed by a spare (should be 103)",
                game.getScore(), equalTo(103));
    }

    @Test
    public void mulitpleSpareTest() {
        int[][] defaultFrames = {{8, 2}, {5, 5}, {7, 2}, {3, 6}, {4, 4}, {5, 3}, {3, 3}, {4, 5}, {8, 1}, {2, 6}};
        int nrOfFrames = 10;
        Game game = new Game(defaultFrames, nrOfFrames);

        collector.checkThat("Testing getScore for a game containing multiple spares (should be 98)",
                game.getScore(), equalTo(98));

    }

    @Test
    public void spareLastFrameTest() {
        int[][] defaultFrames = {{1, 5}, {3, 6}, {7, 2}, {3, 6}, {4, 4}, {5, 3}, {3, 3}, {4, 5}, {8, 1}, {2, 8}, {7}};
        int nrOfFrames = 11;
        Game game = new Game();
        game.setFrames(defaultFrames, nrOfFrames, 1);


        collector.checkThat("Testing getScore for a game containing a spare in the last frame + a bonus throw (should be 90)",
                game.getScore(), equalTo(90));

    }

    @Test
    public void multipleStrikesTest() {
    int[][] defaultFrames = {{10, 0}, {10, 0}, {7, 2}, {3, 6}, {4, 4}, {5, 3}, {3, 3}, {4, 5}, {8, 1}, {2, 6}};
    int nrOfFrames = 10;
    Game game = new Game(defaultFrames, nrOfFrames);

    collector.checkThat("Testing getScore for a game containing a multiple strike (should be 112)",
            game.getScore(), equalTo(112));
    }


    @Test
    public void lastFrameStrikeTest() {
    int[][] defaultFrames = {{1, 5}, {3, 6}, {7, 2}, {3, 6}, {4, 4}, {5, 3}, {3, 3}, {4, 5}, {8, 1}, {10, 0}, {7, 2}};
    int nrOfFrames = 11;
    Game game = new Game();
    game.setFrames(defaultFrames, nrOfFrames, 2);

    collector.checkThat("Testing getScore for a game containing a multiple strike (should be 92)",
            game.getScore(), equalTo(92));
    }

    @Test
    public void bonusStrikeTest() {

    int[][] defaultFrames = {{1, 5}, {3, 6}, {7, 2}, {3, 6}, {4, 4}, {5, 3}, {3, 3}, {4, 5}, {8, 1}, {2, 8}, {10, 0}};
    int nrOfFrames = 11;
    Game game = new Game();
    game.setFrames(defaultFrames, nrOfFrames, 1);

    collector.checkThat("Testing getScore for a game containing a bonus strike at the last frame (should be 93)",
            game.getScore(), equalTo(93));
    }


    @Test
    public void perfectGameTest() {

    int[][] defaultFrames = {{10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 10}};
    int nrOfFrames = 11;
    Game game = new Game();
    game.setFrames(defaultFrames, nrOfFrames, 2);

    collector.checkThat("Testing for a game with perfect score (should be 300)",
            game.getScore(), equalTo(300));
    }

    @Test
    public void realGameTest() {

    int[][] defaultFrames = {{6, 3}, {7, 1}, {8, 2}, {7, 2}, {10, 0}, {6, 2}, {7, 3}, {10, 0}, {8, 0}, {7, 3}, {10}};
    int nrOfFrames = 11;
    Game game = new Game();
    game.setFrames(defaultFrames, nrOfFrames, 1);

    collector.checkThat("Testing for a real game (should be 135)",
            game.getScore(), equalTo(135));
    }


}
