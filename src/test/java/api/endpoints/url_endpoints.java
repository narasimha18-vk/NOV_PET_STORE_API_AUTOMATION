package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import api.payloads.user_pojo;
import io.restassured.response.Response;

public class url_endpoints {
	
	public static Properties pp;
	
	
	public static void setup() throws IOException
	{
		FileInputStream ff= new FileInputStream("C:\\Users\\Naras\\eclipse-workspace\\NOV_PETSTORE_API_AUTOMATION_FRAMEWORK\\src\\test\\resources\\properties");
		
		 pp= new Properties();
		
		pp.load(ff);
	
	
	}
	

	
	
	public Response create_user(user_pojo user) throws IOException
	
	{
		setup();
		
		//String p_url= pp.getProperty()
		
		
		Response res=given()
		.contentType("application/json")
		.accept("application/json")
		.body(user)
		
		.when()
		.post(pp.getProperty("post_url"));
		return res;	
		
	}
	
public Response get_user(String username) throws IOException
	
	{
	  setup();
		Response res=given()
	     .pathParam("username", username)
		
		
		.when()
		.get(pp.getProperty("get_url"));
		return res;	
		
	}

public Response update_user(String username,user_pojo user) throws IOException

{
	
	setup();
	
	Response res=given()
	.contentType("application/json")
	.accept("application/json")
	.pathParam("username", username)
	.body(user)
	
	.when()
	.put(pp.getProperty("put_url"));
	return res;	
	
}

public Response delete_user(String username) throws IOException

{
	
	setup();
	Response res=given()
	.pathParam("username", username)
	
	.when()
	.delete(pp.getProperty("delete_url"));
	return res;	
	
}

}
