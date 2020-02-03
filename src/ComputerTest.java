import junit.framework.TestCase;

public class ComputerTest extends TestCase {
    public void testAdd() {
        Player player = new ComputerPlayer("Computer", "X");
        Game game = new TicTacToeGame(3, 1);
        assertTrue(game.isValid(player.playTurn(game)));
        assertTrue(game.isValid(player.playTurn(game)));
        assertTrue(game.isValid(player.playTurn(game)));
        assertTrue(game.isValid(player.playTurn(game)));
        assertTrue(game.isValid(player.playTurn(game)));
        assertTrue(game.isValid(player.playTurn(game)));
        assertTrue(game.isValid(player.playTurn(game)));
        assertTrue(game.isValid(player.playTurn(game)));
        assertTrue(game.isValid(player.playTurn(game)));
        assertTrue(game.isValid(player.playTurn(game)));
        assertTrue(game.isValid(player.playTurn(game)));
    }
}
