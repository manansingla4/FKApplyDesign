import java.util.ArrayList;

public class HexTicTacToeGame {
    private int gridSize;
    private int level;
    private int rows;
    private int columns;

    private Coordinate[][] coordinates;

    public int getGridSize() {
        return gridSize;
    }

    public HexTicTacToeGame(int gridSize, int level) {
        this.gridSize = gridSize;
        this.level = level;
        this.rows = (int) Math.pow(gridSize * 2 - 1, level);
        this.columns = (int) Math.pow(4 * gridSize - 3, level);

        coordinates = new Coordinate[rows][columns];

        for (int i = 0; i < (gridSize * 2 - 1); i++) {
            for (int j = Math.abs(i - (gridSize * 2 - 1) / 2); j < (4 * gridSize - 3) - Math.abs(i - ((gridSize * 2 - 1) / 2)); j += 2) {
                coordinates[i][j] = new Coordinate(i, j);
            }
        }
    }

    public ArrayList<Coordinate> getUnmarkedCoordinates() {
        ArrayList<Coordinate> unmarkedCoordinates = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!coordinates[i][j].isMarked()) {
                    unmarkedCoordinates.add(coordinates[i][j]);
                }
            }
        }
        return unmarkedCoordinates;
    }

    public void setMarked(Coordinate coordinate, char symbol) {
        setMarked(coordinate.getX(), coordinate.getY(), symbol);
    }

    public void setMarked(int x, int y, char symbol) {
        if (!isMarked(x, y)) {
            coordinates[x][y].setMarked();
            coordinates[x][y].setSymbol(symbol);
        }
    }

    public boolean isMarked(Coordinate coordinate) {
        return isMarked(coordinate.getX(), coordinate.getY());
    }

    public boolean isMarked(int x, int y) {
        return coordinates[x][y] != null && coordinates[x][y].isMarked();
    }

    public char getSymbol(int x, int y) {
        return coordinates[x][y].getSymbol();
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public boolean isValid(Coordinate c) {
        return isValid(c.getX(), c.getY());
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < columns && coordinates[x][y] != null;
    }

    public int getLevel() {
        return level;
    }
}
