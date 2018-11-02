package team6.util.operators.comparison;

public interface ComparisonOperator {
    public boolean compare(Object lhs, Object rhs);

    public String getOperator();
}
