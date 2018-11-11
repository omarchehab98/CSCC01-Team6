package team6.util.parameters;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import team6.util.JoinTable;

public class JoinParameter {
    public static List<JoinTable> parse(String join) {
        return parse(new JSONArray(join));
    }

    public static List<JoinTable> parse(JSONArray join) {
        List<JoinTable> result = new ArrayList<JoinTable>();
        for (int i = 0; i < join.length(); i++) {
            JSONObject obj = join.getJSONObject(i);
            JoinTable joinTable = new JoinTable(
                obj.getString("entity"),
                WhereParameter.parse(obj.getJSONObject("condition"))
            );
            result.add(joinTable);
        }
        return result;
    }
}
