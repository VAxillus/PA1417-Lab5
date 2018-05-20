import java.util.Arrays;
import java.util.Random;

public class Frame {
    private int pins;
    private int[] bThrows;
    private Random random;
    private boolean played;

    Frame() {
        this.pins = 10;
        this.bThrows = new int[2];
        this.random = new Random();
    }

    public int[] oneTurn() {
        for (int i = 0; i < 2; i++) {
            int randomNumber = random.nextInt(this.pins + 1 );
            this.bThrows[i] = randomNumber;
            this.pins -= randomNumber;
        }
        int[] returnArr = Arrays.copyOf(bThrows, 2);
        this.played = true;
        return returnArr;
    }

    public int getScore() {
        int returnVal = -1;
        if (this.played) {
            returnVal = (this.bThrows[0] + this.bThrows[1]);
        }
       return returnVal;
    }
}
