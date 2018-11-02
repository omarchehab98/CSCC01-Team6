package team6.util.operators.comparison;

import java.math.BigDecimal;

public class EqualsComparisonOperator implements ComparisonOperator {
    public static final String OPERATOR = "eq";

    public boolean compare(Object lhs, Object rhs) {
        if (lhs == null && rhs == null) {
            return true;
        }
        if (lhs == null || rhs == null) {
            return false;
        }
        if (lhs instanceof Number && rhs instanceof Number) {
            BigDecimal lhsBd = new BigDecimal(((Number) lhs).doubleValue());
            BigDecimal rhsBd = new BigDecimal(((Number) rhs).doubleValue());
            return lhsBd.compareTo(rhsBd) == 0;
        }
        return lhs.equals(rhs);
    }

    public String getOperator() {
        return OPERATOR;
    }
}
