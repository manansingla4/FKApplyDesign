import java.util.HashMap;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private String name;
    private char symbol;

    public HumanPlayer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public Coordinate playTurn(TicTacToeGame game) {
        System.out.println("Choose the coordinate to be marked (x, y) : ");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int x = Integer.parseInt(input[0]) - 1;
        int y = Integer.parseInt(input[1]) - 1;
        return new Coordinate(x, y);
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public String getName() {
        return name;
    }
}
