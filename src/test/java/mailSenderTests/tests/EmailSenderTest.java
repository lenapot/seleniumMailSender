package mailSenderTests.tests;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import mailSenderTests.model.Letter;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.assertTrue;

@RunWith(DataProviderRunner.class)
public class EmailSenderTest extends TestBase {

	@Test
	@UseDataProvider(value = "lettersFromJson", location = DataProviders.class)
	public void emailSendTest(Letter letter) {

		int sentCountBefore = app.getSentCount();
		app.createLetter(letter);
		int sentCountAfter = app.getSentCount();

		Letter last = app.getLastLetter();
		assertTrue (sentCountBefore +1 == sentCountAfter);
		assertTrue (letter.equals(last));
	}

}
