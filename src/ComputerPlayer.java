public class ComputerPlayer extends BasePlayer {

    public ComputerPlayer(String name, String symbol) {
        super(name, symbol);
    }

    public Coordinate playTurn(Game game) {
        return new Coordinate(1, 2);
    }
}
