package team6.util.expressions;

import team6.throwables.SymbolicBooleanExpressionException;
import team6.util.operators.comparison.ComparisonOperator;

public class ComparisonExpression extends BooleanExpression {
    private ComparisonOperator operator;
    private Object lhs;
    private Object rhs;

    public ComparisonExpression(ComparisonOperator operator, Object lhs, Object rhs) {
        this.operator = operator;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public Object getLhs() {
        return this.lhs;
    }

    public void setLhs(Object lhs) {
        this.lhs = lhs;
    }

    public Object getRhs() {
        return this.rhs;
    }

    public void setRhs(Object rhs) {
        this.rhs = rhs;
    }

    public boolean isTrue() {
        if (lhs instanceof ExpressionSymbol) {
            throw new SymbolicBooleanExpressionException(lhs.toString());
        }

        if (rhs instanceof ExpressionSymbol) {
            throw new SymbolicBooleanExpressionException(rhs.toString());
        }

        return operator.isTrue(lhs, rhs);
    }

    public void populate(String symbol, Object value) {
        if (this.lhs instanceof ExpressionSymbol) {
            ExpressionSymbol expressionSymbol = (ExpressionSymbol) this.lhs;
            if (symbol.equals(expressionSymbol.getSymbol()) ||
                (value == null && expressionSymbol.getSymbol().startsWith(symbol + "."))) {
                this.lhs = value;
            }
        }

        if (this.rhs instanceof ExpressionSymbol) {
            ExpressionSymbol expressionSymbol = (ExpressionSymbol) this.rhs;
            if (symbol.equals(expressionSymbol.getSymbol()) ||
                (value == null && expressionSymbol.getSymbol().startsWith(symbol + "."))) {
                this.rhs = value;
            }
        }
    }
}
