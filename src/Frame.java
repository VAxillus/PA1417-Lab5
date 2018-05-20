import java.util.Arrays;
import java.util.Random;

public class Frame {
    private int pins;
    private int[] bThrows;
    private Random random;
    private boolean played;
    private boolean strike;

    Frame() {
        this.pins = 10;
        this.bThrows = new int[2];
        this.random = new Random();
        this.played = false;
        this.strike = false;
    }

    Frame(int firstThrow, int secondThrow) {
        this.pins = 10;
        this.bThrows = new int[2];
        this.bThrows[0] = firstThrow;
        this.bThrows[1] = secondThrow;
        this.random = new Random();
        this.played = true;
        if (firstThrow == 10 || secondThrow == 10) {
            this.strike = true;
        }
    }

    Frame(Frame toCopy) {
        this.pins = toCopy.pins;
        this.bThrows = Arrays.copyOf(toCopy.bThrows, 2);
        this.random = toCopy.random;
        this.played = toCopy.played;
        this.strike = toCopy.strike;
    }

    public int[] oneTurn() {
        for (int i = 0; i < 2; i++) {
            int randomNumber = random.nextInt(this.pins + 1 );
            this.bThrows[i] = randomNumber;
            this.pins -= randomNumber;

            if (randomNumber == 10) {
                this.strike = true;
            }
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

    public boolean isStrike() {
        return this.strike;
    }
}
