package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import library.SetupPage;

public class HeaderSearchIn extends SetupPage{

	@FindBy(xpath="//div[@class='b_a bf_f b_t']//span[@class='b_a bf_c b_r' and text()='Auto & Tire']")
	private static WebElement searchItemAutoTire;
	
	@FindBy(xpath="//div[@class='b_a bf_f b_t']//span[@class='b_a bf_c b_r' and text()='Beauty']")
	private static WebElement searchItemBeauty;
	
	@FindBy(xpath="//div[@class='b_a bf_f b_t']//span[@class='b_a bf_c b_r' and text()='Books']")
	private static WebElement searchItemBooks;
	
	@FindBy(xpath="//div[@class='b_a bf_f b_t']//span[@class='b_a bf_c b_r' and text()='Cell Phones']")
	private static WebElement searchItemCellPhones;
	
	public HeaderSearchIn(WebDriver driver){
		SetupPage.driver= driver;
		PageFactory.initElements(driver, this);
	}
}
