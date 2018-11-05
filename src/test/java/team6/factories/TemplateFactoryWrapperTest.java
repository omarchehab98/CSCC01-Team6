package team6.factories;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import team6.models.NARsTemplate;
import team6.models.Organization;
import team6.models.ClientProfileTemplate;
import team6.throwables.IllegalTemplateException;

public class TemplateFactoryWrapperTest {

	@Test
	public void wrapSingleColumnTest() throws Exception {
		TemplateFactoryWrapper factoryWrapper = new TemplateFactoryWrapper();
		HashMap<String, String> singleEntry = new HashMap<String, String>();
		Organization organization = new Organization();

		singleEntry.put("preferred_official_language_id", "English");

		NARsTemplate nARsResult = (NARsTemplate) factoryWrapper.build("NARs", singleEntry, organization);

		assertEquals("English", nARsResult.getPreferredOfficialLanguageId());
	}

	@Test
	public void wrapMultipleColumnTest() throws Exception {
		TemplateFactoryWrapper factoryWrapper = new TemplateFactoryWrapper();
		HashMap<String, String> multipleEntry = new HashMap<String, String>();
		Organization organization = new Organization();

		multipleEntry.put("processing_details", "Test1");
		multipleEntry.put("update_record_id", "Test2");
		multipleEntry.put("client_validation_type_id", "Test3");

		NARsTemplate nARsResult = (NARsTemplate) factoryWrapper.build("NARs", multipleEntry, organization);

		assertEquals("Test1", nARsResult.getProcessingDetails());
		assertEquals("Test2", nARsResult.getUpdateRecordId());
		assertEquals("Test3", nARsResult.getClientValidationTypeId());
	}

	@Test
	public void wrapMultipleTemplateTypeTest() throws Exception {
		TemplateFactoryWrapper factoryWrapper = new TemplateFactoryWrapper();
		HashMap<String, String> singleEntryOne = new HashMap<String, String>();
		HashMap<String, String> singleEntryTwo = new HashMap<String, String>();
		Organization organization = new Organization();
		
		singleEntryOne.put("preferred_official_language_id", "English");
		singleEntryTwo.put("street_nme", "Front Street");
		
		NARsTemplate nARsResult = (NARsTemplate) factoryWrapper.build("NARs", singleEntryOne, organization);
		ClientProfileTemplate clientProfileResult = (ClientProfileTemplate) factoryWrapper.build("clientProfile", singleEntryTwo, organization);
		
		assertEquals("English", nARsResult.getPreferredOfficialLanguageId());
		assertEquals("Front Street", clientProfileResult.getStreetNme());
	}

	@Test(expected = IllegalTemplateException.class)
	public void wrapInvalidTemplateTest() throws Exception {
		TemplateFactoryWrapper factoryWrapper = new TemplateFactoryWrapper();
		Organization organization = new Organization();
		factoryWrapper.build("", null, organization);
	}

	@Test(expected = IllegalArgumentException.class)
	public void wrapInvalidColumnKeyTest() throws Exception {
		TemplateFactoryWrapper factoryWrapper = new TemplateFactoryWrapper();
		HashMap<String, String> singleEntry = new HashMap<String, String>();
		Organization organization = new Organization();

		singleEntry.put("", "Test");

		factoryWrapper.build("NARs", singleEntry, organization);
	}

}
