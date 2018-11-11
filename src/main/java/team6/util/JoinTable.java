package team6.util;

import team6.util.expressions.BooleanExpression;

public class JoinTable {
    private String entity;
    private BooleanExpression condition;

    public JoinTable(String entity, BooleanExpression condition) {
        this.entity = entity;
        this.condition = condition;
    }

    public String getEntity() {
        return this.entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public BooleanExpression getCondition() {
        return this.condition;
    }

    public void setCondition(BooleanExpression condition) {
        this.condition = condition;
    }
}
