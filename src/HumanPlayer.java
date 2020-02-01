import java.util.Scanner;

public class HumanPlayer extends BasePlayer{
    public HumanPlayer(String name, String symbol) {
        super(name, symbol);
    }

    public Coordinate playTurn(Game game) {
        System.out.println("Choose the coordinate to be marked (x, y) : ");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int x = Integer.parseInt(input[0]) - 1;
        int y = Integer.parseInt(input[1]) - 1;
        return new Coordinate(x, y);
    }
}
