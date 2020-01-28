import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame(3, 2);
        Play play = new Play();

        System.out.println("Welcome To TicTacToe Game");
        System.out.println("Choose between single player or two player");

        Player[] players = {new HumanPlayer("Person 1", 'X'), new HumanPlayer("Person 2", 'O')};


        for (int i = 0; i < 9; i++) {
            game.setMarked(0, i, 'X');
        }

        new ShowGame().showGame(game);

        System.out.println(checkWinner(game, new HumanPlayer("sxde", 'X')));

        System.out.println(game.isMarked(0, 4));


    }


    static HashSet<Pair<Integer, Integer>> pairHashSet;

    public static boolean checkWinner(TicTacToeGame game, Player player) {
        int level = game.getLevel();
        int gridSize = game.getGridSize();
        boolean winner;
        while (game.getLevel() > 1) {
            TicTacToeGame game1 = new TicTacToeGame(gridSize, level - 1);

            for (int i = 0; i < game1.getRows(); i++) {
                for (int j = 0; j < game1.getColumns(); j++) {

                    TicTacToeGame unit_game = new TicTacToeGame(gridSize, 1);

                    for (int k = i * gridSize; k < i * gridSize + 3; k++) {
                        for (int l = j * gridSize; l < j * gridSize + 3; l++) {
                            if (i == 0 && j == 1) {
                                System.out.println(k + " " + l);
                            }
                            if (game.isMarked(k, l)) {
                                unit_game.setMarked(k - i * gridSize, l - j * gridSize, game.getSymbol(k, l));
                            }
                        }
                    }


                    winner = checkWinnerFirstLevel(unit_game, player);
                    if (winner) {
                        game1.setMarked(i, j, player.getSymbol());
                    }
                }
            }
            new ShowGame().showGame(game1);
            game = game1;
        }
        winner = checkWinnerFirstLevel(game, player);
        return winner;
    }

    private static boolean checkWinnerFirstLevel(TicTacToeGame game, Player player) {
        boolean winner = false;

        ArrayList<Coordinate> markedCoordinates = game.getMarkedCoordinates(player.getSymbol());

        pairHashSet = new HashSet<>();

        for (Coordinate coordinate : markedCoordinates) {
            pairHashSet.add(new Pair<>(coordinate.getX(), coordinate.getY()));
        }

        for (Coordinate coordinate : markedCoordinates) {
            int x = coordinate.getX();
            int y = coordinate.getY();

            if (checkPairHashSet(x - 1, y) && checkPairHashSet(x + 1, y) ||
                    checkPairHashSet(x, y - 1) && checkPairHashSet(x, y + 1) ||
                    checkPairHashSet(x - 1, y - 1) && checkPairHashSet(x + 1, y + 1) ||
                    checkPairHashSet(x - 1, y + 1) && checkPairHashSet(x + 1, y - 1)) {
                winner = true;
            }
        }
        return winner;
    }

    private static boolean checkPairHashSet(int x, int y) {
        return pairHashSet.contains(new Pair<>(x, y));
    }
}
