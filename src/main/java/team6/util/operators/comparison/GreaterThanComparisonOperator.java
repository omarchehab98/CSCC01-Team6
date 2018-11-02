package team6.util.operators.comparison;

import java.math.BigDecimal;

public class GreaterThanComparisonOperator implements ComparisonOperator {
    public static final String OPERATOR = "gt";

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
            return lhsBd.compareTo(rhsBd) == 1;
        }
        throw new IllegalArgumentException();
    }

    public String getOperator() {
        return OPERATOR;
    }
}
