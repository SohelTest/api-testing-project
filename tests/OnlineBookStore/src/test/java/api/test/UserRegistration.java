package api.test;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.Base;
import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserRegistration extends Base {

	User userpayload;

	@BeforeClass
	public void setup() {

		userpayload = new User();	

	}

	@Test
	public void successfulRegistration() {
		Response response = UserEndpoints.UserRegister(userpayload);
		
		userpayload.setUsername(prop.getProperty("username"));
		userpayload.setEmail(prop.getProperty("email"));
		userpayload.setname(prop.getProperty("name"));
		userpayload.setaddress(prop.getProperty("address"));
		userpayload.setPhone(prop.getProperty("phone"));

		response.then().log().all();

		try {

			if (response.statusCode() == 201) {

				AssertJUnit.assertEquals(201, response.getStatusCode());

				AssertJUnit.assertEquals("success", response.jsonPath().get("status"));
				AssertJUnit.assertEquals("User registration successful", response.jsonPath().get("message"));
				AssertJUnit.assertEquals("Roy", response.jsonPath().get("user.username"));
				AssertJUnit.assertEquals("roy@gmail.com", response.jsonPath().get("user.email"));
				AssertJUnit.assertEquals("Roy Walter", response.jsonPath().get("user.name"));
				AssertJUnit.assertEquals("USA", response.jsonPath().get("user.address"));
				AssertJUnit.assertEquals("202-555-0118", response.jsonPath().get("user.phone"));
			} else if (response.statusCode() != 201) {
				System.out.println("Reponse code is not as expected, the response code is " + response.statusCode());
				System.out.println("Th error is " + response.jsonPath().get("message"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void missingDetails() {
		Response response = UserEndpoints.UserRegister(userpayload);
		
		userpayload.setname(prop.getProperty("name"));
		userpayload.setaddress(prop.getProperty("address"));
		userpayload.setPhone(prop.getProperty("phone"));

		response.then().log().all();

		try {

			if (response.statusCode() == 401) {

				AssertJUnit.assertEquals(401, response.getStatusCode());

				AssertJUnit.assertEquals("failure", response.jsonPath().get("status"));
				AssertJUnit.assertEquals("input details missing", response.jsonPath().get("message"));
			} else if (response.statusCode() != 401) {
				System.out.println("The response code is " + response.statusCode());
				System.out.println("The response is " + response.jsonPath().get("message"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void withoutInputData() {
		Response response = UserEndpoints.UserRegister(userpayload);

		response.then().log().all();

		try {

			if (response.statusCode() == 404) {

				AssertJUnit.assertEquals(404, response.getStatusCode());

				AssertJUnit.assertEquals("failure", response.jsonPath().get("status"));
				AssertJUnit.assertEquals("no input data", response.jsonPath().get("message"));
			} else if (response.statusCode() != 404) {
				System.out.println("The response code is " + response.statusCode());
				System.out.println("The response is " + response.jsonPath().get("message"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
