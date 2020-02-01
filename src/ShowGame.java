public class ShowGame {
    public void showGame(Game game) {
        int rowsToPrint = game.getPrintableRows();
        int columnsToPrint = game.getPrintableColumns();

        for (int i = 0; i < rowsToPrint; i++) {
            for (int j = 0; j < columnsToPrint; j++) {

                if (game.isValid(new Coordinate(i, j))) {
                    if (game.isMarked(new Coordinate(i, j))) {
                        System.out.print(" " + game.getSymbol(new Coordinate(i, j)) + " ");
                    } else {
                        System.out.print(" _ ");
                    }
                } else {
                    System.out.print("   ");
                }

            }
            System.out.println();
        }
    }
}
