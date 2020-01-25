public abstract class BasePlayer implements Player {

    private String name;
    private char symbol;

    public BasePlayer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public String getName() {
        return name;
    }
}
