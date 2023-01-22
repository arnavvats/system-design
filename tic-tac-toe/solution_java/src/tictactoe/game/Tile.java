package solution_java.src.tictactoe;

public class Tile {
    public State state = State.EMPTY;
    public enum State {
        EMPTY, CROSS, CIRCLE
    };

    public void setState(State state) {
        if(State.EMPTY.equals(state)) {
            throw new IllegalArgumentException("Cannot set to empty");
        }
        if(!this.state.equals(State.EMPTY)) {
            throw new IllegalArgumentException("Tile already set");
        }
        this.state = state;
    }
}
