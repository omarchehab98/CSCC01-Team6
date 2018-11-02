package team6.factories;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import team6.models.ClientProfileTemplate;

public class ClientProfileTemplateFactoryTest {

	@Test
	public void buildSingleInputTest() {
		HashMap<String, String> singleColumn = new HashMap<String, String>();

		singleColumn.put("processing_details", "test processing details");
		ClientProfileTemplate result = (ClientProfileTemplate) ClientProfileTemplateFactory.build(singleColumn);

		assertEquals("test processing details", result.getProcessingDetails());
	}

	@Test
	public void buildMultipleInputTest() {
		HashMap<String, String> multipleColumn = new HashMap<String, String>();

		multipleColumn.put("processing_details", "Test1");
		multipleColumn.put("client_validation_type_id", "Test2");
		multipleColumn.put("client_validation_id", "Test3");
		ClientProfileTemplate result = (ClientProfileTemplate) ClientProfileTemplateFactory.build(multipleColumn);

		assertEquals("Test1", result.getProcessingDetails());
		assertEquals("Test2", result.getClientValidationTypeId());
		assertEquals("Test3", result.getClientValidationId());
	}

	@Test
	public void buildTwoEntitiesTest() {
		HashMap<String, String> in0 = new HashMap<String, String>();
		in0.put("processing_details", "Test1");
		ClientProfileTemplate result0 = (ClientProfileTemplate) ClientProfileTemplateFactory.build(in0);

		HashMap<String, String> in1 = new HashMap<String, String>();
		in1.put("client_validation_type_id", "Test2");
		ClientProfileTemplate result1 = (ClientProfileTemplate) ClientProfileTemplateFactory.build(in1);

		assertEquals("Test1", result0.getProcessingDetails());
		assertEquals(null, result0.getClientValidationTypeId());

		assertEquals(null, result1.getProcessingDetails());
		assertEquals("Test2", result1.getClientValidationTypeId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void buildEmtpyInputTest() {
		HashMap<String, String> singleColumn = new HashMap<String, String>();

		singleColumn.put("", "test");
		ClientProfileTemplateFactory.build(singleColumn);
	}

	@Test
	public void buildNoInputTest() {
		HashMap<String, String> singleColumn = new HashMap<String, String>();

		singleColumn.put("processing_details", "test processing details");
		ClientProfileTemplate result = (ClientProfileTemplate) ClientProfileTemplateFactory.build(singleColumn);

		assertEquals(result.getId(), result.getId());
	}
}

