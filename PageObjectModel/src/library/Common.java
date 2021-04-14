package library;

import org.openqa.selenium.WebElement;

public class Common extends SetupPage{

	public static String validatePageTitle(){
		return driver.getTitle();
	}
	
	
	
	
	public static void clickElement(WebElement e) {
		e.click();
	}
	
	
	
}
