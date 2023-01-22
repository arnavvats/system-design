package solution_java.src.tictactoe;
public class PrecomputedScore {
    private Tile.State winningCandidate;
    private int candidateCount;
    private int tileCount;
    private Status status;
    public PrecomputedScore(int tileCount) {
        this.tileCount = tileCount;
        this.status = Status.NONE;
    }

    public Status compute(Tile.State state) {
        if(this.status != status.NONE) {
            return status;
        }
        if(winningCandidate == null) {
            winningCandidate = state;
        }
        if(winningCandidate == state) {
            candidateCount++;
        } else {
            this.status = Status.DRAW;
        }
        if(candidateCount == tileCount) {
            this.status = Status.WIN;
        }

        return status;

    }

    public Status getStatus() {
        return this.status;
    }
}