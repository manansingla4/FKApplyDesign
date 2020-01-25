
public class Main {

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame(3, 3);
        Play play = new Play();

        Player[] players = {new HumanPlayer("Human", 'X'), new ComputerPlayer("Computer", 'O')};

        play.playGame(players, game);
    }
}
