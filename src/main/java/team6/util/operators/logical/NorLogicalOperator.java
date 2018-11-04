package team6.util.operators.logical;

public class NorLogicalOperator implements LogicalOperator {
    public static final String OPERATOR = "nor";

    public boolean isTrue(boolean... operands) {
        assert operands.length == 2;
        return !operands[0] && !operands[1];
    }

    public String getOperator() {
        return OPERATOR;
    }
}
