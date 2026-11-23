package api.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.url_endpoints;
import api.payloads.user_pojo;
import io.restassured.response.Response;

public class user_tests {
	
	
	url_endpoints uu= new url_endpoints();
	
	user_pojo up= new user_pojo();
	
	
	@Test(priority = 1)
	public void test_post_user() throws IOException
	{
		Faker ff= new Faker();
		up.setId(ff.number().numberBetween(1, 1000));
		
		up.setUsername(ff.name().username());
		up.setFirstName(ff.name().firstName());
		up.setLastName(ff.name().lastName());
		up.setEmail(ff.internet().emailAddress());
		
		up.setPassword(ff.internet().password(7, 10));
		
		up.setPhone(ff.phoneNumber().cellPhone());
		
		up.setUserStatus(ff.number().numberBetween(1, 10));
		
		
	  Response res=	uu.create_user(up);
	  
	  res.then().statusCode(200);
	  
	  res.then().log().body();
	}
	
	
	
	@Test(priority = 2)
	public void test_get_user() throws IOException
	{
		
		
	  Response res=	uu.get_user(up.getUsername());
	  
	  res.then().statusCode(200);
	  
	  res.then().log().body();
	}
	
	
	@Test(priority = 3)
	public void test_put_user() throws IOException
	{
		Faker ff= new Faker();
		//up.setId(ff.number().numberBetween(1, 1000));
		

		up.setFirstName(ff.name().firstName());
		up.setLastName(ff.name().lastName());
		up.setEmail(ff.internet().emailAddress());
		
		up.setPassword(ff.internet().password(7, 10));
		
		up.setPhone(ff.phoneNumber().cellPhone());
		
		up.setUserStatus(ff.number().numberBetween(1, 10));
		
		
	  Response res=	uu.update_user(up.getUsername(),up);
	  
	  res.then().statusCode(200);
	  
	  res.then().log().body();
	  
	  Response res_after_update=	uu.get_user(up.getUsername());
	  
	  res_after_update.then().log().body();
	}
	
	
	@Test(priority = 4)
	public void test_delete_user() throws IOException
	{

		
		
	  Response res=	uu.delete_user(up.getUsername());
	  
	  res.then().statusCode(200);
	  
	  res.then().log().body();
	}

}
