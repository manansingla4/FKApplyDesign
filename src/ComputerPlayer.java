import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends BasePlayer {

    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public Coordinate playTurn(TicTacToeGame game) {
        ArrayList<Coordinate> unmarkedCoordinates = game.getUnmarkedCoordinates();
        Random random = new Random();
        return unmarkedCoordinates.get(random.nextInt(unmarkedCoordinates.size()));
    }
}
