package team6.util.operators.comparison;

public interface ComparisonOperator {
    public boolean isTrue(Object lhs, Object rhs);

    public String getOperator();
}
