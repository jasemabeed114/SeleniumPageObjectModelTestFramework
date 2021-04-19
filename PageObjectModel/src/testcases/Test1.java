package testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.log4j.LogManager;
//import org.apache.log4j.xml.DOMConfigurator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import library.Common;
import library.Reports;
import library.SetupPage;
import pages.HomePageHeader;


@Listeners({Reports.class})
public class Test1 extends SetupPage {
	
	 private static final Logger logger = LogManager.getLogger(Test1.class.getName());
	   
		  @Test(priority=1)
		  @Description("Verify title and Menu collapsible icon")
		  @Severity(SeverityLevel.BLOCKER)
		  public void homePageHeader() throws Exception {
			  try {
				  String homePagetitle=Common.validatePageTitle();
				  Assert.assertEquals(homePagetitle, "Walmart.com | Save Money. Live Better.");			  
				  HomePageHeader.getMenuDropDown().click();
				  if(HomePageHeader.getMenuLocalStore().isDisplayed()) {
					  HomePageHeader.getMenuCloseNavigation().click();
					  logger.info("Test Passed homePageHeader");
					  Assert.assertTrue(true);
				  }else {
					  Assert.fail();
					  logger.info("Test Failed homePageHeader");
				  }
							   
			  }catch (Exception e) {
				  System.out.println(e);
				  return;
			  }
		  }

		    
}
