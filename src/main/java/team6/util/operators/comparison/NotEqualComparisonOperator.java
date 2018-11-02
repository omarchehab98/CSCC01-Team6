package team6.util.operators.comparison;

public class NotEqualComparisonOperator implements ComparisonOperator {
    public static final String OPERATOR = "ne";

    public boolean isTrue(Object lhs, Object rhs) {
        return !new EqualComparisonOperator().isTrue(lhs, rhs);
    }

    public String getOperator() {
        return OPERATOR;
    }
}
