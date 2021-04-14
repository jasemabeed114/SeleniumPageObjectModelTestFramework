package library;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
/*
 * Class has initialSetupPage and browserSelection methods
 * browserSelection() - takes browser choice as input and intializes that browser
 * initialSetupPage() - will set properties from config.properties 
 */

public class SetupPage {
	
	public static WebDriver driver;
	public static Properties CONFIG =null;
	public static String test_url =null;
	//public static String testDataPath;
	public static String wkSheetName;
	
	
	public static void initialSetupPage() {
		CONFIG= new Properties();
		try{
			FileInputStream fs = new FileInputStream("src\\config\\config.properties");
			CONFIG.load(fs);
			}catch(Exception e){
				return;
			}
		
		 test_url= CONFIG.getProperty("testPageUrl");
		 wkSheetName= CONFIG.getProperty("wkSheetName");
		 
		driver.get(test_url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	public static void browserSelection(String browser) throws Exception {
		try {
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", "C:\\Softwares\\IEDriver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			
		}
		}catch(Exception e){
			return;
		}
		
	}

}
