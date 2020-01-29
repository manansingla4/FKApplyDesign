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
        int rowsToPrint = game.getPrintableRows();
        int columnsToPrint = game.getPrintableColumns();

        for (int i = 0; i < rowsToPrint; i++) {
            for (int j = 0; j < columnsToPrint; j++) {

                if (game.isValid(new Coordinate(i, j))) {
                    if (game.isMarked(new Coordinate(i, j))) {
                        System.out.print(game.getSymbol(new Coordinate(i, j)));
                    } else {
                        System.out.print("_");
                    }
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }
}
