package mailSenderTests.app;

import mailSenderTests.model.Letter;
import mailSenderTests.pages.MailBoxPage;
import mailSenderTests.pages.MainPage;
import mailSenderTests.utils.PropertyReader;
import mailSenderTests.utils.UnrecognizedBrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
	private WebDriver driver;

	private MainPage mainPage;
	private MailBoxPage mailBoxPage;

	private String browser;

	public ApplicationManager(String browser) {
		this.browser = browser;
	}

	public void init() {

		switch (browser) {
			case BrowserType.FIREFOX:
				driver = new FirefoxDriver();
				break;
			case BrowserType.CHROME:
				driver = new ChromeDriver();
				break;
			case BrowserType.IE:
				driver = new InternetExplorerDriver();
				break;
			default:
				throw new UnrecognizedBrowserException("UnrecognizedBrowserException " + browser);
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get(PropertyReader.getInstance().getProperty("baseUrl"));

		mainPage = new MainPage(driver);
		mailBoxPage = mainPage.login(PropertyReader.getInstance().getProperty("login"),
				PropertyReader.getInstance().getProperty("password"));

	}

	public boolean isValid() {
		try {
			driver.getCurrentUrl();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void ensureLogin() {
		if (!mainPage.isLoggined()) {
			mailBoxPage = mainPage.login(PropertyReader.getInstance().getProperty("login"),
					PropertyReader.getInstance().getProperty("password"));
		}
	}

	public void quit() {
		driver.quit();
	}

	public void createLetter(Letter letter) {
		mailBoxPage.open().clickNewLetter().sendEmail(letter);

	}
	public int getSentCount(){
		return mailBoxPage.open().getSentCount();
	}

	public Letter getLastLetter(){
		return mailBoxPage.open().getLastLetter();
	}


}
