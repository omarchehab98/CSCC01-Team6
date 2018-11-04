package team6.util.operators.logical;

public interface LogicalOperator {
    public boolean isTrue(boolean... operands);

    public String getOperator();
}
