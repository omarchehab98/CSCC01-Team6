package team6.util.expressions;

public interface BooleanExpression {
    public boolean isTrue();

    public void populate(String symbol, Object value);
}
