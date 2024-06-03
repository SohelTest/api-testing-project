package api.test;

import org.testng.AssertJUnit;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.Base;
import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class Checkout extends Base {

	User userpayload;

	@BeforeClass
	public void setup() {

		userpayload = new User();

	}

	@Test
	public void checkout(ITestContext context) {

		String userId = (String) context.getAttribute("userId");
		Response response = UserEndpoints.Checkout(userId);

		userpayload.setId(prop.getProperty("id"));
		userpayload.setname(prop.getProperty("bookname"));
		userpayload.setPrice(prop.getProperty("price"));
		userpayload.setQuantity(prop.getProperty("quantity"));
		userpayload.setTotal_price(prop.getProperty("price"));
		userpayload.setname(prop.getProperty("name"));
		userpayload.setEmail(prop.getProperty("email"));
		userpayload.setaddress(prop.getProperty("address"));
		userpayload.setPayment_method(prop.getProperty("paymentMethod"));
		userpayload.setCard_number(prop.getProperty("cardNumber"));
		userpayload.setExpiration_date(prop.getProperty("expiryDate"));
		userpayload.setCvv(prop.getProperty("cvv"));

		response.then().log().all();

		try {
			if (response.statusCode() == 202) {
				AssertJUnit.assertEquals(202, response.getStatusCode());

				AssertJUnit.assertEquals("true", response.jsonPath().get("success"));
				AssertJUnit.assertEquals("Checkout successful", response.jsonPath().get("message"));
			} else if (response.statusCode() != 202) {
				System.out.println("Reponse code is not as expected, the response code is " + response.statusCode());
				System.out.println("The error is " + response.jsonPath().get("message"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void withoutCardDetails(ITestContext context) {

		String userId = (String) context.getAttribute("userId");
		Response response = UserEndpoints.Checkout(userId);

		userpayload.setId(prop.getProperty("id"));
		userpayload.setname(prop.getProperty("bookname"));
		userpayload.setPrice(prop.getProperty("price"));
		userpayload.setQuantity(prop.getProperty("quantity"));
		userpayload.setTotal_price(prop.getProperty("price"));
		userpayload.setname(prop.getProperty("name"));
		userpayload.setEmail(prop.getProperty("email"));
		userpayload.setaddress(prop.getProperty("address"));

		response.then().log().all();

		try {
			if (response.statusCode() == 402) {
				AssertJUnit.assertEquals(402, response.getStatusCode());

				AssertJUnit.assertEquals("false", response.jsonPath().get("success"));
				AssertJUnit.assertEquals("payment is missing", response.jsonPath().get("message"));
			} else if (response.statusCode() != 402) {
				System.out.println("The response code is " + response.statusCode());
				System.out.println("The response is " + response.jsonPath().get("message"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void missingvalues(ITestContext context) {

		String userId = (String) context.getAttribute("userId");
		Response response = UserEndpoints.Checkout(userId);

		userpayload.setname(prop.getProperty("name"));
		userpayload.setEmail(prop.getProperty("email"));
		userpayload.setaddress(prop.getProperty("address"));
		userpayload.setPayment_method(prop.getProperty("paymentMethod"));
		userpayload.setCard_number(prop.getProperty("cardNumber"));
		userpayload.setExpiration_date(prop.getProperty("expiryDate"));
		userpayload.setCvv(prop.getProperty("cvv"));

		response.then().log().all();

		try {
			if (response.statusCode() == 401) {
				AssertJUnit.assertEquals(401, response.getStatusCode());

				AssertJUnit.assertEquals("false", response.jsonPath().get("success"));
				AssertJUnit.assertEquals("input data is missing", response.jsonPath().get("message"));
			} else if (response.statusCode() != 202) {
				System.out.println("The response code is " + response.statusCode());
				System.out.println("The response is " + response.jsonPath().get("message"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void noInputData(ITestContext context) {

		String userId = (String) context.getAttribute("userId");
		Response response = UserEndpoints.Checkout(userId);

		response.then().log().all();

		try {
			if (response.statusCode() == 404) {
				AssertJUnit.assertEquals(404, response.getStatusCode());

				AssertJUnit.assertEquals("false", response.jsonPath().get("success"));
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
