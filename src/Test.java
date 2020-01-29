
public class Test {
    public static void main(String[] args) {
        Game game = new HexTicTacToeGame(2, 1);
        System.out.println(game.isMarked(new Coordinate(1, 2)));
    }
}
