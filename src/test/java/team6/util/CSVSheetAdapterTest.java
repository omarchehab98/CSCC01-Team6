package team6.util;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CSVSheetAdapterTest {
    @Test
    public void parseCSVCleanTest() throws Exception {
        CSVSheetAdapter sheetAdapter = new CSVSheetAdapter();
        StringReader reader = new StringReader("name,age,height\nAlice,20,180\nBob,21,150");
        List<HashMap<String, String>> data = sheetAdapter.parse(reader);
        HashMap<String, String> alice = data.get(0);
        HashMap<String, String> bob = data.get(1);
        assertEquals(data.size(), 2);
        assertEquals(alice.get("name"), "Alice");
        assertEquals(alice.get("age"), "20");
        assertEquals(alice.get("height"), "180");
        assertEquals(bob.get("name"), "Bob");
        assertEquals(bob.get("age"), "21");
        assertEquals(bob.get("height"), "150");
    }
    
    @Test
    public void parseCSVExtraEmptyRowsTest() throws Exception {
        CSVSheetAdapter sheetAdapter = new CSVSheetAdapter();
        StringReader reader = new StringReader("name,age,height\nAlice,20,180\n,,\n,,\n,,");
        List<HashMap<String, String>> data = sheetAdapter.parse(reader);
        HashMap<String, String> alice = data.get(0);
        assertEquals(data.size(), 1);
        assertEquals(alice.get("name"), "Alice");
        assertEquals(alice.get("age"), "20");
        assertEquals(alice.get("height"), "180");
    }
    
    @Test
    public void parseCSVExtraEmptyColumnsTest() throws Exception {
        CSVSheetAdapter sheetAdapter = new CSVSheetAdapter();
        StringReader reader = new StringReader("name,age,height,,,\nAlice,20,180,,,\n,,,,,\n,,,,,\n,,,,,");
        List<HashMap<String, String>> data = sheetAdapter.parse(reader);
        HashMap<String, String> alice = data.get(0);
        assertEquals(data.size(), 1);
        assertEquals(alice.size(), 3);
        assertEquals(alice.get("name"), "Alice");
        assertEquals(alice.get("age"), "20");
        assertEquals(alice.get("height"), "180");
    }
}
