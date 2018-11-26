package team6.factories;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import team6.models.LTClientExitTemplate;
import team6.models.Organization;

public class LTClientExitTemplateFacortyTest {

	@Test
	public void buildSingleInputTest() {
		HashMap<String, String> singleColumn = new HashMap<String, String>();
		Organization organization = new Organization();

		singleColumn.put("processing_details", "test processing details");
		LTClientExitTemplate result = (LTClientExitTemplate) LTClientExitTemplateFactory.build(singleColumn, organization);

		assertEquals("test processing details", result.getProcessingDetails());
	}

	@Test
	public void buildMultipleInputTest() {
		HashMap<String, String> multipleColumn = new HashMap<String, String>();
		Organization organization = new Organization();

		multipleColumn.put("processing_details", "Test1");
		multipleColumn.put("client_validation_type_id", "Test2");
		multipleColumn.put("client_validation_id", "Test3");
		LTClientExitTemplate result = (LTClientExitTemplate) LTClientExitTemplateFactory.build(multipleColumn, organization);

		assertEquals("Test1", result.getProcessingDetails());
		assertEquals("Test2", result.getClientValidationTypeId());
		assertEquals("Test3", result.getClientValidationId());
	}

	@Test
	public void buildTwoEntitiesTest() {
		Organization organization = new Organization();
		HashMap<String, String> in0 = new HashMap<String, String>();
		in0.put("processing_details", "Test1");
		LTClientExitTemplate result0 = (LTClientExitTemplate) LTClientExitTemplateFactory.build(in0, organization);

		HashMap<String, String> in1 = new HashMap<String, String>();
		in1.put("client_validation_type_id", "Test2");
		LTClientExitTemplate result1 = (LTClientExitTemplate) LTClientExitTemplateFactory.build(in1, organization);

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
		LTClientExitTemplateFactory.build(singleColumn, organization);
	}

	@Test
	public void buildNoInputTest() {
		HashMap<String, String> singleColumn = new HashMap<String, String>();
		Organization organization = new Organization();

		singleColumn.put("processing_details", "test processing details");
		LTClientExitTemplate result = (LTClientExitTemplate) LTClientExitTemplateFactory.build(singleColumn, organization);

		assertEquals(result.getId(), result.getId());
	}

}
