package solution_java.src.tictactoe;

public class Move {
    int row;
    int col;
    Tile.State state;

    public Move(int row, int col, Tile.State state) {
        this.row = row;
        this.col = col;
        this.state = state;
    }
}
