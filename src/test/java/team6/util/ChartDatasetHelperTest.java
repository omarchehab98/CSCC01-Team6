package team6.util;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import team6.models.Query;

@RunWith(SpringRunner.class)
public class ChartDatasetHelperTest {

    @Test
    public void dataFromQueryTest() {
	ArrayList<Query> testList = new ArrayList<>();
	testList.add(new Query("Test1", "NARs", "select=id%2CassessmentLanguageId&group=id"));
	HashMap<String, String> result = ChartDatasetHelper.dataFromQuery(testList);
	assertEquals(result.get("select"), "id%2CassessmentLanguageId");
	assertEquals(result.get("group"), "id");
    }
}