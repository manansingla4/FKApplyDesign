import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome To TicTacToe Game");

        System.out.println("Which game you want to play ??");
        System.out.println("1) Square Grid\n2) Hexagonal Grid");
        int choice = scanner.nextInt();

        System.out.println("Enter grid size");
        int gridSize = scanner.nextInt();

        System.out.println("Enter the deep level you want to play 1, 2, 3 etc");
        int level = scanner.nextInt();

        System.out.println("Choose between single player or two player");
        System.out.println("1) Single Player\n2) Two Player");
        int noOfPlayers = scanner.nextInt();

        Play play = new Play();

        if (choice == 1) {
            TicTacToeGame game = new TicTacToeGame(gridSize, level);

            if (noOfPlayers == 1) {
                Player[] players = {new HumanPlayer("Human", 'X'), new ComputerPlayer("Computer", 'O')};
                play.playGame(players, game);
            } else if (noOfPlayers == 2) {
                Player[] players = {new HumanPlayer("Person 1", 'X'), new HumanPlayer("Person 2", 'O')};
                play.playGame(players, game);
            }
        } else {
            HexTicTacToeGame game = new HexTicTacToeGame(gridSize, level);
            if (noOfPlayers == 1) {
                Player[] players = {new HumanPlayer("Human", 'X'), new ComputerPlayer("Computer", 'O')};
                play.playGame(players, game);
            } else {
                Player[] players = {new HumanPlayer("Person 1", 'X'), new HumanPlayer("Person 2", 'O')};
                play.playGame(players, game);
            }
        }


    }
}
