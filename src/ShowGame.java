public class ShowGame {
    public void showGame(TicTacToeGame ticTacToeGame) {
        int rows = ticTacToeGame.getRows();
        int columns = ticTacToeGame.getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (ticTacToeGame.isMarked(i, j)) {
                    System.out.print(ticTacToeGame.getSymbol(i, j) + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }


    public void showGame(Game game) {
        int gridSize = game.getGridSize();
        int level = game.getLevel();
        int rows = game.getRows();
        int columns = game.getColumns();

        int rowsToPrint = (int) Math.pow(2 * gridSize - 1, level);
        int columnsToPrint = (int) Math.pow(4 * gridSize - 3, level);

        for (int i = 0; i < rowsToPrint; i++) {
            for (int j = 0; j < columnsToPrint; j++) {
                int x = i;
                int y = j;
                int t_level = level;
                Game game1 = game;

                while (game1 != null && t_level > 1) {
                    int boardIndexX = x / (int) Math.pow(rows, t_level - 1);
                    int boardIndexY = y / (int) Math.pow(columns, t_level - 1);
                    x = x % (int) Math.pow(rows, t_level - 1);
                    y = y % (int) Math.pow(columns, t_level - 1);
                    game1 = game1.getSubGame(boardIndexX, boardIndexY);
                    t_level--;
                }

                if (game1 == null) {
                    System.out.print(" ");
                } else if (game1.getSubGame(x, y) != null) {
                    System.out.print((game1.getSymbol().equals("") ? "_" : game1.getSymbol()));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
