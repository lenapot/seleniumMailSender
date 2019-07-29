package mailSenderTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class MainHead extends Page {
	private static By loginLink = By.xpath("//i[@id='PH_user-email' and not(contains(text(),'undefined'))]");

	public MainHead(String pageName) {
		super(pageName);
	}
	public MainHead(WebDriver driver, String pageName) {
		super(driver, pageName);
	}

	public boolean isLoggined() {
		return isElementPresent(loginLink);
	}
}
