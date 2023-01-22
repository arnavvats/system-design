package solution_java.src.tictactoe;

public enum Status {
    DRAW, LOSE, WIN, NONE;

    public Status higherPrecedence(Status status) {
        if(this == DRAW || status == DRAW) {
            return DRAW;
        }
        if(this == NONE) return status;
        if(status == NONE) return this;
        if(this != status) {
            throw new IllegalArgumentException("Conflicting states");
        }
        return this;
    }
}
