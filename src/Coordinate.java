public class Coordinate {
    private int x;
    private int y;
    private boolean marked;
    private String symbol;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        this.marked = false;
    }

    public int getX() {
        return this.x;
    }

    public void setMarked() {
        marked = true;
    }

    public boolean isMarked() {
        return marked;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getY() {
        return y;
    }
}
