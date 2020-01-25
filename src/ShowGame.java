public class ShowGame {
    public void showGame(TicTacToeGame ticTacToeGame) {
        int rows = ticTacToeGame.getRows();
        int columns = ticTacToeGame.getColumns();

        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                if(ticTacToeGame.isMarked(i, j)) {
                    System.out.print(ticTacToeGame.getSymbol(i, j) + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }
}
