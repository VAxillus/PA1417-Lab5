public class Game {
    int nrOfFrames;
    Frame[] frames;
    Game() {
        this.nrOfFrames = 10;
        this.frames = new Frame[this.nrOfFrames];
        for (int i = 0; i < 10; i++) {
            this.frames[i] = new Frame();
        }
    }

    private Frame[] copyFrames() {
        Frame[] temp = new Frame[this.nrOfFrames];

        for (int i = 0; i < this.nrOfFrames; i++) {
            temp[i] = new Frame(this.frames[i]);
        }

        return temp;
    }
    private Frame[] copyFrames(Frame[] frames, int nrOfFrames) {
        Frame[] temp = new Frame[nrOfFrames];

        for (int i = 0; i < nrOfFrames; i++) {
            temp[i] = new Frame(frames[i]);
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
            return this.frames[frame].getScore() + this.frames[frame + 1].getExtraPoints() +
                    this.frames[frame + 2].getScore();

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


    public boolean setFrames(Frame[] frames, int nrOfFrames) {
       boolean returnVal = false;
        if (nrOfFrames > 0 && nrOfFrames <= 12 && frames != null) {
            this.frames = null;
            this.frames = this.copyFrames(frames, nrOfFrames);
            this.nrOfFrames = nrOfFrames;

       }
       return returnVal;
    }


    public int getNrOfFrames() {
        return this.nrOfFrames;
    }

    public Frame[] getFrames() {
        return this.copyFrames();
    }

    public int getScore() {
        return this.calculateScore(0);
    }

}
