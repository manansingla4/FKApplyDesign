import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer implements Player {
    private String name;
    private char symbol;

    public ComputerPlayer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public Coordinate playTurn(TicTacToeGame game) {
        ArrayList<Coordinate> unmarkedCoordinates = game.getUnmarkedCoordinates();
        Random random = new Random();
        return unmarkedCoordinates.get(random.nextInt(unmarkedCoordinates.size()));
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public String getName() {
        return name;
    }
}
