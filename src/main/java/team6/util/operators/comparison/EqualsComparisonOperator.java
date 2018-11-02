package team6.util.operators.comparison;

public class EqualsComparisonOperator implements ComparisonOperator {
    public static final String OPERATOR = "eq";

    public boolean compare(Object lhs, Object rhs) {
        // TODO: Implement lenient type checking
        // Right now, if lhs is Long and rhs is Integer and equal to same number
        // Java .equals will return false.
        return lhs.equals(rhs);
    }

    public String getOperator() {
        return OPERATOR;
    }
}
