package api.test;

import org.testng.AssertJUnit;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.Base;
import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserLogin extends Base {

	User userpayload;

	@BeforeClass
	public void setup() {

		userpayload = new User();
	}

	@Test
	public void successfulLogin(ITestContext context) {

		Response response = UserEndpoints.UserLogin(userpayload);
		userpayload.setUsername(prop.getProperty("username"));
		userpayload.setEmail(prop.getProperty("email"));

		String id = response.jsonPath().getString("user.id");
		response.then().log().all();

		try {

			if (response.statusCode() == 200) {

				AssertJUnit.assertEquals(200, response.getStatusCode());

				AssertJUnit.assertEquals("success", response.jsonPath().get("status"));
				AssertJUnit.assertEquals("User login successful", response.jsonPath().get("message"));
				AssertJUnit.assertEquals("Roy", response.jsonPath().get("user.username"));
				AssertJUnit.assertEquals("roy@gmail.com", response.jsonPath().get("user.email"));
				AssertJUnit.assertEquals("Roy Walter", response.jsonPath().get("user.name"));
				AssertJUnit.assertEquals("USA", response.jsonPath().get("user.address"));
				AssertJUnit.assertEquals("202-555-0118", response.jsonPath().get("user.phone"));

				context.setAttribute("userId", id);

				System.out.println("Id is " + id);
			} else if (response.statusCode() != 200) {
				System.out.println("Reponse code is not as expected, the response code is " + response.statusCode());
				System.out.println("Th error is " + response.jsonPath().get("message"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void missingDetails() {

		Response response = UserEndpoints.UserLogin(userpayload);
		userpayload.setUsername(prop.getProperty("username"));
		response.then().log().all();

		try {

			if (response.statusCode() == 401) {

				AssertJUnit.assertEquals(401, response.getStatusCode());

				AssertJUnit.assertEquals("failure", response.jsonPath().get("status"));
				AssertJUnit.assertEquals("missing input data", response.jsonPath().get("message"));
				

			} else if (response.statusCode() != 401) {
				System.out.println("The response code is " + response.statusCode());
				System.out.println("The response is " + response.jsonPath().get("message"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void noInputData() {

		Response response = UserEndpoints.UserLogin(userpayload);
		userpayload.setUsername(prop.getProperty("username"));
		response.then().log().all();

		try {

			if (response.statusCode() == 404) {

				AssertJUnit.assertEquals(404, response.getStatusCode());

				AssertJUnit.assertEquals("failure", response.jsonPath().get("status"));
				AssertJUnit.assertEquals("no input data", response.jsonPath().get("message"));
				

			} else if (response.statusCode() != 401) {
				System.out.println("The response code is " + response.statusCode());
				System.out.println("The response is " + response.jsonPath().get("message"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
