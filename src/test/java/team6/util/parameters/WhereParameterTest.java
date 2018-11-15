package team6.util.parameters;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;

public class WhereParameterTest {

	@Test(expected = IllegalArgumentException.class)
	public void testParse() {
		JSONObject object = new JSONObject();
		System.out.println(WhereParameter.parse(object));
	}
}
