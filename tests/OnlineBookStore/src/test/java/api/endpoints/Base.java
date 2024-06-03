package api.endpoints;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Base {
	
	public static Properties prop = new Properties();
	public static WebDriver driver;
	
	public void filedata() {

		try {
			FileInputStream file = new FileInputStream(
					"C:\\Users\\ADMIN\\eclipse-workspace\\OnlineBookStore\\src\\test\\java\\properties\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException a) {
			a.printStackTrace();
		}
	}

}
