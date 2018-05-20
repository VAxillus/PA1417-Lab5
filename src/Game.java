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



    private int calculateScore(int frame) {
        if (frame == 0) {
            return this.frames[frame].getScore();
        }
        return this.frames[frame].getScore() + this.calculateScore(--frame);
    }


    public boolean setFrames(Frame[] frames, int nrOfFrames) {
       boolean returnVal = false;
        if (nrOfFrames > 0 && nrOfFrames <= 10 && frames != null) {
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
        return this.calculateScore(this.nrOfFrames - 1);
    }

}
