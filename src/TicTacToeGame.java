
public class TicTacToeGame implements Game {
    private int gridSize;
    private int level;
    private int rows;
    private int columns;
    private String symbol;
    private TicTacToeGame[][] subGames;

    private static String emptyString;

    static {
        emptyString = "";
    }

    public TicTacToeGame(int gridSize, int level) {

        if (level == 0) {
            symbol = emptyString;
            return;
        }

        this.gridSize = gridSize;
        this.level = level;
        this.rows = gridSize;
        this.columns = gridSize;
        this.symbol = emptyString;

        subGames = new TicTacToeGame[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                subGames[i][j] = new TicTacToeGame(gridSize, level - 1);
            }
        }
    }


    private TicTacToeGame getSubGame(int x, int y) {
        return subGames[x][y];
    }

    public String getSymbol(Coordinate c) {

        if (level == 0) {
            return symbol;
        }

        int x = c.getX();
        int y = c.getY();

        int t_level = this.level;
        TicTacToeGame game1 = this;
        // To be checked
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
        TicTacToeGame game1 = this;

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
        TicTacToeGame game1 = this;

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
        // checking right diagonal
        boolean check = true;
        for (int i = 0; i < gridSize; i++) {
            if (!getSubGame(i, i).isGameSymbol(symbol)) {
                check = false;
                break;
            }
        }

        if (check) return true;

        // checking left diagonal
        check = true;
        for (int i = 0; i < gridSize; i++) {
            if (!getSubGame(gridSize - i - 1, i).isGameSymbol(symbol)) {
                check = false;
                break;
            }
        }

        return check;
    }

    private boolean checkRows(String symbol) {
        for (int i = 0; i < rows; i++) {
            boolean check = true;
            for (int j = 0; j < columns; j++) {
                if (!getSubGame(i, j).isGameSymbol(symbol)) {
                    check = false;
                    break;
                }
            }
            if (check) return true;
        }

        return false;
    }

    private boolean checkColumns(String symbol) {
        for (int i = 0; i < rows; i++) {
            boolean check = true;
            for (int j = 0; j < columns; j++) {
                if (!getSubGame(j, i).isGameSymbol(symbol)) {
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

        return checkRows(symbol) || checkDiagonals(symbol) || checkColumns(symbol);
    }
}
