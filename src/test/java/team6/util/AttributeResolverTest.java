package team6.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import team6.models.Organization;

public class AttributeResolverTest {

	@Test
	public void testGetNullObject() {
		assertEquals(null, AttributeResolver.get("name", null));
	}

	@Test(expected = RuntimeException.class)
	public void testGetException() {
		AttributeResolver.get("nameFlattened", new Object());
	}

	@Test
	public void testGet() {
		Organization organization = new Organization();
		organization.setName("name");
		assertEquals("name", AttributeResolver.get("name", organization));
	}
}
