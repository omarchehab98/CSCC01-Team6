package team6.util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SheetAdapterWrapperTest {
    @Test
    public void parseCSVTest() throws IOException {
        SheetAdapterWrapper sheetAdapterWrapper = new SheetAdapterWrapper();
        StringReader reader = new StringReader("name,age,height\nAlice,20,180");
        List<HashMap<String, String>> data = sheetAdapterWrapper.parse("csv", reader);
        HashMap<String, String> alice = data.get(0);
        assertEquals(data.size(), 1);
        assertEquals(alice.get("name"), "Alice");
        assertEquals(alice.get("age"), "20");
        assertEquals(alice.get("height"), "180");
    }

    @Test
    public void getSheetAdapterByTypeCSVTest() {
        SheetAdapterWrapper sheetAdapterWrapper = new SheetAdapterWrapper();
        String[] types = new String[]{".csv", "csv", "text/csv"};
        for (String type : types) {
            SheetAdapter sheetAdaper = sheetAdapterWrapper.getSheetAdapterByType(type);
            assertEquals(sheetAdaper.getClass(), CSVSheetAdapter.class);
        }
    }

    @Test
    public void getSheetAdapterByTypeInvalidTest() {
        SheetAdapterWrapper sheetAdapterWrapper = new SheetAdapterWrapper();
        try {
            sheetAdapterWrapper.getSheetAdapterByType(".java");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException err) {}
    }
}
