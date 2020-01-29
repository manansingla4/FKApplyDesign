public interface Player{
    String getSymbol();

    String getName();

    Coordinate playTurn(TicTacToeGame game);

    Coordinate playTurn(Game game);
}
