package team6.util.operators.logical;

public class AndLogicalOperator implements LogicalOperator {
    public static final String OPERATOR = "and";
    
    public boolean compare(boolean lhs, boolean rhs) {
        return lhs && rhs;
    }

    public String getOperator() {
        return OPERATOR;
    }
}
