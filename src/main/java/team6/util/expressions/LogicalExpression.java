package team6.util.expressions;

import team6.util.operators.logical.LogicalOperator;

public class LogicalExpression implements BooleanExpression {
    private LogicalOperator operator;
    private BooleanExpression lhs;
    private BooleanExpression rhs;

    public LogicalExpression(LogicalOperator operator, BooleanExpression lhs, BooleanExpression rhs) {
        this.operator = operator;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public boolean isTrue() {
        return operator.compare(lhs.isTrue(), rhs.isTrue());
    }

    public void populate(String symbol, Object value) {
        this.lhs.populate(symbol, value);
        this.rhs.populate(symbol, value);
    }
}
