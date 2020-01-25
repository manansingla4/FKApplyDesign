public interface Player{
    char getSymbol();
    String getName();
    Coordinate playTurn(TicTacToeGame game);
}
