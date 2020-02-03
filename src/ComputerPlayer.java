import java.util.Random;

public class ComputerPlayer extends BasePlayer {

    public ComputerPlayer(String name, String symbol) {
        super(name, symbol);
    }

    public Coordinate playTurn(Game game) {
        while (true) {
            Coordinate c = getCoordinate(game);
            if (game.isValid(c) && !game.isMarked(c)) {
                return c;
            }
        }
    }

    private Coordinate getCoordinate(Game game) {
        int rows = game.getPrintableRows();
        int columns = game.getPrintableColumns();
        Random random = new Random();
        int x = random.nextInt(rows);
        int y = random.nextInt(columns);
        return new Coordinate(x, y);
    }
}
