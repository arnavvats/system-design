package solution_java.src.tictactoe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrecomputedStatus {
    private int n;
    private ArrayList<PrecomputedScore> rows, cols;
    private PrecomputedScore diag, rev_diag;
    private Status status;
    private Tile.State winnerState;
    private int drawCounts;
    public PrecomputedStatus(int n) {
        this.n = n;
        this.rows = new ArrayList<>(n);
        this.cols = new ArrayList<>(n);
        this.diag = new PrecomputedScore(n);
        this.rev_diag = new PrecomputedScore(n);
        for(int i = 0; i < n; i++) {
            this.rows.add(new PrecomputedScore(n));
            this.cols.add(new PrecomputedScore(n));
        }
        this.drawCounts = 0;
    }

    public Status update(Move move) {
        Status status = computeScore(this.rows.get(move.row), move.state)
                        .higherPrecedence(computeScore(this.cols.get(move.row), move.state));
        if(move.row == move.col) {
            status = status.higherPrecedence(computeScore(diag, move.state)).higherPrecedence(computeScore(rev_diag, move.state));
        }
        return status;
    }

    private Status computeScore(PrecomputedScore score, Tile.State state) {
        Status prevStatus = score.getStatus();
        Status status = score.compute(state);
        if(prevStatus != Status.DRAW && status == Status.DRAW) {
            drawCounts++;
        }
        if(drawCounts == n+2) return Status.DRAW;
        if(status == Status.DRAW) return Status.NONE;
        return status;
    }

}
