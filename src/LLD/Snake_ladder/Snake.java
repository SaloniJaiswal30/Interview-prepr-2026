package LLD.Snake_ladder;

public class Snake extends BoardEntity {
    public Snake(int start, int end) {
        super(start,end);
        if(start<=end){
            throw new IllegalArgumentException("wrong input for snake");
        }
    }
}
