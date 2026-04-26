package LLD.SnakeLadderGame;


import java.util.Random;

public class Dice {
    int minvalue;
    int maxvalue;

    public Dice(int maxvalue, int minvalue) {
        this.maxvalue = maxvalue;
        this.minvalue = minvalue;
    }

    public int roll(){
        Random rand = new Random();
        return rand.nextInt(maxvalue-minvalue+1) + minvalue;

    }
}
