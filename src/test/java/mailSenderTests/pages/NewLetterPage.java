package mailSenderTests.pages;

import mailSenderTests.model.Letter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;
import java.util.Set;

public class NewLetterPage extends Page {

	private static By newLetterForm = By.name("Compose");
	private static By toField = By.xpath("//textarea[@data-original-name = 'To']");
	private static By subjectField = By.name("Subject");
	private static By iframeText = By.xpath("//iframe[contains(@id, 'composeEditor_ifr')]");
	private static By textField = By.id("tinymce");
	private static By fileData = By.cssSelector(".compose-attachments__input");
	private static By sendButton = By.xpath("//*[@class='b-sticky js-not-sticky']//div[@data-name='send']");

	public NewLetterPage() {
		super("New letter creation page");
	}
	public boolean isOnThisPage() {
		return isElementPresent(newLetterForm);
	}

	public SentLetterPage sendEmail(Letter letter){
		setValue(toField, letter.getTo());
		setFile(letter.getFiles());
		setValue(subjectField, letter.getSubject());
		setText(letter.getText());
		clickCntlEnter(subjectField);
		return new SentLetterPage();
	}

	private void setText(String text){
		switchToFrame(iframeText);
		setValue(textField, text);
		switchToDefaultContent();
	}

	private void setFile(Set<String> pathsToFile){
		if (pathsToFile == null || pathsToFile.isEmpty()) return;
		for (String path : pathsToFile) {
			File file = new File(path);
			sendKeys(fileData, file.getAbsolutePath());
		}
	}
}
