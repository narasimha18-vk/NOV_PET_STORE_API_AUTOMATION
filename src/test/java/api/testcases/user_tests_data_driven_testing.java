package api.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.url_endpoints;
import api.payloads.user_pojo;
import api.utilities.data_provider_utilities;
import io.restassured.response.Response;

public class user_tests_data_driven_testing {
	
	
url_endpoints uu= new url_endpoints();
	
	user_pojo up= new user_pojo();
	
	
	@Test(priority = 1, dataProvider = "get_all_data",dataProviderClass = data_provider_utilities.class)
	public void test_post_user(String id, String username,String firstName, String lastName, String email, String password, String phone, String userStatus ) throws IOException
	{
		 
		up.setId(Integer.parseInt(id));
		
		up.setUsername(username);
		up.setFirstName(firstName);
		up.setLastName(lastName);
		up.setEmail(email);
		
		up.setPassword(password);
		
		up.setPhone(phone);
		
		up.setUserStatus(Integer.parseInt(userStatus));
		
		
	  Response res=	uu.create_user(up);
	  
	  res.then().statusCode(200);
	  
	  res.then().log().body();
	}
	
	
	
	@Test(priority = 2,dataProvider = "get_all_usernames",dataProviderClass = data_provider_utilities.class)
	public void test_get_user(String username) throws IOException
	{
		up.setUsername(username);
		
		
	  Response res=	uu.get_user(up.getUsername());
	  
	  res.then().statusCode(200);
	  
	  res.then().log().body();
	}
	
	

	
	@Test(priority = 3,dataProvider = "get_all_usernames",dataProviderClass = data_provider_utilities.class)
	public void test_delete_user(String username) throws IOException
	{
		up.setUsername(username);
		
		
	  Response res=	uu.delete_user(up.getUsername());
	  
	  res.then().statusCode(200);
	  
	  res.then().log().body();
	}


}
