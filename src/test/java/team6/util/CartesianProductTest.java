package team6.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CartesianProductTest {

	@Test
	public void testEvaluateTwoLists() {
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();

		list1.add("entry1 list1");
		list1.add("entry2 list1");

		list2.add("entry1 list2");
		list2.add("entry2 list2");

		ArrayList<List<String>> expected = new ArrayList<List<String>>();
		ArrayList<String> expected1 = new ArrayList<String>();
		ArrayList<String> expected2 = new ArrayList<String>();
		ArrayList<String> expected3 = new ArrayList<String>();
		ArrayList<String> expected4 = new ArrayList<String>();

		expected1.add("entry1 list1");
		expected1.add("entry1 list2");
		expected2.add("entry1 list1");
		expected2.add("entry2 list2");
		expected3.add("entry2 list1");
		expected3.add("entry1 list2");
		expected4.add("entry2 list1");
		expected4.add("entry2 list2");

		expected.add(expected1);
		expected.add(expected2);
		expected.add(expected3);
		expected.add(expected4);

		assertEquals(expected, CartesianProduct.evaluate(list1, list2));
	}

	@Test
	public void testEvaluateListOfLists() {
		ArrayList<List<String>> actual = new ArrayList<List<String>>();
		ArrayList<String> actual1 = new ArrayList<String>();
		ArrayList<String> actual2 = new ArrayList<String>();
		
		actual1.add("entry1 list1");
		actual1.add("entry1 list2");
		actual2.add("entry1 list1");
		actual2.add("entry2 list2");

		actual.add(actual1);
		actual.add(actual2);

		ArrayList<List<String>> expected = new ArrayList<List<String>>();
		ArrayList<String> expected1 = new ArrayList<String>();
		ArrayList<String> expected2 = new ArrayList<String>();
		ArrayList<String> expected3 = new ArrayList<String>();
		ArrayList<String> expected4 = new ArrayList<String>();

		expected1.add("entry1 list1");
		expected1.add("entry1 list1");
		expected2.add("entry1 list1");
		expected2.add("entry2 list2");
		expected3.add("entry1 list2");
		expected3.add("entry1 list1");
		expected4.add("entry1 list2");
		expected4.add("entry2 list2");

		expected.add(expected1);
		expected.add(expected2);
		expected.add(expected3);
		expected.add(expected4);

		// System.out.println(CartesianProduct.evaluate(actual));

		assertEquals(expected, CartesianProduct.evaluate(actual));
	}
}
