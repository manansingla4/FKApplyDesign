public class ShowGame {
    public void showGame(TicTacToeGame game) {
        int rows = game.getRows();
        int columns = game.getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (game.isMarked(i, j)) {
                    System.out.print(game.getSymbol(i, j) + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    public void showGame(HexTicTacToeGame game) {
        int rows = game.getRows();
        int columns = game.getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!game.isValid(i, j)) {
                    System.out.print(" ");
                } else if (game.isMarked(i, j)) {
                    System.out.print(game.getSymbol(i, j) + " ");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }
}
