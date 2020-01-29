public class Result {
    public boolean checkWinner(TicTacToeGame game, Player player) {
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
            game = game1;
        }
        winner = checkWinnerFirstLevel(game, player);
        return winner;
    }

    private boolean checkWinnerFirstLevel(TicTacToeGame game, Player player) {
        boolean winner = false;

        if (checkRow(game, player) || checkColumn(game, player) || checkDiagonal(game, player)) {
            winner = true;
        }
        return winner;
    }

    private boolean checkRow(TicTacToeGame game, Player player) {
        int gridSize = game.getRows();
        String symbol = player.getSymbol();

        for (int i = 0; i < gridSize; i++) {
            boolean b = true;
            for (int j = 0; j < gridSize; j++) {
                if (!game.isMarked(i, j) || !game.getSymbol(i, j).equals(symbol)) {
                    b = false;
                }
            }
            if (b) return b;
        }
        return false;
    }

    private boolean checkColumn(TicTacToeGame game, Player player) {
        int gridSize = game.getRows();
        String symbol = player.getSymbol();

        for (int i = 0; i < gridSize; i++) {
            boolean b = true;
            for (int j = 0; j < gridSize; j++) {
                if (!game.isMarked(j, i) || !game.getSymbol(j, i).equals(symbol)) {
                    b = false;
                }
            }
            if (b) return b;
        }
        return false;
    }

    private boolean checkDiagonal(TicTacToeGame game, Player player) {
        int gridSize = game.getRows();
        String symbol = player.getSymbol();

        boolean b = true;
        for (int i = 0; i < gridSize; i++) {
            if (!game.isMarked(i, i) || !game.getSymbol(i, i).equals(symbol)) {
                b = false;
            }
        }
        if (b) return b;

        b = true;
        for (int i = 0; i < gridSize; i++) {
            int j = gridSize - i - 1;
            if (!game.isMarked(i, i) || !game.getSymbol(i, i).equals(symbol)) {
                b = false;
            }
        }
        return b;
    }
}
