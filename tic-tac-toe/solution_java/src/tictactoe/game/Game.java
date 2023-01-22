package solution_java.src.tictactoe;

import java.util.Map;

import solution_java.GameStatus;

public class Game {
    Player player1;
    Player player2;
    int id;
    Board board;
    private GameStatus status;

    public Game(Player player1, Player player2, int n) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board(n);
        this.status = new GameStatus(player1, player2);
    }

    public GameStatus makeMove(Player player, int row, int col) {
        Status playerStatus = this.status.getStatus(player);
        if(playerStatus != Status.NONE) {
            throw new IllegalArgumentException("No moves allowed");
        }
        playerStatus = playerStatus.higherPrecedence(this.board.makeMove(new Move(row, col, player == player1 ? Tile.State.CIRCLE : Tile.State.CROSS)));
        this.status.setStatus(player, playerStatus);
        return this.status;
    }

    public GameStatus getStatus() {
        return status;
    }
    
}
