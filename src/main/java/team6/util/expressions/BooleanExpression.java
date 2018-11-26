package team6.util.expressions;

import javax.persistence.Entity;
import java.lang.reflect.Field;

public abstract class BooleanExpression {
    public abstract boolean isTrue();

    public abstract void populate(String symbol, Object value);

    public BooleanExpression populateWithObject(Object object, String symbolPrefix) {
        try {
            Entity entity = object.getClass().getAnnotation(Entity.class);
            boolean isEntity = entity != null;
            if (!isEntity) {
                throw new IllegalArgumentException("object must be annotated with @Entity");
            }
            for (Field attribute : object.getClass().getDeclaredFields()) {
                attribute.setAccessible(true);
                String key = attribute.getName();
                Object value = attribute.get(object);
                if (value != null) {
                    Entity valueEntity = value.getClass().getAnnotation(Entity.class);
                    boolean valueIsEntity = valueEntity != null;
                    if (valueIsEntity) {
                        this.populateWithObject(value, symbolPrefix.concat(key.concat(".")));
                    } else {
                        this.populate(symbolPrefix.concat(key), value);
                    }
                } else {
                    this.populate(symbolPrefix.concat(key), value);
                }
            }
            return this;
        } catch (IllegalAccessException err) {
            throw new RuntimeException(err.getMessage());
        }
    }

    public BooleanExpression populateWithObject(Object object) {
        return this.populateWithObject(object, "");
    }

    public abstract BooleanExpression clone();
}
