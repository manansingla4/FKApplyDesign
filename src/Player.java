public interface Player{
    String getSymbol();

    String getName();

    Coordinate playTurn(Game game);
}
