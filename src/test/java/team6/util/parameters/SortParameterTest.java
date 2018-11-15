package team6.util.parameters;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class SortParameterTest {

	@Test
	public void testParse() {
		Sort expected = new Sort(Direction.ASC, "one","two","three");
		Sort actual = SortParameter.parse("one,two,three", "asc");
		
		assertEquals(expected, actual);
	}
}
