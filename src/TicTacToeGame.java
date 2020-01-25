import java.util.ArrayList;

public class TicTacToeGame {
    private int rows;
    private int columns;

    Coordinate[][] coordinates;

    public TicTacToeGame(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        coordinates = new Coordinate[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                coordinates[i][j] = new Coordinate(i, j);
            }
        }
    }

    public ArrayList<Coordinate> getUnmarkedCoordinates() {
        ArrayList<Coordinate> markedCoordinates = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!coordinates[i][j].isMarked()) {
                    markedCoordinates.add(coordinates[i][j]);
                }
            }
        }
        return markedCoordinates;
    }

    public ArrayList<Coordinate> getMarkedCoordinates(char symbol) {
        ArrayList<Coordinate> markedCoordinates = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (coordinates[i][j].isMarked() && coordinates[i][j].getSymbol() == symbol) {
                    markedCoordinates.add(coordinates[i][j]);
                }
            }
        }
        return markedCoordinates;
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
        return coordinates[x][y].isMarked();
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
}
