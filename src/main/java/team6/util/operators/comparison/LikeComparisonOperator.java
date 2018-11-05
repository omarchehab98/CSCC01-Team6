package team6.util.operators.comparison;

public class LikeComparisonOperator implements ComparisonOperator {
    public static final String OPERATOR = "like";

    public boolean isTrue(Object lhs, Object regex) {
        if (regex == null) {
            throw new IllegalArgumentException("regex cannot be null");
        }
        if (lhs == null) {
            return false;
        }
        if (lhs instanceof String && regex instanceof String) {
            String lhsStr = (String) lhs;
            String regexStr = (String) regex;
            return lhsStr.matches(regexStr);
        } else {
            throw new IllegalArgumentException("lhs and regex must be instances of String");
        }
    }

    public String getOperator() {
        return OPERATOR;
    }
}
