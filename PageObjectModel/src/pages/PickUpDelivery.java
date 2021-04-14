package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.SetupPage;

public class PickUpDelivery extends SetupPage {
	
	@FindBy(xpath="//div[@id='header-tabs-sparkmenu']//span[contains(text(),'Pickup & delivery')]")
	private static WebElement pickUpDelivery;
	
	@FindBy(xpath="//div[@class='OnboardingModal__modalContainer___1InwJ']\\\\h1[@class='OnboardingModal__modalTitle___5Oh04' and text()='New to Walmart?']")
	private static WebElement popUpTitle;
	
	@FindBy(xpath="//div[@class='OnboardingModal__buttonWrapper___1gGTV']//a[text()='Get started']")
	private static WebElement popUpGetStarted;
	
	public PickUpDelivery(WebDriver driver){
		SetupPage.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public static WebElement getPickUpDelivery() {
		return pickUpDelivery;
	}
	
	public static WebElement getPopUpTitle() {
		return popUpTitle;
	}
	
	public static WebElement getPopUpGetStarted() {
		return popUpGetStarted;
	}
}
