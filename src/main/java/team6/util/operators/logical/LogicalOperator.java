package team6.util.operators.logical;

public interface LogicalOperator {
    public boolean compare(boolean lhs, boolean rhs);

    public String getOperator();
}
