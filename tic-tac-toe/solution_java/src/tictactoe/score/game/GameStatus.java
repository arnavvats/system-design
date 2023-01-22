package solution_java;

import solution_java.src.tictactoe.Player;
import solution_java.src.tictactoe.Status;

public class GameStatus {
    Player player1, player2, winner;
    boolean isDraw;
    public GameStatus(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void setStatus(Player player, Status status) {
        if(status == Status.DRAW) {
            isDraw = true;
        } else if(status == Status.WIN) {
            winner = player;
        } else if(status == Status.LOSE){
            winner = (player == player1) ? player2 : player1;
        }
    }

    public Status getStatus(Player player) {
        if(isDraw) return Status.DRAW;
        if(winner  == null) return Status.NONE;
        return (player == winner) ? Status.WIN : Status.LOSE;
    }

    public String toString() {
        if(isDraw) {
            return "Game Draw";
        }
        if(winner != null) {
            return "Player " + winner.id + " wins!";
        }
        return "Game ongoing";
    }

}
