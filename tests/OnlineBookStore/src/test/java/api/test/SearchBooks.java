package api.test;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.Base;
import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class SearchBooks extends Base{
	
	
User userpayload;
	
	@BeforeClass
	public void setup() {
		
		userpayload = new User();
		
	}
	
	@Test
	public void successfulSearchBooks() {
		
		Response response = UserEndpoints.SearchBooks(userpayload);
		response.then().log().all();
		
		try {
		if(response.statusCode()==200) {
			AssertJUnit.assertEquals(200, response.getStatusCode());
			AssertJUnit.assertEquals("fiction", response.jsonPath().getString("[0].type"));
		}else if(response.statusCode()!=200) {
			System.out.println("Reponse code is not as expected, the response code is "+response.statusCode());
			System.out.println("The error is "+response.jsonPath().get("message"));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	    
	
	@Test
	public void wrongSearchData() {
		
		Response response = UserEndpoints.SearchBooks(userpayload);
		response.then().log().all();
		
		try {
		if(response.statusCode()==404) {
			AssertJUnit.assertEquals(404, response.getStatusCode());

			AssertJUnit.assertEquals("failure", response.jsonPath().get("status"));
			AssertJUnit.assertEquals("no data available", response.jsonPath().get("message"));
		}else if(response.statusCode()!=404) {
			System.out.println("The response code is "+response.statusCode());
			System.out.println("The response is "+response.jsonPath().get("message"));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	  
		    
		
	}
	
	


