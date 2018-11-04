package team6.util.operators.logical;

public class NotLogicalOperator implements LogicalOperator {
    public static final String OPERATOR = "not";

    public boolean isTrue(boolean... operands) {
        assert operands.length == 1;
        return !operands[0];
    }

    public String getOperator() {
        return OPERATOR;
    }
}
