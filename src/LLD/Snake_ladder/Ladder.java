package LLD.Snake_ladder;

public class Ladder extends BoardEntity{
    public Ladder(int start, int end) {
        super(start,end);
        if(start>=end){
            throw new IllegalArgumentException("wrong input for ladder");
        }
    }
}
