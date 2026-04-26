package LLD.SnakeLadderGame;

import java.util.*;

public class Game {
    private final Board board;
    private final Queue<Player> Players;
    private final Dice dice;
    GameStatus status;
    Player winnner;

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    Game(Builder b){
        Players = b.players;
        board = b.board;
        this.dice= b.dice;
        status = GameStatus.NOT_STARTED;
    }

    public Board getBoard() {
        return board;
    }

    public Queue<Player> getPlayers() {
        return Players;
    }

    public Dice getDice() {
        return dice;
    }

    public void play(){
        status = GameStatus.ON_GOING;
        while(status==GameStatus.ON_GOING) {
            Player P1= Players.peek();
            int current = P1.getCurrentPosition();
            int diceValue = dice.roll();
            int newPosition = (current + diceValue) <= board.getSize() ? current + diceValue : current;
            P1.setCurrentPosition(newPosition);
            if(newPosition==board.getSize()){
                status = GameStatus.FINISHED;
                winnner= P1;
                return;
            }
            board.updatePosition(P1);
            if(diceValue!=6) {
                Players.poll();
                Players.add(P1);
            }

        }
    }

    public static class Builder{
        private  Board board;
        private  Queue<Player> players;
        private  Dice dice;

        public Builder setBoard(int size, List<BoardEntity> boardEntityList) {
            this.board = new Board(size,boardEntityList);
            return this;
        }

        public Builder setPlayers(List<String> playersNameList) {
            this.players = new ArrayDeque<>();
            for (String name : playersNameList) {
                this.players.offer(new Player(name));
            }
            return this;
        }

        public Builder setDice(Dice dice) {
            this.dice = dice;
            return this;
        }

        public Game build(){
            return new Game(this);
        }
    }
}
