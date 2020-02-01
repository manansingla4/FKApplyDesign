public class HexTicTacToeGame implements Game {
    private int gridSize;
    private int level;
    private int rows;
    private int columns;
    private String symbol;
    private HexTicTacToeGame[][] subGames;

    private final static String emptyString;

    static {
        emptyString = "";
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
        this.symbol = emptyString;

        subGames = new HexTicTacToeGame[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = Math.abs(i - rows / 2); j < columns - Math.abs(i - (rows / 2)); j += 2) {
                subGames[i][j] = new HexTicTacToeGame(gridSize, level - 1);
            }
        }
    }


    private HexTicTacToeGame getSubGame(int x, int y) {
        return subGames[x][y];
    }

    public String getSymbol(Coordinate c) {

        if (level == 0) {
            return symbol;
        }

        int x = c.getX();
        int y = c.getY();

        int t_level = this.level;
        HexTicTacToeGame game1 = this;

        while (game1 != null && t_level > 0) {
            int boardIndexX = x / (int) Math.pow(rows, t_level - 1);
            int boardIndexY = y / (int) Math.pow(columns, t_level - 1);
            x = x % (int) Math.pow(rows, t_level - 1);
            y = y % (int) Math.pow(columns, t_level - 1);
            game1 = game1.getSubGame(boardIndexX, boardIndexY);
            t_level--;
        }


        if (game1 != null) {
            return game1.getSymbol(c);
        }
        return null;
    }

    @Override
    public boolean isValid(Coordinate c) {
        int x = c.getX();
        int y = c.getY();

        if (x < 0 || x >= getPrintableRows() || y < 0 || y >= getPrintableColumns()) {
            return false;
        }

        int t_level = this.level;
        HexTicTacToeGame game1 = this;

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

        if (level == 0) {
            this.symbol = symbol;
            return;
        }

        int x = c.getX();
        int y = c.getY();

        int t_level = this.level;
        HexTicTacToeGame game1 = this;

        while (game1 != null && t_level > 0) {
            int boardIndexX = x / (int) Math.pow(rows, t_level - 1);
            int boardIndexY = y / (int) Math.pow(columns, t_level - 1);
            x = x % (int) Math.pow(rows, t_level - 1);
            y = y % (int) Math.pow(columns, t_level - 1);
            game1 = game1.getSubGame(boardIndexX, boardIndexY);
            t_level--;
        }

        if (game1 != null) {
            game1.setMarked(new Coordinate(x, y), symbol);
        }
    }

    @Override
    public boolean isFull() {
        for (int i = 0; i < getPrintableRows(); i++) {
            for (int j = 0; j < getPrintableColumns(); j++) {
                Coordinate c = new Coordinate(i, j);
                if (isValid(c) && !isMarked(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int getPrintableRows() {
        return (int) Math.pow(rows, level);
    }

    @Override
    public int getPrintableColumns() {
        return (int) Math.pow(columns, level);
    }

    @Override
    public boolean checkWinner(String symbol) {
        return isGameSymbol(symbol);
    }

    private boolean checkDiagonals(String symbol) {

        Game tempGame = new HexTicTacToeGame(gridSize, 1);

        // checking right diagonals
        for (int j = rows / 2; j < columns - rows / 2; j += 2) {
            boolean check = true;

            for (int i = 0, k = j; tempGame.isValid(new Coordinate(i, k)); i++, k++) {
                if (!getSubGame(i, k).isGameSymbol(symbol)) {
                    check = false;
                    break;
                }
            }

            if (check) return true;
        }

        for (int i = 1; i <= rows / 2; i++) {
            int j = Math.abs(i - rows / 2);
            boolean check = true;
            for (int k = i; tempGame.isValid(new Coordinate(k, j)); k++, j++) {
                if (!getSubGame(k, j).isGameSymbol(symbol)) {
                    check = false;
                    break;
                }
            }
            if (check) return true;
        }


        // checking left diagonals
        for (int j = rows / 2; j < columns - rows / 2; j += 2) {
            boolean check = true;

            for (int i = 0, k = j; tempGame.isValid(new Coordinate(i, k)); i++, k--) {
                if (!getSubGame(i, k).isGameSymbol(symbol)) {
                    check = false;
                    break;
                }
            }

            if (check) return true;
        }

        for (int i = 1; i <= rows / 2; i++) {
            int j = columns - Math.abs(i - (rows / 2)) - 1;
            boolean check = true;
            for (int k = i; tempGame.isValid(new Coordinate(k, j)); k++, j--) {
                if (!getSubGame(k, j).isGameSymbol(symbol)) {
                    check = false;
                    break;
                }
            }
            if (check) return true;
        }

        return false;
    }

    private boolean checkRows(String symbol) {
        for (int i = 0; i < rows; i++) {
            boolean check = true;

            for (int j = Math.abs(i - rows / 2); j < columns - Math.abs(i - (rows / 2)); j += 2) {
                if (!getSubGame(i, j).isGameSymbol(symbol)) {
                    check = false;
                    break;
                }
            }

            if (check) return true;
        }

        return false;
    }

    private boolean isGameSymbol(String symbol) {
        if (level == 0) {
            return this.symbol.equals(symbol);
        }

        return checkRows(symbol) || checkDiagonals(symbol);
    }
}
