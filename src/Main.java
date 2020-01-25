
public class Main {

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame(3, 3);
        ShowGame showGame = new ShowGame();
        Play play = new Play();
        Player[] players = {new HumanPlayer("Manan", 'X'), new ComputerPlayer("Computer", 'O')};
        play.playGame(players, game);
    }
}
