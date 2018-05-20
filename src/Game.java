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


    public int getNrOfFrames() {
        return this.nrOfFrames;
    }

    public Frame[] getFrames() {
        return this.copyFrames();
    }

}
