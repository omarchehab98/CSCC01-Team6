package team6.util.operators.comparison;

public class ComparisonOperatorFactory {
    public static ComparisonOperator make(String operator) {
        switch (operator) {
            case EqualsComparisonOperator.OPERATOR:
                return new EqualsComparisonOperator();

            case LikeComparisonOperator.OPERATOR:
                return new LikeComparisonOperator();
        }
        throw new IllegalArgumentException();
    }
}