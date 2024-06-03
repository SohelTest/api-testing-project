package api.test;

import org.testng.AssertJUnit;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.Base;
import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class AddToCart extends Base {

	User userpayload;

	@BeforeClass
	public void setup() {

		userpayload = new User();

	}

	@Test
	public void AddtoCart(ITestContext context) {

		String userId = (String) context.getAttribute("userId");
		Response response = UserEndpoints.AddToCart(userId);
		
		userpayload.setname(prop.getProperty("bookname"));
		userpayload.setQuantity(prop.getProperty("quantity"));
		
		response.then().log().all();

		try {

			if (response.statusCode() == 202) {

				AssertJUnit.assertEquals(202, response.getStatusCode());

				AssertJUnit.assertEquals("true", response.jsonPath().get("success"));
				AssertJUnit.assertEquals("Item added to cart", response.jsonPath().get("message"));
				AssertJUnit.assertEquals("Gulliver's Travels", response.jsonPath().get("name"));
				AssertJUnit.assertEquals("2", response.jsonPath().get("quantity"));

			} else if (response.statusCode() != 202) {
				System.out.println("Reponse code is not as expected, the response code is " + response.statusCode());
				System.out.println("The error is " + response.jsonPath().get("message"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void missingDetails(ITestContext context) {

		String userId = (String) context.getAttribute("userId");
		Response response = UserEndpoints.AddToCart(userId);
		
		userpayload.setname(prop.getProperty("bookname"));
		
		response.then().log().all();

		try {

			if (response.statusCode() == 401) {

				AssertJUnit.assertEquals(401, response.getStatusCode());

				AssertJUnit.assertEquals("false", response.jsonPath().get("success"));
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
	public void noInputDetails(ITestContext context) {

		String userId = (String) context.getAttribute("userId");
		Response response = UserEndpoints.AddToCart(userId);
		
		response.then().log().all();

		try {

			if (response.statusCode() == 404) {

				AssertJUnit.assertEquals(404, response.getStatusCode());

				AssertJUnit.assertEquals("false", response.jsonPath().get("success"));
				AssertJUnit.assertEquals("input details not found", response.jsonPath().get("message"));

			} else if (response.statusCode() != 404) {
				System.out.println("The response code is " + response.statusCode());
				System.out.println("The response is " + response.jsonPath().get("message"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
