public class HexTicTacToeGame {
    private int gridSize;
    private int level;
    private int rows;
    private int columns;
    private String symbol;

    private HexTicTacToeGame[][] subGames;

    public int getGridSize() {
        return gridSize;
    }

    public HexTicTacToeGame(int gridSize, int level) {

        if (level == 0) return;

        this.gridSize = gridSize;
        this.level = level;
        this.rows = gridSize * 2 - 1;
        this.columns = 4 * gridSize - 3;
        this.symbol = "";

        subGames = new HexTicTacToeGame[rows][columns];

        for (int i = 0; i < (gridSize * 2 - 1); i++) {
            for (int j = Math.abs(i - (gridSize * 2 - 1) / 2); j < (4 * gridSize - 3) - Math.abs(i - ((gridSize * 2 - 1) / 2)); j += 2) {
                subGames[i][j] = new HexTicTacToeGame(gridSize, level - 1);
            }
        }
    }


    public HexTicTacToeGame getSubGame(int x, int y) {
        return subGames[x][y];
    }

    public int getLevel() {
        return level;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public String getSymbol() {
        return symbol;
    }
}
