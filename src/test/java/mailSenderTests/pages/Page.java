package mailSenderTests.pages;

import mailSenderTests.utils.PageNotLoadedException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.logging.Logger;

public abstract class Page {

	protected static WebDriver driver;
	protected static final Logger log = Logger.getLogger(Page.class.getName());

	public abstract boolean isOnThisPage();

	public Page(WebDriver driver, String pageName) {
		this.driver = driver;
		init(pageName);
	}

	public Page(String pageName) {
		init(pageName);
	}

	protected void init(final String pageName) {
		if (!isOnThisPage())
			throw new PageNotLoadedException("timeout. " + pageName + " isn't loaded!");
	}

	public boolean isElementPresent(By by) {
		return driver.findElements(by).size() > 0;
	}

	public void setValue(By by, String value) {
		driver.findElement(by).clear();
		driver.findElement(by).click();
		driver.findElement(by).sendKeys(value);
		log.info("set to " + by + " value = " + value);
	}
	public void sendKeys(By by, String value) {
		driver.findElement(by).sendKeys(value);
		log.info("set to " + by + " value = " + value);
	}

	public void click(By by) {
		driver.findElement(by).click();
		log.info("click " + by);
	}

	public void clickTryTwice(By by) {
		try {
			click(by);
		} catch (StaleElementReferenceException e) {
			log.info("second try to click " + by);
			click(by);
		}
		log.info("click by " + by);
	}

	public String getAttribute(By by, String attribute) {
		return driver.findElement(by).getAttribute(attribute);
	}

	public String getText(By by) {
		return driver.findElement(by).getText();
	}

	public String getText(By by, By childBy) {
		return driver.findElement(by).findElement(childBy).getText();
	}

	public void mouseTo(By by) {
		Actions actions = new Actions(driver);
		try {
			actions.moveToElement(driver.findElement(by)).build().perform();
		} catch (StaleElementReferenceException e) {
			log.info("second try to mouse move " + by);
			actions.moveToElement(driver.findElement(by)).build().perform();
		}
	}

	public void clickCntlEnter(By by){
		String keysPressed =  Keys.chord(Keys.CONTROL, Keys.RETURN);
		driver.findElement(by).sendKeys(keysPressed);
	}

	public void switchToFrame(By frame) {
		driver.switchTo().frame(driver.findElement(frame));
	}

	protected void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
}
