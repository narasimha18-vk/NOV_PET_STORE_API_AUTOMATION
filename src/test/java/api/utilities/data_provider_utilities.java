package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class data_provider_utilities {

	
	@DataProvider(name="get_all_data")
	public String[][] getdata() throws IOException
	{
		String filepath="C:\\Users\\Naras\\eclipse-workspace\\NOV_PETSTORE_API_AUTOMATION_FRAMEWORK\\src\\test\\resources\\pet_store_api_automation_test_data.xlsx";
		
	  String[][] Data	=excel_utilities.get_all_data(filepath,"Sheet1");
	  
	  
	  return Data;
	}
	
	
	
	@DataProvider(name="get_all_usernames")
	public String[] get_username() throws IOException
	
	{
		String filepath="C:\\Users\\Naras\\eclipse-workspace\\NOV_PETSTORE_API_AUTOMATION_FRAMEWORK\\src\\test\\resources\\pet_store_api_automation_test_data.xlsx";
		
		String[] user_names=excel_utilities.get_all_usernames(filepath, "Sheet1");
		
		
		return user_names;
		
	}
}
