package team6.factories;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import team6.models.LTCourseSetupTemplate;
import team6.models.Organization;

public class LTCourseSetupTemplateFactoryTest {

	@Test
	public void buildSingleInputTest() {
		HashMap<String, String> singleColumn = new HashMap<String, String>();
		Organization organization = new Organization();

		singleColumn.put("processing_details", "test processing details");
		LTCourseSetupTemplate result = (LTCourseSetupTemplate) LTCourseSetupTemplateFactory.build(singleColumn, organization);

		assertEquals("test processing details", result.getProcessingDetails());
	}

	@Test
	public void buildMultipleInputTest() {
		HashMap<String, String> multipleColumn = new HashMap<String, String>();
		Organization organization = new Organization();

		multipleColumn.put("processing_details", "Test1");
		multipleColumn.put("course_cd", "Test2");
		multipleColumn.put("held_on_ongoing_basis_ind", "Test3");
		LTCourseSetupTemplate result = (LTCourseSetupTemplate) LTCourseSetupTemplateFactory.build(multipleColumn, organization);

		assertEquals("Test1", result.getProcessingDetails());
		assertEquals("Test2", result.getCourseCd());
		assertEquals("Test3", result.getHeldOnOngoingBasisInd());
	}

	@Test
	public void buildTwoEntitiesTest() {
		Organization organization = new Organization();
		HashMap<String, String> in0 = new HashMap<String, String>();
		in0.put("processing_details", "Test1");
		LTCourseSetupTemplate result0 = (LTCourseSetupTemplate) LTCourseSetupTemplateFactory.build(in0, organization);

		HashMap<String, String> in1 = new HashMap<String, String>();
		in1.put("held_on_ongoing_basis_ind", "Test2");
		LTCourseSetupTemplate result1 = (LTCourseSetupTemplate) LTCourseSetupTemplateFactory.build(in1, organization);

		assertEquals("Test1", result0.getProcessingDetails());
		assertEquals(null, result0.getHeldOnOngoingBasisInd());

		assertEquals(null, result1.getProcessingDetails());
		assertEquals("Test2", result1.getHeldOnOngoingBasisInd());
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
		LTCourseSetupTemplate result = (LTCourseSetupTemplate) LTCourseSetupTemplateFactory.build(singleColumn, organization);

		assertEquals(result.getId(), result.getId());
	}

}
