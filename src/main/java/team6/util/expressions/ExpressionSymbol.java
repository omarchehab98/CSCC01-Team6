package team6.util.expressions;

public class ExpressionSymbol {
    private final String symbol;

    public ExpressionSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}