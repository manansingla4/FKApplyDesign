import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame(3, 2);
        Play play = new Play();

        System.out.println("Welcome To TicTacToe Game");
        System.out.println("Choose between single player or two player");
        System.out.println("1) Single Player\n2) Two Player");

        int noOfPlayers = new Scanner(System.in).nextInt();
        if (noOfPlayers == 1) {
            Player[] players = {new HumanPlayer("Human", 'X'), new ComputerPlayer("Computer", 'O')};
            play.playGame(players, game);
        } else if (noOfPlayers == 2) {
            Player[] players = {new HumanPlayer("Person 1", 'X'), new HumanPlayer("Person 2", 'O')};
            play.playGame(players, game);
        }
    }
}
