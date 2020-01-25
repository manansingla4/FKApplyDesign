import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;

public class Result {
    HashSet<Pair<Integer, Integer>> pairHashSet;

    public boolean checkWinner(TicTacToeGame game, Player player) {
        ArrayList<Coordinate> markedCoordinates = game.getMarkedCoordinates(player.getSymbol());

        pairHashSet = new HashSet<>();

        for(Coordinate coordinate : markedCoordinates) {
            pairHashSet.add(new Pair<>(coordinate.getX(), coordinate.getY()));
        }

        boolean winner = false;

        for(Coordinate coordinate : markedCoordinates) {
            int x = coordinate.getX();
            int y = coordinate.getY();

            if(checkPairHashSet(x-1, y) && checkPairHashSet(x+1, y) ||
               checkPairHashSet(x, y-1) && checkPairHashSet(x, y+1) ||
               checkPairHashSet(x-1, y-1) && checkPairHashSet(x+1, y+1) ||
               checkPairHashSet(x-1, y+1) && checkPairHashSet(x+1, y-1)) {
                winner = true;
            }
        }

        return winner;
    }

    private boolean checkPairHashSet(int x, int y) {
        return pairHashSet.contains(new Pair<>(x, y));
    }
}
