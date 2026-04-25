package LLD.Snake_ladder;
import java.util.*;

public class Board {
    private final int size;
    private final Map<Integer,Integer> snakesAndLadders;

    public Board(int size, List<BoardEntity> boardEntity) {
        this.size = size;
        snakesAndLadders = new HashMap<>();
        for(BoardEntity b :boardEntity) {
            snakesAndLadders.put(b.getStart(),b.getEnd());
        }
    }

    public int getSize() {
        return size;
    }

    public Map<Integer, Integer> getSnakesAndLadders() {
        return snakesAndLadders;
    }

    public void updatePosition(Player p1){
        if(snakesAndLadders.containsKey(p1.getCurrentPosition())){
            p1.setCurrentPosition(snakesAndLadders.get(p1.getCurrentPosition()));
        }
    }
}
