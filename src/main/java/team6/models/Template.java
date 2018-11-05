package team6.models;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Template {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface FriendlyName {
        public String value() default "";
    }

    /**
     * Returns a list of attribute names in the same order as `getFriendlyNames`
     * 
     * @return list of the class's friendly names
     */
    public Map<String, String> getAttributeToFriendlyNameMap() {
        Map<String, String> attributeToFriendlyNameMap = new HashMap<String, String>();
        for (Field attribute : this.getClass().getDeclaredFields()) {
            String attributeName = attribute.getName();
            FriendlyName annotation = attribute.getAnnotation(FriendlyName.class);
            String friendlyName;
            if (annotation != null) {
                friendlyName = annotation.value();
            } else {
                friendlyName = attribute.getName();
            }
            attributeToFriendlyNameMap.put(attributeName, friendlyName);
        }
        return attributeToFriendlyNameMap;
    }

    /**
     * Returns a list of attribute names in the same order as `getFriendlyNames`
     * 
     * @return list of the class's friendly names
     */
    public List<String> getAttributeNames() {
        List<String> attributeNames = new ArrayList<>();
        for (Field attribute : this.getClass().getDeclaredFields()) {
            String attributeName = attribute.getName();
            attributeNames.add(attributeName);
        }
        return attributeNames;
    }

    /**
     * Returns a list of friendly names in the same order as `getAttributeNames`
     * 
     * @return list of the class's attribute names
     */
    public List<String> getFriendlyNames() {
        List<String> friendlyNames = new ArrayList<>();
        for (Field attribute : this.getClass().getDeclaredFields()) {
            FriendlyName annotation = attribute.getAnnotation(FriendlyName.class);
            String friendlyName;
            if (annotation != null) {
                friendlyName = annotation.value();
            } else {
                friendlyName = attribute.getName();
            }
            friendlyNames.add(friendlyName);
        }
        return friendlyNames;
    }
}