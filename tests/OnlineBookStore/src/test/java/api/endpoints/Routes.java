package api.endpoints;

public class Routes extends Base{
	
	public static String base_url = "https://3d475813-89a1-40d4-9662-0fd6c9215d96.mock.pstmn.io/";
	
	public static String user_register_post_url = base_url+"users/register";
	public static String user_login_post_url = base_url+"users/login";
	public static String add_to_cart_post_url = base_url+"users/{userId}/cart";
	public static String checkout_post_url = base_url+"users/{userId}/checkout";
	
	public static String search_books_get_url = base_url+"books?search="+prop.getProperty("search");
	
	
	

}
