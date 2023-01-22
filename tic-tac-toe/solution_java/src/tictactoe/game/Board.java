package solution_java.src.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {
    private Move lastMove;
    private List<List<Tile>> tiles;
    private PrecomputedStatus status;
    
    public Board(int n) {
        this.tiles = new ArrayList<>(n);

        for(int i = 0; i < n; i++) {
            this.tiles.add(new ArrayList<>(n));
            for(int  j = 0; j < n; j++) {
                tiles.get(i).add(new Tile());
            }
        }
        
        this.status = new PrecomputedStatus(n);
    }

    public Status makeMove(Move move) {
        if(this.lastMove  != null && this.lastMove.state == move.state) {
            throw new IllegalArgumentException("Same move twice");
        }
        this.tiles.get(move.row).get(move.col).setState(move.state);
        this.lastMove = move;
        return this.status.update(move);
    }
}
