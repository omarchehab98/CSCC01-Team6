package team6.util.operators.logical;

public class OrLogicalOperator implements LogicalOperator {
    public static final String OPERATOR = "or";

    public boolean compare(boolean lhs, boolean rhs) {
        return lhs || rhs;
    }

    public String getOperator() {
        return OPERATOR;
    }
}
