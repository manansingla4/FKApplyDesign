import junit.framework.TestCase;

public class Test extends TestCase {
    public void testAdd() {
        checkValidPoint();
        checkDiagonal();
        checkRow();
        checkColumn();
    }

    void checkValidPoint() {
        Game game = new TicTacToeGame(3, 1);
        assertFalse(game.isValid(new Coordinate(-1, -1)));
        assertTrue(game.isValid(new Coordinate(1, 1)));
        assertFalse(game.isValid(new Coordinate(100, 100)));
        assertFalse(game.isValid(new Coordinate(20, 20)));
    }

    void checkDiagonal() {
        Game game = new TicTacToeGame(3, 1);
        Player player = new HumanPlayer("human", "X");
        assertFalse(game.checkWinner(player.getSymbol()));
        game.setMarked(new Coordinate(0, 0), player.getSymbol());
        game.setMarked(new Coordinate(1, 1), player.getSymbol());
        game.setMarked(new Coordinate(2, 2), player.getSymbol());
        assertTrue(game.checkWinner(player.getSymbol()));
    }

    void checkRow() {
        Game game = new TicTacToeGame(3, 1);
        Player player = new HumanPlayer("human", "X");
        assertFalse(game.checkWinner(player.getSymbol()));
        game.setMarked(new Coordinate(0, 0), player.getSymbol());
        game.setMarked(new Coordinate(0, 1), player.getSymbol());
        game.setMarked(new Coordinate(0, 2), player.getSymbol());
        assertTrue(game.checkWinner(player.getSymbol()));
    }

    void checkColumn() {
        Game game = new TicTacToeGame(3, 1);
        Player player = new HumanPlayer("human", "X");
        assertFalse(game.checkWinner(player.getSymbol()));
        game.setMarked(new Coordinate(0, 0), player.getSymbol());
        game.setMarked(new Coordinate(1, 0), player.getSymbol());
        game.setMarked(new Coordinate(2, 0), player.getSymbol());
        assertTrue(game.checkWinner(player.getSymbol()));
    }
}
