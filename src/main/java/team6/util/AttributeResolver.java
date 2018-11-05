package team6.util;

import java.lang.reflect.Field;

public class AttributeResolver {
    public static Object get(String nameFlattened, Object object) {
        try {
            if (object == null) {
                return object;
            }
            String[] names = nameFlattened.split("\\.");
            if (names.length == 1) {
                Field field = object.getClass().getDeclaredField(names[0]);
                field.setAccessible(true);
                return field.get(object);
            } else {
                Field field = object.getClass().getDeclaredField(names[0]);
                field.setAccessible(true);
                return get(nameFlattened.substring(names[0].length() + 1), field.get(object));
            }
        } catch (IllegalAccessException | NoSuchFieldException err) {
            throw new RuntimeException(err);
        }
    }
}