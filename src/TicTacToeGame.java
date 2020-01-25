import java.util.ArrayList;

public class TicTacToeGame {
    private int rows;
    private int columns;

    Coordinate[][] coordinates;

    public TicTacToeGame(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        coordinates = new Coordinate[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                coordinates[i][j] = new Coordinate(i, j);
            }
        }
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
