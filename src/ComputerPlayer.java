import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends BasePlayer {

    public ComputerPlayer(String name, String symbol) {
        super(name, symbol);
    }

    @Override
    public Coordinate playTurn(TicTacToeGame game) {
        ArrayList<Coordinate> unmarkedCoordinates = game.getUnmarkedCoordinates();
        Random random = new Random();
        return unmarkedCoordinates.get(random.nextInt(unmarkedCoordinates.size()));
    }

    public Coordinate playTurn(Game game) {
        return new Coordinate(1, 2);
    }
}
