package mailSenderTests.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tngtech.java.junit.dataprovider.DataProvider;
import mailSenderTests.model.Letter;
import mailSenderTests.utils.PropertyReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataProviders {

	@DataProvider
	public static Iterable<Letter> lettersFromJson() throws IOException {
		String dataFile=PropertyReader.getInstance().getProperty("lettersData");
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(dataFile)))) {
			String json = "";
			String line = reader.readLine();
			while (line != null) {
				json += line;
				line = reader.readLine();
			}
			Gson gson = new Gson();
			List<Letter> letters = gson.fromJson(json, new TypeToken<List<Letter>>() {}.getType()); //List<Letter>.class
			return letters;
		}
	}
}
