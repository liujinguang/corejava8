package interfaces.music5;

import static net.mindview.util.Print.print;

import polymorphisim.music.Note;

interface Instrument {
    int value = 5; //static final
    void play(Note n);  //automatically public
    void adjust();
}

class Wind implements Instrument {

    public void play(Note n) {
        print("Wind.play() " + n);
    }

    public void adjust() {
    }

    public String what() {
        return "Wind";
    }

}

class Percussion extends Instrument {

    @Override
    public void play(Note n) {
        print("Percussion.play() " + n);
    }

    @Override
    public void adjust() {

    }

    @Override
    public String what() {
        return "Percussion";
    }
}

class Stringed extends Instrument {

    @Override
    public void play(Note n) {
        print("Stringed.play() " + n);
    }

    @Override
    public void adjust() {

    }

    @Override
    public String what() {
        return "Percussion";
    }
}

class Brass extends Wind {
    @Override
    public void play(Note n) {
        print("Brass.play() " + n);
    }

    @Override
    public void adjust() {
        print("Brass.adjust()");
    }
}

class Woodwind extends Wind {
    @Override
    public void play(Note n) {
        print("Woodwind.play() " + n);
    }

    @Override
    public String what() {
        return "Woodwind";
    }
}

public class Music5 {

}
