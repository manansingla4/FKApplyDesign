public class HexTicTacToeGame implements Game {
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


    public Game getSubGame(int x, int y) {
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

    @Override
    public boolean isValid(Coordinate c) {
        int x = c.getX();
        int y = c.getY();

        int t_level = this.level;
        Game game1 = this;

        while (game1 != null && t_level > 0) {
            int boardIndexX = x / (int) Math.pow(rows, t_level - 1);
            int boardIndexY = y / (int) Math.pow(columns, t_level - 1);
            x = x % (int) Math.pow(rows, t_level - 1);
            y = y % (int) Math.pow(columns, t_level - 1);
            game1 = game1.getSubGame(boardIndexX, boardIndexY);
            t_level--;
        }

        return game1 != null;
    }

    @Override
    public boolean isMarked(Coordinate c) {
        return false;
    }

    @Override
    public void setMarked(Coordinate c, String symbol) {

    }

    @Override
    public void unMark(Coordinate c) {

    }

    @Override
    public boolean isFull() {
        return false;
    }
}
