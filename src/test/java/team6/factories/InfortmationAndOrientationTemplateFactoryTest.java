package team6.factories;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import team6.models.InformationAndOrientationTemplate;
import team6.models.Organization;

public class InfortmationAndOrientationTemplateFactoryTest {

	@Test
	public void buildSingleInputTest() {
		HashMap<String, String> singleColumn = new HashMap<String, String>();
		Organization organization = new Organization();

		singleColumn.put("processing_details", "test processing details");
		InformationAndOrientationTemplate result = (InformationAndOrientationTemplate) InformationAndOrientationTemplateFactory.build(singleColumn, organization);

		assertEquals("test processing details", result.getProcessingDetails());
	}

	@Test
	public void buildMultipleInputTest() {
		HashMap<String, String> multipleColumn = new HashMap<String, String>();
		Organization organization = new Organization();

		multipleColumn.put("processing_details", "Test1");
		multipleColumn.put("orientation_length_hours_no", "Test2");
		multipleColumn.put("orientation_length_minutes_no", "Test3");
		InformationAndOrientationTemplate result = (InformationAndOrientationTemplate) InformationAndOrientationTemplateFactory.build(multipleColumn, organization);

		assertEquals("Test1", result.getProcessingDetails());
		assertEquals("Test2", result.getOrientationLengthHoursNo());
		assertEquals("Test3", result.getOrientationLengthMinutesNo());
	}

	@Test
	public void buildTwoEntitiesTest() {
		Organization organization = new Organization();
		HashMap<String, String> in0 = new HashMap<String, String>();
		in0.put("processing_details", "Test1");
		InformationAndOrientationTemplate result0 = (InformationAndOrientationTemplate) InformationAndOrientationTemplateFactory.build(in0, organization);

		HashMap<String, String> in1 = new HashMap<String, String>();
		in1.put("orientation_length_hours_no", "Test2");
		InformationAndOrientationTemplate result1 = (InformationAndOrientationTemplate) InformationAndOrientationTemplateFactory.build(in1, organization);

		assertEquals("Test1", result0.getProcessingDetails());
		assertEquals(null, result0.getOrientationLengthHoursNo());

		assertEquals(null, result1.getProcessingDetails());
		assertEquals("Test2", result1.getOrientationLengthHoursNo());
	}

	@Test(expected = IllegalArgumentException.class)
	public void buildEmtpyInputTest() {
		HashMap<String, String> singleColumn = new HashMap<String, String>();
		Organization organization = new Organization();

		singleColumn.put("", "test");
		InformationAndOrientationTemplateFactory.build(singleColumn, organization);
	}

	@Test
	public void buildNoInputTest() {
		HashMap<String, String> singleColumn = new HashMap<String, String>();
		Organization organization = new Organization();

		singleColumn.put("processing_details", "test processing details");
		InformationAndOrientationTemplate result = (InformationAndOrientationTemplate) InformationAndOrientationTemplateFactory.build(singleColumn, organization);

		assertEquals(result.getId(), result.getId());
	}
}
