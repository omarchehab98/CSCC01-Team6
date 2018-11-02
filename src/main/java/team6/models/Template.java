package team6.models;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;

public abstract class Template {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface FriendlyName {
        public String value() default "";
    }

    public HashMap<String, String> getAttributes() {
        HashMap<String, String> attributeList = new HashMap<>();
        for (Field attribute : this.getClass().getDeclaredFields()) {
            FriendlyName annotation = attribute.getAnnotation(FriendlyName.class);
            String friendlyName;
            if (annotation != null) {
                friendlyName = annotation.value();
            } else {
                friendlyName = attribute.getName();
            }
            String name = attribute.getName();
            attributeList.put(friendlyName, name);
        }
        return attributeList;
    }
}