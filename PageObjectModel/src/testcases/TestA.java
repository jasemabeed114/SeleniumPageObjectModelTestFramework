package testcases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import library.Reports;
import library.SetupPage;
import library.WindowHandle;
import pages.PickUpDelivery;

@Listeners({Reports.class})

public class TestA extends SetupPage{
	private static final Logger logger = LogManager.getLogger(TestA.class.getName());
	
		@Test(priority=3)
		@Description("Verify Pop-Up Window")
		@Severity(SeverityLevel.NORMAL)
		@SuppressWarnings("unused")
		public void pickUpPageNavigation() {
		    
			boolean status;
			PickUpDelivery.getPickUpDelivery().click();
			status=WindowHandle.getWindowHandle();
			if (status=true) {
				logger.info("Pop Up came up successfully");
				PickUpDelivery.getPopUpGetStarted();
			}else {
				logger.info("Pop Up didn't open");
			}
		}
	
		@BeforeClass
		@Parameters("browser")
	    public static void beforeClass(String browser) throws Exception { 
	  	  try {
	  		
	  		  	DOMConfigurator.configure("src/log4j.xml");
	  		  	SetupPage.browserSelection(browser);
	  		  	SetupPage.initialSetupPage();
	  		  	new PickUpDelivery(driver) ;
	  	  
	  	  }catch(Exception e) {
	  		  return;
	  	  }
	    }
	  @AfterClass(alwaysRun=true)
	  public static void teardown() {
		  driver.quit();
	    }
	  
}
