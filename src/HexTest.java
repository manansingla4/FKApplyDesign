import junit.framework.TestCase;

public class HexTest extends TestCase {
    public void testAdd() {
        checkValidPoint();
        checkDiagonal();
        checkRow();
    }

    void checkValidPoint() {
        Game game = new HexTicTacToeGame(3, 1);
        assertFalse(game.isValid(new Coordinate(-1, -1)));
        assertTrue(game.isValid(new Coordinate(1, 1)));
        assertFalse(game.isValid(new Coordinate(100, 100)));
        assertFalse(game.isValid(new Coordinate(20, 20)));
        assertTrue(game.isValid(new Coordinate(0, 2)));
        assertTrue(game.isValid(new Coordinate(1, 1)));
        assertFalse(game.isValid(new Coordinate(1, -1)));
        assertTrue(game.isValid(new Coordinate(2, 0)));
    }

    void checkDiagonal() {
        Game game = new HexTicTacToeGame(3, 1);
        Player player = new HumanPlayer("human", "X");
        assertFalse(game.checkWinner(player.getSymbol()));
        game.setMarked(new Coordinate(0, 2), player.getSymbol());
        game.setMarked(new Coordinate(1, 1), player.getSymbol());
        game.setMarked(new Coordinate(2, 0), player.getSymbol());
        assertTrue(game.checkWinner(player.getSymbol()));
        game = new HexTicTacToeGame(3, 1);
        game.setMarked(new Coordinate(1, 3), player.getSymbol());
        game.setMarked(new Coordinate(2, 2), player.getSymbol());
        game.setMarked(new Coordinate(3, 1), player.getSymbol());
        game.setMarked(new Coordinate(0, 4), player.getSymbol());
        assertTrue(game.checkWinner(player.getSymbol()));
    }

    void checkRow() {
        Game game = new HexTicTacToeGame(3, 1);
        Player player = new HumanPlayer("human", "X");
        assertFalse(game.checkWinner(player.getSymbol()));
        game.setMarked(new Coordinate(0, 2), player.getSymbol());
        game.setMarked(new Coordinate(0, 4), player.getSymbol());
        game.setMarked(new Coordinate(0, 6), player.getSymbol());
        assertTrue(game.checkWinner(player.getSymbol()));
        game = new HexTicTacToeGame(3, 1);
        game.setMarked(new Coordinate(4, 2), player.getSymbol());
        game.setMarked(new Coordinate(4, 4), player.getSymbol());
        assertFalse(game.checkWinner(player.getSymbol()));
        game.setMarked(new Coordinate(4, 6), player.getSymbol());
        assertTrue(game.checkWinner(player.getSymbol()));
    }

}
