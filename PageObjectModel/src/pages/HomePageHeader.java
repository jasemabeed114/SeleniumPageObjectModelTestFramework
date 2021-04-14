package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.SetupPage;

public class HomePageHeader extends SetupPage {

	@FindBy(xpath="//span[@class='b_a b_r']//span[text()='Account']")
	private static WebElement account;
	
	@FindBy(xpath="//input[@type='text' and @class='i_a bh_b header-GlobalSearch-input mweb-Typeahead-input i_b']")
	private static WebElement searchBar;
	
	@FindBy(xpath="//img[@src='//i5.walmartimages.com/dfw/63fd9f59-392b/48a699e6-5299-4b55-8895-28b7af730df3/v1/caret-down-black.5d3320ad009f3bcb0c940ed92c776cce3840db43.svg']")
	private static WebElement searchBarDropDown;

	@FindBy(xpath="//button[@class='g_a aw_c g_c' and @id='header-Header-sparkButton']")
	private static WebElement menuDropDown;
	
	@FindBy(xpath="//span[@class='p_a p_w p_ax p_m p_c x_a x_i']//span[text()='Local Store']")
	private static WebElement menuLocalStore;
	
	@FindBy(xpath="//button[@aria-label='Close Navigation Menu' and @id='spark-menu-close-button']")
	private static WebElement menuCloseNavigation;
	
	public HomePageHeader(WebDriver driver){
		SetupPage.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public static WebElement getAccount() {
		return account;
	}
	public static WebElement getSearchBar() {
		return searchBar;
	}
	public static WebElement getSearchBarDropDown() {
		return searchBarDropDown;
	}
	public static WebElement getMenuDropDown() {
		return menuDropDown;
	}
	public static WebElement getMenuLocalStore() {
		return menuLocalStore;
	}
	public static WebElement getMenuCloseNavigation() {
		return menuCloseNavigation;
	}
	
}
