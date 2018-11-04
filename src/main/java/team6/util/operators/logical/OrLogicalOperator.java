package team6.util.operators.logical;

public class OrLogicalOperator implements LogicalOperator {
    public static final String OPERATOR = "or";

    public boolean isTrue(boolean... operands) {
        assert operands.length == 2;
        return operands[0] || operands[1];
    }

    public String getOperator() {
        return OPERATOR;
    }
}
