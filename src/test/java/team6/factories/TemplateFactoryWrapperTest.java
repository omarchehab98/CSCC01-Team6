package team6.factories;

import static org.junit.Assert.*;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import team6.models.TemplateInterface; 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import team6.models.NARsTemplate;
import team6.models.TemplateInterface;
import team6.throwables.IllegalTemplateException;

public class TemplateFactoryWrapperTest {

	@Test
	public void wrapSingleColumnTest() throws Exception {
		TemplateFactoryWrapper factoryWrapper = new TemplateFactoryWrapper();
		HashMap<String, String> singleEntry = new HashMap<String, String>(); 
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		singleEntry.put("preferred_official_language_id", "English");
		list.add(singleEntry);
		
		List<TemplateInterface> result = factoryWrapper.wrap("NARs", list);
		NARsTemplate nARsResult = (NARsTemplate) result.get(0);
		
		assertEquals("English", nARsResult.getPreferredOfficialLanguageId());
	}

	@Test
	public void wrapMultipleColumnTest() throws Exception {
		TemplateFactoryWrapper factoryWrapper = new TemplateFactoryWrapper();
		HashMap<String, String> multipleEntry = new HashMap<String, String>(); 
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		multipleEntry.put("processing_details", "Test1");
		multipleEntry.put("update_record_id", "Test2");
		multipleEntry.put("client_validation_type_id", "Test3");
		list.add(multipleEntry);
		
		List<TemplateInterface> result = factoryWrapper.wrap("NARs", list);
		NARsTemplate nARsResult = (NARsTemplate) result.get(0);
		
		assertEquals("Test1", nARsResult.getProcessingDetails());
		assertEquals("Test2", nARsResult.getUpdateRecordId());
		assertEquals("Test3", nARsResult.getClientValidationTypeId());
	}

	@Test(expected = IllegalTemplateException.class)
	public void wrapInvalidTemplateTest() throws Exception {
		TemplateFactoryWrapper factoryWrapper = new TemplateFactoryWrapper();
		List<HashMap<String, String>> emptyList = new ArrayList<HashMap<String, String>>();
		factoryWrapper.wrap("", emptyList);
	}

	@Test(expected = IllegalArgumentException.class)
	public void wrapInvalidColumnKeyTest() throws Exception {
		TemplateFactoryWrapper factoryWrapper = new TemplateFactoryWrapper();
		HashMap<String, String> singleEntry = new HashMap<String, String>(); 
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		singleEntry.put("", "Test");
		list.add(singleEntry);
		
		factoryWrapper.wrap("NARs", list);
	}

}
