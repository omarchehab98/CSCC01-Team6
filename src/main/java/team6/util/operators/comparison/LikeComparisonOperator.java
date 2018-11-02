package team6.util.operators.comparison;

public class LikeComparisonOperator implements ComparisonOperator {
    public static final String OPERATOR = "like";

    public boolean isTrue(Object lhs, Object rhs) {
        if (lhs instanceof String && rhs instanceof String) {
            String lhsStr = (String) lhs;
            String rhsStr = (String) rhs;
            return lhsStr.matches(rhsStr);
        }
        throw new IllegalArgumentException();
    }

    public String getOperator() {
        return OPERATOR;
    }
}
