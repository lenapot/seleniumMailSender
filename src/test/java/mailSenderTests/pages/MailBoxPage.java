package mailSenderTests.pages;

import mailSenderTests.model.Letter;
import mailSenderTests.utils.PropertyReader;
import org.openqa.selenium.By;

public class MailBoxPage extends MainHead {
	private static By navigator = By.id("b-nav_folders");
	private static By newLetterButton = By.cssSelector("[data-name='compose']");
	private static By sentHref = By.xpath("//a[@href='/messages/sent/']");

	public MailBoxPage() {
		super("Mail page");
	}

	@Override
	public boolean isOnThisPage() {
		return isElementPresent(navigator);
	}

	public NewLetterPage clickNewLetter(){
		click(newLetterButton);
		return new NewLetterPage();
	}

	public int getSentCount(){
		openSentListPage();
		mouseTo(sentHref);
		String text = getAttribute(sentHref, "data-title");
		if (text == null){
			throw new RuntimeException("Unable to read set letterts count");
		}
		return Integer.parseInt(text.replaceAll("\\D+",""));
	}

	public MailBoxPage open(){
		if (!isOnThisPage()){
			driver.get(PropertyReader.getInstance().getProperty("inboxUrl"));
			return new MailBoxPage();
		}
		return this;
	}

	public SentLetterListPage openSentListPage(){
		clickTryTwice(sentHref);
		return new SentLetterListPage();
	}
	public Letter getLastLetter(){
		return openSentListPage().getLastLetter();
	}
}
