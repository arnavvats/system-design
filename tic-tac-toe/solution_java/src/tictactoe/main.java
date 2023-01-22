package solution_java.src.tictactoe;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import solution_java.GameStatus;

public class main {
    private static Map<Integer, Game> games = new HashMap<>();
    private static Map<Integer, Player> players = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {        
        while(true) {
            try {
            System.out.println("Type 0 to create new game, 1 to make a move, 2 to get a game status, 3 to terminate");
            int in = sc.nextInt();
                switch(in) {
                    case 0:
                        createNewGame();
                        break;
                    case 1:
                        makeMove();
                        break;
                    case 2:
                        getGameStatus();
                        break;
                    case 3:
                        System.out.print("Terminating");
                        break;
                    default:
                        System.out.print("Illegal input, retry");
                        
                }
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }   
    }

    public static void createNewGame() {
        System.out.println("Enter first player id");
        int player1_id = sc.nextInt();
        System.out.println("Enter second player id");
        int player2_id = sc.nextInt();
        System.out.println("Enter board size, eg 3 for a 3x3 board");
        int n = sc.nextInt();
        if(n == 1) {
            throw new IllegalArgumentException("Wrong input, 1 is not valid size");
        }
        players.putIfAbsent(player1_id, new Player(player1_id));
        Player player1 = players.get(player1_id);
        players.putIfAbsent(player2_id, new Player(player2_id));
        Player player2 = players.get(player2_id);
        int game_id = games.values().size();
        games.put(game_id, new Game(player1, player2, n));
        System.out.println("Created Game, Id: " + game_id);

    }

    public static void makeMove() {
        System.out.println("Enter player & game id");
        int player_id = sc.nextInt();
        int game_id = sc.nextInt();
        Player player = players.get(player_id);
        if(player == null) {
            System.out.println("Illegal Player Id");
            return;
        }
        Game game = games.get(game_id);
        if(game  == null) {
            System.out.println("Illegal Game Id");
        }
        System.out.println("Enter row and column for the move");
        int row = sc.nextInt(), col = sc.nextInt();
        GameStatus status = game.makeMove(player, row, col);
        System.out.println(status.toString());
        
    }

    public static void getGameStatus() {
        System.out.println("Enter game id");
        int game_id = sc.nextInt();
        Game game = games.get(game_id);
        System.out.println(game.getStatus());
    }
}
