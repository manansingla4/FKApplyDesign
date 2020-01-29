public interface Game {
    String getSymbol(Coordinate c);

    boolean isValid(Coordinate c);

    boolean isMarked(Coordinate c);

    void setMarked(Coordinate c, String symbol);

    void unMark(Coordinate c);

    boolean isFull();

    int getPrintableRows();

    int getPrintableColumns();

    boolean checkWinner(String symbol);
}
