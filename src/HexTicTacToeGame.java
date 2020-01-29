public class HexTicTacToeGame implements Game {
    private int gridSize;
    private int level;
    private int rows;
    private int columns;
    private String symbol;
    private static String emptyString;

    static {
        emptyString = "";
    }

    private HexTicTacToeGame[][] subGames;

    public int getGridSize() {
        return gridSize;
    }

    public HexTicTacToeGame(int gridSize, int level) {

        if (level == 0) {
            symbol = emptyString;
            return;
        }

        this.gridSize = gridSize;
        this.level = level;
        this.rows = gridSize * 2 - 1;
        this.columns = 4 * gridSize - 3;
        this.symbol = "";

        subGames = new HexTicTacToeGame[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = Math.abs(i - rows / 2); j < columns - Math.abs(i - (rows / 2)); j += 2) {
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

    public String getSymbol(Coordinate c) {

        if (level == 0) {
            return symbol;
        }

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

        assert game1 != null;
        return game1.getSymbol(new Coordinate(x, y));
    }

    @Override
    public boolean isValid(Coordinate c) {
        int x = c.getX();
        int y = c.getY();

        if (x < 0 || x >= (int) Math.pow(rows, level) || y < 0 || y >= (int) Math.pow(columns, level)) {
            return false;
        }

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
        return !getSymbol(c).equals(emptyString);
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

    @Override
    public int getPrintableRows() {
        return (int) Math.pow(rows, level);
    }

    @Override
    public int getPrintableColumns() {
        return (int) Math.pow(columns, level);
    }
}
