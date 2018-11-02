package team6.util.operators.logical;

public class LogicalOperatorFactory {
    public static LogicalOperator make(String operator) {
        switch (operator) {
            case AndLogicalOperator.OPERATOR:
                return new AndLogicalOperator();

            case OrLogicalOperator.OPERATOR:
                return new OrLogicalOperator();
        }
        throw new IllegalArgumentException();
    }
}