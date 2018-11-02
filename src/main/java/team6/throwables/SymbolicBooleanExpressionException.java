package team6.throwables;

public class SymbolicBooleanExpressionException extends RuntimeException {
    public SymbolicBooleanExpressionException(String symbol) {
        super(String.format("cannot reduce boolean expression to boolean. Symbol %s must be populated", symbol));
    }
}