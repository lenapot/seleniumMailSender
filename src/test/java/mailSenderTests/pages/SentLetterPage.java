package mailSenderTests.pages;

import org.openqa.selenium.By;

public class SentLetterPage extends Page {
	private static By sent = By.cssSelector(".message-sent__title");

	public SentLetterPage() {
		super("Sent letter page");
	}

	public boolean isOnThisPage() {
		return isElementPresent(sent);
	}
}
