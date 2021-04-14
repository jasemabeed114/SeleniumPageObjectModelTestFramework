package library;

import java.util.Iterator;
import java.util.Set;

/*
 * WindowHandle class has getWindowHandle().
 * getWindowHandle() - returns true if driver has switched to different window successfully.
 */

public class WindowHandle extends SetupPage {
	
	
	public static boolean getWindowHandle() {
		boolean bstatus;
		String MainWindow=driver.getWindowHandle();
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		
		while(i1.hasNext())
		{		
            String ChildWindow=i1.next();
            if(!MainWindow.equalsIgnoreCase(ChildWindow))
            {
            	driver.switchTo().window(ChildWindow);
            	bstatus= true;
            }else {
            	bstatus= false;
            }
		}
		if (bstatus=true) {
			System.out.println("Child window selected");
			return bstatus;
		}else {
			return bstatus;
		}
	}
}
