import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome To TicTacToe Game");

        System.out.println("Enter the level you want to play 1, 2, 3 etc");
        int level = scanner.nextInt();
        System.out.println("Enter grid size");
        int gridSize = scanner.nextInt();
        TicTacToeGame game = new TicTacToeGame(gridSize, level);
        Play play = new Play();

        System.out.println("Choose between single player or two player");
        System.out.println("1) Single Player\n2) Two Player");
        int noOfPlayers = scanner.nextInt();
        if (noOfPlayers == 1) {
            Player[] players = {new HumanPlayer("Human", 'X'), new ComputerPlayer("Computer", 'O')};
            play.playGame(players, game);
        } else if (noOfPlayers == 2) {
            Player[] players = {new HumanPlayer("Person 1", 'X'), new HumanPlayer("Person 2", 'O')};
            play.playGame(players, game);
        }
    }
}
