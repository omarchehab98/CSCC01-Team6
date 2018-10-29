package team6.factories;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashMap;

import team6.models.NARsTemplate;

public class NARsTemplateFactoryTest {

	@Test
	public void buildSingleInputTest() {
		HashMap<String, String> singleColumn = new HashMap<String, String>(); 
		
		singleColumn.put("processing_details", "test processing details");
		NARsTemplate result = (NARsTemplate) NARsTemplateFactory.build(singleColumn);
		
		assertEquals("test processing details", result.getProcessingDetails());
	}

	@Test
	public void buildMultipleInputTest() {
		HashMap<String, String> multipleColumn = new HashMap<String, String>(); 
		
		multipleColumn.put("processing_details", "Test1");
		multipleColumn.put("update_record_id", "Test2");
		multipleColumn.put("client_validation_type_id", "Test3");
		NARsTemplate result = (NARsTemplate) NARsTemplateFactory.build(multipleColumn);
		
		assertEquals("Test1", result.getProcessingDetails());
		assertEquals("Test2", result.getUpdateRecordId());
		assertEquals("Test3", result.getClientValidationTypeId());
	}

	@Test
	public void buildTwoEntitiesTest() {
		HashMap<String, String> in0 = new HashMap<String, String>(); 
		
		in0.put("processing_details", "Test1");
		NARsTemplate result0 = (NARsTemplate) NARsTemplateFactory.build(in0);

		HashMap<String, String> in1 = new HashMap<String, String>(); 
		in1.put("client_validation_type_id", "Test2");
		NARsTemplate result1 = (NARsTemplate) NARsTemplateFactory.build(in1);
		
		assertEquals("Test1", result0.getProcessingDetails());
		assertEquals(null, result0.getClientValidationTypeId());
		
		assertEquals(null, result1.getProcessingDetails());
		assertEquals("Test2", result1.getClientValidationTypeId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void buildEmtpyInputTest() {
		HashMap<String, String> singleColumn = new HashMap<String, String>(); 
		
		singleColumn.put("", "test");
		NARsTemplateFactory.build(singleColumn);
	}

	@Test
	public void buildNoInputTest() {
		HashMap<String, String> singleColumn = new HashMap<String, String>();  
		
		singleColumn.put("processing_details", "test processing details");
		NARsTemplate result = (NARsTemplate) NARsTemplateFactory.build(singleColumn);
		
		assertEquals(result.getId(), result.getId());
	}
}
