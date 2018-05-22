public class Game {
    int nrOfFrames;
    Frame[] frames;

    Game() {this.nrOfFrames = -1; this.frames = null;};
    Game(int[][] frames, int nrOfFrames) { this.setFrames(frames, nrOfFrames); };


    private Frame[] createFrames(int[][] frames, int nrOfFrames) {
        Frame[] temp = new Frame[nrOfFrames];
        for (int i = 0; i < nrOfFrames; i++) {
            if (i <= 9) {
                temp[i] = new Frame(frames[i][0], frames[i][1]);
            } else {
                temp[i] = new Frame(frames[i][0]);
            }
        }

        return temp;
    }

    private boolean isBonusThrow(int frame) {
        boolean bonus = false;
        if ((frame == (9)) && (this.frames[frame].isSpare() || this.frames[frame].isStrike())) {
           bonus = true;
        }
        return bonus;
    }

    private int calculateStrikeScore(int frame) {
        if (this.frames[frame + 1].isStrike()) {
            return this.frames[frame].getScore() + this.frames[frame + 1].getExtraPoints() + this.frames[frame + 2].getScore();
        }
        return this.frames[frame].getScore() + this.frames[frame + 1].getScore();
    }

    private int calculateSpareScore(int frame) {
        return this.frames[frame].getScore() + this.frames[frame + 1].getExtraPoints();
    }


    private int calculateBonusScore(int frame) {
        return this.frames[frame].getScore() + this.frames[frame + 1].getScore();
    }




    private int calculateScore(int frame) {
        if (isBonusThrow(frame)) {
           return this.calculateBonusScore(frame);
        }
        if (frame == (this.nrOfFrames - 1)) {
            return this.frames[frame].getScore();
        }
        if (this.frames[frame].isStrike()) {
            return this.calculateStrikeScore(frame) + this.calculateScore(++frame);

        } else if (this.frames[frame].isSpare()) {
            return this.calculateSpareScore(frame) + this.calculateScore(++frame);
        }

        return this.frames[frame].getScore() + this.calculateScore(++frame);
    }


    public boolean setFrames(int[][] frames, int nrOfFrames) {
       boolean returnVal = false;
        if (nrOfFrames > 0 && nrOfFrames <= 12 && frames != null) {
            this.frames = null;
            this.frames = this.createFrames(frames, nrOfFrames);
            this.nrOfFrames = nrOfFrames;

       }
       return returnVal;
    }


    public int getNrOfFrames() {
        return this.nrOfFrames;
    }


    public int getScore() {
        return this.calculateScore(0);
    }

}
