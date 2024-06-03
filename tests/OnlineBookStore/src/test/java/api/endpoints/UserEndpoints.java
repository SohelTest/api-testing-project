package api.endpoints;
import static io.restassured.RestAssured.*;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {
	
	
	public static Response UserRegister(User payload) {
		 Response response = given()
				 .contentType(ContentType.JSON)
				 .accept(ContentType.JSON)
				 .body(payload)
				 
				 
				.when()
				.post(Routes.user_register_post_url);
				
		 return response;
  
           
   }
	
	public static Response SearchBooks(User payload) {
		Response response = given()
				
				.when()
				.get(Routes.search_books_get_url);
		
		return response;
				
	}
	
	public static Response UserLogin(User payload) {
		 Response response = given()
				 .contentType(ContentType.JSON)
				 .accept(ContentType.JSON)
				 .body(payload)
				 
				 
				.when()
				.post(Routes.user_login_post_url);
				
		 return response;
 
          
  }
	
	public static Response AddToCart(String userId) {
		Response response = given()
				.pathParam("userId",userId)
				.when()
				.post(Routes.add_to_cart_post_url);
		
		return response;
				
	}
	
	public static Response Checkout(String userId) {
		Response response = given()
				.pathParam("userId", userId)
				.when()
				.post(Routes.checkout_post_url);
		
		return response;
				
	}
	
}
