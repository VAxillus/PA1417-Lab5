public class Frame {
    private int[] bThrows;
    private boolean played;
    private boolean strike;
    private boolean spare;

    Frame() {
        this.bThrows = new int[2];
        this.played = false;
        this.strike = false;
        this.spare = false;
    }
    Frame(int bonusThrow) {
        this.bThrows = new int[2];
        this.bThrows[0] = bonusThrow;
        this.bThrows[1] = 0;
        this.played = true;
        this.strike = false;
        this.spare = false;
        if (bonusThrow == 10) {
            this.strike = true;
        }

    }

    Frame(int firstThrow, int secondThrow) {
        this.bThrows = new int[2];
        this.bThrows[0] = firstThrow;
        this.bThrows[1] = secondThrow;
        this.played = true;
        this.strike = false;
        this.spare = false;
        if (firstThrow == 10) {
            this.strike = true;
        } else if ((firstThrow + secondThrow == 10) && (this.strike == false)) {
            this.spare = true;
        }
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

    public boolean isSpare() {
        return this.spare;
    }


    public int getExtraPoints() {
        return this.bThrows[0];
    }
}
