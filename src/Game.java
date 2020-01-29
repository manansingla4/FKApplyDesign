public interface Game {
    int getGridSize();

    Game getSubGame(int x, int y);

    int getLevel();

    int getRows();

    int getColumns();

    String getSymbol(Coordinate c);

    boolean isValid(Coordinate c);

    boolean isMarked(Coordinate c);

    void setMarked(Coordinate c, String symbol);

    void unMark(Coordinate c);

    boolean isFull();

    int getPrintableRows();

    int getPrintableColumns();
}
