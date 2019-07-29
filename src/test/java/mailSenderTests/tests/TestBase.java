package mailSenderTests.tests;

import mailSenderTests.app.ApplicationManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.BrowserType;


public class TestBase {

	protected static  ApplicationManager app;

	@BeforeClass
	public static void setUp()  {
		if (app==null || !app.isValid()){
			System.out.println("BROWSER "+System.getProperty("browser"));
			app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
			app.init();
		}
	}

	@AfterClass
	public static void tearDown(){
		app.quit();
	}
}
