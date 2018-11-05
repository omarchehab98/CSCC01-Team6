package team6.factories;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import team6.models.NARsTemplate;
import team6.models.Organization;

public class NARsTemplateFactoryTest {

	@Test
	public void buildSingleInputTest() {
		HashMap<String, String> singleColumn = new HashMap<String, String>();
		Organization organization = new Organization();

		singleColumn.put("processing_details", "test processing details");
		NARsTemplate result = (NARsTemplate) NARsTemplateFactory.build(singleColumn, organization);

		assertEquals("test processing details", result.getProcessingDetails());
	}

	@Test
	public void buildMultipleInputTest() {
		HashMap<String, String> multipleColumn = new HashMap<String, String>();
		Organization organization = new Organization();

		multipleColumn.put("processing_details", "Test1");
		multipleColumn.put("update_record_id", "Test2");
		multipleColumn.put("client_validation_type_id", "Test3");
		NARsTemplate result = (NARsTemplate) NARsTemplateFactory.build(multipleColumn, organization);

		assertEquals("Test1", result.getProcessingDetails());
		assertEquals("Test2", result.getUpdateRecordId());
		assertEquals("Test3", result.getClientValidationTypeId());
	}

	@Test
	public void buildTwoEntitiesTest() {
		HashMap<String, String> in0 = new HashMap<String, String>();
		Organization organization = new Organization();

		in0.put("processing_details", "Test1");
		NARsTemplate result0 = (NARsTemplate) NARsTemplateFactory.build(in0, organization);

		HashMap<String, String> in1 = new HashMap<String, String>();
		in1.put("client_validation_type_id", "Test2");
		NARsTemplate result1 = (NARsTemplate) NARsTemplateFactory.build(in1, organization);

		assertEquals("Test1", result0.getProcessingDetails());
		assertEquals(null, result0.getClientValidationTypeId());

		assertEquals(null, result1.getProcessingDetails());
		assertEquals("Test2", result1.getClientValidationTypeId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void buildEmtpyInputTest() {
		HashMap<String, String> singleColumn = new HashMap<String, String>();
		Organization organization = new Organization();

		singleColumn.put("", "test");
		NARsTemplateFactory.build(singleColumn, organization);
	}

	@Test
	public void buildNoInputTest() {
		HashMap<String, String> singleColumn = new HashMap<String, String>();
		Organization organization = new Organization();

		singleColumn.put("processing_details", "test processing details");
		NARsTemplate result = (NARsTemplate) NARsTemplateFactory.build(singleColumn, organization);

		assertEquals(result.getId(), result.getId());
	}
}
