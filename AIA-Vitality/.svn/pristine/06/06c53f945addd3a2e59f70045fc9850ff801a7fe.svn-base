package com.eloqua.api.bulk.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.aia.model.CDODetails;
import com.aia.service.AIAService;
import com.eloqua.api.models.CustomObjectSearchResponse;
import com.eloqua.api.models.Field;
import com.eloqua.api.models.Import;
import com.eloqua.api.models.RestObjectList;
import com.eloqua.api.models.Sync;
import com.eloqua.api.models.SyncResult;
import com.eloqua.api.bulk.helper.ImportCustomDataObjectHelper;



public class ImportCustomDataObjectHelperTest {
	
	private ImportCustomDataObjectHelper  custDataObject=null;
	
	/*@Before
	public void setup(){
		custDataObject=new ImportCustomDataObjectHelper("AIA", "Ramya.Ponnusamy", "Verticurl2014!", "https://secure.eloqua.com/API");
		//custDataObject=new ImportCustomDataObjectHelper("SEASandbox", "elqif.user", "Eloqua*11", "https://secure.p03.eloqua.com/API");
	}*/
	@Test
	public void FullImportTest()
    {
		
		List<CDODetails> cdoDetailsList=new ArrayList<CDODetails>();
		
		CDODetails cdoData=new CDODetails();
		
		cdoData.setAiaVitalityMemberNumber("V180000111_20140931");
		cdoData.setClientId("5500001111");
		cdoData.setEmailAddress("kishore@gmail.com");
		cdoData.setGender("M");
		cdoData.setEntityReferenceNumber("5500001122");
		cdoData.setLanguagePreference("yue_HK");
		cdoData.setMemberFirstName("First Name");
		cdoData.setMemberSurname("surname");
		cdoData.setPointBalance("5454545");
		cdoData.setVitalityStatus("GOLD");		
		cdoDetailsList.add(cdoData);	
		
		AIAService aiaService=new AIAService();
		aiaService.syncCDODataToEloqua(cdoDetailsList);		
       
    }
	
	
	/*@Test
	public void updateCustomDataObject(){
		
		
		// search for custom objects
        RestObjectList<CustomObjectSearchResponse> search = custDataObject.searchCustomDataObjects("*", 1, 300);
        List<CustomObjectSearchResponse> customObjects = search.getElements();

        // retrieve the custom object uri
        //String customObjectUri = ((CustomObjectSearchResponse)customObjects.get(0)).getUri();

        // assume a known custom object id 266 for Employee (use search endpoint for list)
        int customObjectId = 266;//

        RestObjectList<Field> customObjectFields = custDataObject.getCustomObjectFields(customObjectId);

        for(Field customObjectField : customObjectFields.getElements())
        {
            // select items to be included in the list of importFields
            System.out.println("internal name: " + customObjectField.getInternalName());
        }

        // define the list of fields used in the import
        // for the purposes of this sample, the fields have been hardcoded
        Map<String, String> importFields = new HashMap<String, String>();
        importFields.put("EmpId1", "{{CustomObject[266].Field[1162]}}");//1162
        importFields.put("First_Name1", "{{CustomObject[266].Field[1163]}}");
        importFields.put("Last_Name1", "{{CustomObject[266].Field[1164]}}");
        importFields.put("Email_Address1", "{{CustomObject[266].Field[1165]}}");
        importFields.put("EmailAddressField", "{{CustomObject[266].Contact.Field(C_EmailAddress)}}" ); 
                                                              

        // create the structure for the import
        Import importStruc = custDataObject.createImportStructure(customObjectId, importFields);

        String importUri = importStruc.getUri();

        // define some sample data
        Map<String, Object> data1 = new HashMap<String, Object>();
        data1.put("EmpId1", 100);
        data1.put("First_Name1", "Rosalyne_1");
        data1.put("Last_Name1", "Maibam_1");
        data1.put("Email_Address1", "chitrakishore.maibam12@verticurl.com");
        //1162DCF=1&1163DCF=first&1164DCF=test&DataCardID=-1&DataCardSet=266&New=True&EntityMap=&SalesProcessEntity=&SalesProcessEntityType=&CustomerGUID=&MapNewDCToEntity=False&OpenInModal=True&SaveAndClose=False&xsrfToken=97d42ca9-75b4-4a9f-bf51-ee24a69d8bda
        
        // define some sample data
        Map<String, Object> data2 = new HashMap<String, Object>();
        data2.put("EmpId1", 101);
        data2.put("First_Name1", "Kishore_2");
        data2.put("Last_Name1", "Maibam_2");
        data2.put("Email_Address1", "chitrakishore.maibam13@verticurl.com");
        
     // define some sample data
        Map<String, Object> data3 = new HashMap<String, Object>();
        data3.put("EmpId1", 102);
        data3.put("First_Name1", "Kovidh_3");
        data3.put("Last_Name1", "Maibam_3");
        data3.put("Email_Address1", "chitrakishore.maibam@verticurl.com");

        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        dataList.add(data1);
        dataList.add(data2);
        dataList.add(data3);

        // import the data
        Sync sync = custDataObject.importData(importUri, dataList);
       //Assert.IsNotNullOrEmpty(sync.uri);

        // poll results until the sync is complete
        RestObjectList<SyncResult> syncResult = custDataObject.checkSyncResult(sync.getUri());
        System.out.println("TOTAL====" + syncResult.getTotal());

        //Assert.IsNotNull(syncResult);
		
		
	}*/

	
	

	
	
}
