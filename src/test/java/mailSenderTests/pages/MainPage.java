package mailSenderTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends MainHead {

	private static By mailboxContainer = By.id("mailbox-container");
	private static By loginField = By.id("mailbox:login");
	private static By passwordField = By.id("mailbox:password");
	private static By submitButton = By.xpath("//*[@id = 'mailbox:submit']");

	public MainPage(WebDriver driver) {
		super(driver, "Main page");
	}

	public boolean isOnThisPage() {
		return isElementPresent(mailboxContainer);
	}

	public MailBoxPage login(String login, String password) {
		setValue(loginField, login);
		setValue(passwordField, password);
		click(submitButton);
		return new MailBoxPage();
	}

}
