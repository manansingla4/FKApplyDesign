import java.util.ArrayList;

public class TicTacToeGame {
    private int gridSize;
    private int level;
    private int rows;
    private int columns;

    private Coordinate[][] coordinates;

    public int getGridSize() {
        return gridSize;
    }

    public TicTacToeGame(int gridSize, int level) {
        this.gridSize = gridSize;
        this.level = level;
        this.rows = (int) Math.pow(gridSize, level);
        this.columns = rows;

        coordinates = new Coordinate[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
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
    
    public void setMarked(Coordinate coordinate, String symbol) {
        setMarked(coordinate.getX(), coordinate.getY(), symbol);
    }

    public void setMarked(int x, int y, String symbol) {
        if (!isMarked(x, y)) {
            coordinates[x][y].setMarked();
            coordinates[x][y].setSymbol(symbol);
        }
    }

    public boolean isMarked(Coordinate coordinate) {
        return isMarked(coordinate.getX(), coordinate.getY());
    }

    public boolean isMarked(int x, int y) {
        return coordinates[x][y].isMarked();
    }

    public String getSymbol(int x, int y) {
        return coordinates[x][y].getSymbol();
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public boolean isValid(Coordinate c) {
        int x = c.getX();
        int y = c.getY();

        return x >= 0 && x < rows && y >= 0 && y < columns;
    }

    public int getLevel() {
        return level;
    }
}
