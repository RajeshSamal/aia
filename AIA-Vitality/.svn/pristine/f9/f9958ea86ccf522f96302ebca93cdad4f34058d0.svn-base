package com.eloqua.api.bulk.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.eloqua.api.models.CustomObject;
import com.eloqua.api.models.CustomObjectField;
import com.eloqua.api.models.DataType;
import com.eloqua.api.bulk.helper.CustomObjectBulkHelper;



public class CustomObjectBulkHelperTest {

	private CustomObjectBulkHelper customObjectHelper;
	
	/*@Before
	public void setup(){
		
		customObjectHelper=new CustomObjectBulkHelper("VerticurlE10Sandbox", "ChitraKishore.Maibam", "Bhavin@blr17", "https://secure.eloqua.com/API/Bulk/2.0");
		
	}*/
	
	@Test
	public void createCustomObject(){
		
		CustomObject customObject=new CustomObject();
		
		customObject.setId(-100);
		customObject.setDisplayNameFieldId("My CustomObject");
		customObject.setName("KishoreSample3");
		
		CustomObjectField customObjectField1=new CustomObjectField();
		/*CustomObjectField customObjectField2=new CustomObjectField();
		CustomObjectField customObjectField3=new CustomObjectField();*/
		
		/*new CustomObjectField
                                                            {
                                                                name = "sample text field",
                                                                dataType = Enum.GetName(typeof(DataType), DataType.text),
                                                                type = "CustomObjectField"
                                                            },
                                                        new CustomObjectField
                                                            {
                                                                name = "sample numeric field",
                                                                dataType = Enum.GetName(typeof(DataType), DataType.numeric),
                                                                type = "CustomObjectField"
                                                            },
                                                        new CustomObjectField
                                                            {
                                                                name = "sample date field",
                                                                dataType = Enum.GetName(typeof(DataType), DataType.date),
                                                                type = "CustomObjectField"
                                                            }*/
		customObjectField1.setId(1);
		customObjectField1.setName("sample text field");		
		customObjectField1.setDataType(DataType.text.name());
		customObjectField1.setType("CustomObjectField");
		
		/*customObjectField2.setName("sample numeric field");		
		customObjectField2.setDataType(DataType.numeric.name());
		customObjectField2.setType("CustomObjectField");
		
		customObjectField3.setName("sample date field");		
		customObjectField3.setDataType(DataType.date.name());
		customObjectField3.setType("CustomObjectField");*/
		
		List<CustomObjectField> customObjectList=new ArrayList<CustomObjectField>();
		customObjectList.add(customObjectField1);
		//customObjectList.add(customObjectField2);
		//customObjectList.add(customObjectField3);		
		
		customObject.setFields(customObjectList);
		
		
		customObjectHelper.createCustomObject(customObject);
		
		
		
		
	}
	
}
