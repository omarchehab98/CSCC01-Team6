package team6.factories;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import team6.models.NARsTemplate;
import team6.models.ClientProfileTemplate;
import team6.throwables.IllegalTemplateException;

public class TemplateFactoryWrapperTest {

	@Test
	public void wrapSingleColumnTest() throws Exception {
		TemplateFactoryWrapper factoryWrapper = new TemplateFactoryWrapper();
		HashMap<String, String> singleEntry = new HashMap<String, String>();

		singleEntry.put("preferred_official_language_id", "English");

		NARsTemplate nARsResult = (NARsTemplate) factoryWrapper.build("NARs", singleEntry);

		assertEquals("English", nARsResult.getPreferredOfficialLanguageId());
	}

	@Test
	public void wrapMultipleColumnTest() throws Exception {
		TemplateFactoryWrapper factoryWrapper = new TemplateFactoryWrapper();
		HashMap<String, String> multipleEntry = new HashMap<String, String>();

		multipleEntry.put("processing_details", "Test1");
		multipleEntry.put("update_record_id", "Test2");
		multipleEntry.put("client_validation_type_id", "Test3");

		NARsTemplate nARsResult = (NARsTemplate) factoryWrapper.build("NARs", multipleEntry);

		assertEquals("Test1", nARsResult.getProcessingDetails());
		assertEquals("Test2", nARsResult.getUpdateRecordId());
		assertEquals("Test3", nARsResult.getClientValidationTypeId());
	}

	@Test
	public void wrapMultipleTemplateTypeTest() throws Exception {
		TemplateFactoryWrapper factoryWrapper = new TemplateFactoryWrapper();
		HashMap<String, String> singleEntryOne = new HashMap<String, String>();
		HashMap<String, String> singleEntryTwo = new HashMap<String, String>();
		
		singleEntryOne.put("preferred_official_language_id", "English");
		singleEntryTwo.put("street_nme", "Front Street");
		
		NARsTemplate nARsResult = (NARsTemplate) factoryWrapper.build("NARs", singleEntryOne);
		ClientProfileTemplate clientProfileResult = (ClientProfileTemplate) factoryWrapper.build("clientProfile", singleEntryTwo);
		
		assertEquals("English", nARsResult.getPreferredOfficialLanguageId());
		assertEquals("Front Street", clientProfileResult.getStreetNme());
	}

	@Test(expected = IllegalTemplateException.class)
	public void wrapInvalidTemplateTest() throws Exception {
		TemplateFactoryWrapper factoryWrapper = new TemplateFactoryWrapper();
		factoryWrapper.build("", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void wrapInvalidColumnKeyTest() throws Exception {
		TemplateFactoryWrapper factoryWrapper = new TemplateFactoryWrapper();
		HashMap<String, String> singleEntry = new HashMap<String, String>();

		singleEntry.put("", "Test");

		factoryWrapper.build("NARs", singleEntry);
	}

}
