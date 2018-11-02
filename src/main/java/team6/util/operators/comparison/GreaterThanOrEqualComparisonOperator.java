package team6.util.operators.comparison;

import java.math.BigDecimal;

public class GreaterThanOrEqualComparisonOperator implements ComparisonOperator {
    public static final String OPERATOR = "gte";

    public boolean isTrue(Object lhs, Object rhs) {
        if (lhs == null && rhs == null) {
            return true;
        }
        if (lhs == null || rhs == null) {
            return false;
        }
        if (lhs instanceof Number && rhs instanceof Number) {
            BigDecimal lhsBd = new BigDecimal(((Number) lhs).doubleValue());
            BigDecimal rhsBd = new BigDecimal(((Number) rhs).doubleValue());
            int comparison = lhsBd.compareTo(rhsBd);
            return comparison == 1 || comparison == 0;
        }
        throw new IllegalArgumentException();
    }

    public String getOperator() {
        return OPERATOR;
    }
}
