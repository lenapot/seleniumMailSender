package mailSenderTests.pages;

import mailSenderTests.model.Letter;
import org.openqa.selenium.By;

public class SentLetterListPage extends MainHead {

	private static By sentLinkActive = By.cssSelector("div.b-nav__item_active a[href='/messages/sent/']");
	private static By lastLetterTo = By.xpath("(//div[@id='b-letters']//div[contains(@class, 'b-datalist_letters_compact_to')]//div[@data-bem='b-datalist__item'])[1]//div[@class='b-datalist__item__addr']");
	private static By lastLetterSubject = By.xpath("(//div[@id='b-letters']//div[contains(@class, 'b-datalist_letters_compact_to')]//div[@data-bem='b-datalist__item'])[1]//div[@class='b-datalist__item__subj']");

	public SentLetterListPage() {
		super("Sent letters list page");
	}

	@Override
	public boolean isOnThisPage() {
		return isElementPresent(sentLinkActive);
	}

	public Letter getLastLetter(){
		Letter last = new Letter();
		last.setTo(getText(lastLetterTo));
		last.setSubject(getSubject());
		return last;
	}

	private String getSubject(){
		String allText = getText(lastLetterSubject);
		return allText;
		//String childText = getText(lastLetterSubject, By.xpath("./span"));
		//return allText.substring(0, allText.lastIndexOf(childText));

	}

}
